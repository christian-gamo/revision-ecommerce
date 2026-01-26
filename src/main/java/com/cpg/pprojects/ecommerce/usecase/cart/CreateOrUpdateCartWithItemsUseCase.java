package com.cpg.pprojects.ecommerce.usecase.cart;

import com.cpg.pprojects.ecommerce.domain.cart.model.Cart;
import com.cpg.pprojects.ecommerce.domain.cart.repository.ICartRepository;
import com.cpg.pprojects.ecommerce.domain.cartItem.model.CartItem;
import com.cpg.pprojects.ecommerce.domain.cartItem.repository.ICartItemRepository;
import com.cpg.pprojects.ecommerce.domain.product.model.Product;
import com.cpg.pprojects.ecommerce.domain.product.repository.IProductRepository;
import com.cpg.pprojects.ecommerce.domain.user.model.User;
import com.cpg.pprojects.ecommerce.usecase.cart.dto.CartItemDTO;
import com.cpg.pprojects.ecommerce.usecase.common.ITransactionRunner;
import com.cpg.pprojects.ecommerce.usecase.exceptions.ResourceNotFoundException;

import java.util.List;

public class CreateOrUpdateCartWithItemsUseCase {
    private final ICartRepository  cartRepository;
    private final ICartItemRepository cartItemRepository;
    private final IProductRepository productRepository;
    private final ITransactionRunner  transactionRunner;

    public CreateOrUpdateCartWithItemsUseCase(
            ICartRepository cartRepository,
            ICartItemRepository cartItemRepository,
            IProductRepository productRepository,
            ITransactionRunner transactionRunner){
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
        this.transactionRunner = transactionRunner;
    }

    public String execute(List<CartItemDTO> cartItems, User user) {
        return transactionRunner.executeInTransaction(
                () -> createOrUpdateCartWithItems(cartItems, user)
        );
    }

    private String createOrUpdateCartWithItems(List<CartItemDTO> cartItems, User user) {

        // Check if an existing cart is available or create a new one
        Cart existingCart = cartRepository.findCartByEmail(user.getEmail());
        if (existingCart == null) {
            existingCart = new Cart();
            existingCart.setTotalPrice(0.00);
            existingCart.setUser(user);
            existingCart = cartRepository.save(existingCart);
        } else {
            // Clear all current items in the existing cart
            cartItemRepository.deleteAllByIdCart(existingCart.getIdCart());
        }

        double totalPrice = 0.00;

        // Process each item in the request to add to the cart
        for (CartItemDTO cartItemDTO : cartItems) {
            Long idProduct = cartItemDTO.getIdProduct();
            Integer quantity = cartItemDTO.getQuantity();

            Product product = productRepository.findById(idProduct)
                    .orElseThrow(() -> new ResourceNotFoundException("Product", "idProduct", idProduct));

            totalPrice += product.getSpecialPrice() * quantity;
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setCart(existingCart);
            cartItem.setQuantity(quantity);
            cartItem.setProductPrice(product.getSpecialPrice());
            cartItem.setDiscount(product.getDiscount());
            cartItemRepository.save(cartItem);
        }
        existingCart.setTotalPrice(totalPrice);
        cartRepository.save(existingCart);

        return "Cart created/updated with the new items successfully";
    }
}
