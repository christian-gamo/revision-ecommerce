package com.cpg.pprojects.ecommerce.usecase.cart;

import com.cpg.pprojects.ecommerce.domain.cart.model.Cart;
import com.cpg.pprojects.ecommerce.domain.cart.repository.ICartRepository;
import com.cpg.pprojects.ecommerce.domain.cartItem.model.CartItem;
import com.cpg.pprojects.ecommerce.domain.cartItem.repository.ICartItemRepository;
import com.cpg.pprojects.ecommerce.domain.product.model.Product;
import com.cpg.pprojects.ecommerce.domain.product.repository.IProductRepository;
import com.cpg.pprojects.ecommerce.usecase.exceptions.APIException;
import com.cpg.pprojects.ecommerce.usecase.exceptions.ResourceNotFoundException;

public class UpdateProductInCartsUseCase {
    private final ICartRepository cartRepository;
    private final IProductRepository productRepository;
    private final ICartItemRepository cartItemRepository;

    public UpdateProductInCartsUseCase(
            ICartRepository cartRepository,
            IProductRepository productRepository,
            ICartItemRepository cartItemRepository
    ) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public void execute (Long idCart, Long idProduct){
        Cart cart = cartRepository.findById(idCart)
                .orElseThrow(() -> new ResourceNotFoundException("Cart", "idCart", idCart));

        Product product = productRepository.findById(idProduct)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "idProduct", idProduct));

        CartItem cartItem = cartItemRepository.findCartItemByIdCartAndIdProduct(idCart, idProduct);

        if (cartItem == null) {
            throw new APIException("Product " + product.getProductName() + " not available in the cart!!!");
        }

        //remove old price of product from cart
        double cartPrice = cart.getTotalPrice()
                - (cartItem.getProductPrice() * cartItem.getQuantity());

        //set new actual price from product into cartItem
        cartItem.setProductPrice(product.getSpecialPrice());

        //set new price of product into cart
        cart.setTotalPrice(cartPrice
                + (cartItem.getProductPrice() * cartItem.getQuantity()));

        cartItemRepository.save(cartItem);
    }
}
