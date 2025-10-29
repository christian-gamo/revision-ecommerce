package com.cpg.pprojects.ecommerce.usecase.cart;

import com.cpg.pprojects.ecommerce.domain.cart.model.Cart;
import com.cpg.pprojects.ecommerce.domain.cart.repository.ICartRepository;
import com.cpg.pprojects.ecommerce.domain.cartItem.model.CartItem;
import com.cpg.pprojects.ecommerce.domain.cartItem.repository.ICartItemRepository;
import com.cpg.pprojects.ecommerce.usecase.common.ITransactionRunner;
import com.cpg.pprojects.ecommerce.usecase.exceptions.ResourceNotFoundException;

public class DeleteProductFromCartUseCase {
    private final ICartRepository cartRepository;
    private final ICartItemRepository cartItemRepository;
    private final ITransactionRunner transactionRunner;

    public DeleteProductFromCartUseCase(
            ICartRepository cartRepository,
            ICartItemRepository cartItemRepository,
            ITransactionRunner transactionRunner
    ) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.transactionRunner = transactionRunner;
    }

    public String execute(Long idCart, Long idProduct){
        return transactionRunner.executeInTransaction(
            () -> deleteProductFromCart(idCart, idProduct)
        );
    }

    private String deleteProductFromCart(Long idCart, Long idProduct) {
        Cart cart = cartRepository.findById(idCart)
                .orElseThrow(() -> new ResourceNotFoundException("Cart", "idCart", idCart));

        CartItem cartItem = cartItemRepository.findCartItemByIdCartAndIdProduct(idCart, idProduct);

        if (cartItem == null) {
            throw new ResourceNotFoundException("Product", "idProduct", idProduct);
        }

        cart.setTotalPrice(cart.getTotalPrice() -
                (cartItem.getProductPrice() * cartItem.getQuantity()));

        cartItemRepository.deleteCartItemByIdCartAndIdProduct(idCart, idProduct);

        return "Product " + cartItem.getProduct().getProductName() + " removed from the cart !";
    }
}
