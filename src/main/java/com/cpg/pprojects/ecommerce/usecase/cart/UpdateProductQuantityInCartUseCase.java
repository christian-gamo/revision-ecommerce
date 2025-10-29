package com.cpg.pprojects.ecommerce.usecase.cart;

import com.cpg.pprojects.ecommerce.domain.cart.model.Cart;
import com.cpg.pprojects.ecommerce.domain.cart.repository.ICartRepository;
import com.cpg.pprojects.ecommerce.domain.cartItem.model.CartItem;
import com.cpg.pprojects.ecommerce.domain.cartItem.repository.ICartItemRepository;
import com.cpg.pprojects.ecommerce.domain.product.model.Product;
import com.cpg.pprojects.ecommerce.domain.product.repository.IProductRepository;
import com.cpg.pprojects.ecommerce.usecase.cart.dto.CartDTO;
import com.cpg.pprojects.ecommerce.usecase.common.ITransactionRunner;
import com.cpg.pprojects.ecommerce.usecase.exceptions.APIException;
import com.cpg.pprojects.ecommerce.usecase.exceptions.ResourceNotFoundException;
import com.cpg.pprojects.ecommerce.usecase.product.ProductDTO;

import java.util.List;
import java.util.stream.Stream;

public class UpdateProductQuantityInCartUseCase {
    private final ICartRepository cartRepository;
    private final ICartItemRepository cartItemRepository;
    private final IProductRepository productRepository;
    private final ITransactionRunner transactionRunner;

    public UpdateProductQuantityInCartUseCase(
            ICartRepository cartRepository,
            IProductRepository productRepository,
            ICartItemRepository cartItemRepository,
            ITransactionRunner transactionRunner
    ) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
        this.transactionRunner = transactionRunner;
    }

    public CartDTO execute(String email, Long idProduct, Integer quantity) {
        return transactionRunner.executeInTransaction(
                () -> updateProductQuantityInCart(email, idProduct, quantity)
        );
    }

    private CartDTO updateProductQuantityInCart(String email, Long idProduct, Integer quantity){
        Cart userCart = cartRepository.findCartByEmail(email);
        Long idCart  = userCart.getIdCart();

        Cart cart = cartRepository.findById(idCart)
                .orElseThrow(() -> new ResourceNotFoundException("Cart", "idCart", idCart));

        Product product = productRepository.findById(idProduct)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "idProduct", idProduct));

        if (product.getQuantity() == 0) {
            throw new APIException(product.getProductName() + " is not available");
        }
        if (product.getQuantity() < quantity) {
            throw new APIException("Please, make an order of the " + product.getProductName()
                    + " less than or equal to the available quantity " + product.getQuantity() + ".");
        }

        CartItem cartItem = cartItemRepository.findCartItemByIdCartAndIdProduct(idCart, idProduct);

        if (cartItem == null) {
            throw new APIException("Product " + product.getProductName() + " not available in the cart!");
        }

        int newQuantity = cartItem.getQuantity() + quantity;
        if (newQuantity < 0) {
            throw new APIException("The resulting quantity cannot be negative.");
        }
        if (newQuantity == 0){
            cart.setTotalPrice(
                    cart.getTotalPrice() - (cartItem.getProductPrice() * cartItem.getQuantity())
            );
            cartItemRepository.deleteCartItemByIdCartAndIdProduct(idCart, idProduct);

        } else {
            cartItem.setProductPrice(product.getSpecialPrice());
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            cartItem.setDiscount(product.getDiscount());
            cart.setTotalPrice(cart.getTotalPrice() + (cartItem.getProductPrice() * quantity));
            cartRepository.save(cart);
        }

        CartItem updatedItem = cartItemRepository.save(cartItem);
        if(updatedItem.getQuantity() == 0){
            cartItemRepository.deleteById(updatedItem.getIdCartItem());
        }

        CartDTO cartDTO = new CartDTO(cart);
        List<CartItem> cartItems = cart.getCartItems();
        Stream<ProductDTO> productStream = cartItems.stream().map(item -> {
            ProductDTO prd = new ProductDTO(item.getProduct());
            prd.setQuantity(item.getQuantity());
            return prd;
        });
        cartDTO.setProducts(productStream.toList());

        return cartDTO;
    }
}
