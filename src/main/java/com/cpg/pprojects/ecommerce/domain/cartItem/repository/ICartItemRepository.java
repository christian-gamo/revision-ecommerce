package com.cpg.pprojects.ecommerce.domain.cartItem.repository;

import com.cpg.pprojects.ecommerce.domain.cart.model.Cart;
import com.cpg.pprojects.ecommerce.domain.cartItem.model.CartItem;

import java.util.List;
import java.util.Optional;

public interface ICartItemRepository {
    Optional<CartItem> findById(Long id);
    List<CartItem> findAll();
    Cart save(CartItem cart);
    void delete(CartItem cart);

    CartItem findCartItemByIdCartAndIdProduct(Long idCart, Long idProduct);
    void deleteCartItemByIdProduct(Long idCart, Long idProduct);
    void deleteAllByIdCart(Long idCart);
}
