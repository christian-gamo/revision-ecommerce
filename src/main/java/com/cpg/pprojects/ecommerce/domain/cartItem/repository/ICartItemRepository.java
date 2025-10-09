package com.cpg.pprojects.ecommerce.domain.cartItem.repository;

import com.cpg.pprojects.ecommerce.domain.cart.model.Cart;
import com.cpg.pprojects.ecommerce.domain.cartItem.model.CartItem;

import java.util.List;
import java.util.Optional;

public interface ICartItemRepository {
    Optional<CartItem> findById(Long id);
    List<CartItem> findAll();
    Cart save(Cart cart);
    void delete(Cart cart);

    CartItem findCartItemByIdProductAndIdCart(Long idCart, Long idProduct);
    void deleteCartItemByIdProduct(Long idCart, Long idProduct);
    void deleteAllByIdCart(Long idCart);
}
