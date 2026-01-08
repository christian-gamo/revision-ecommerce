package com.cpg.pprojects.ecommerce.domain.cartItem.repository;

import com.cpg.pprojects.ecommerce.domain.cart.model.Cart;
import com.cpg.pprojects.ecommerce.domain.cartItem.model.CartItem;

import java.util.List;
import java.util.Optional;

public interface ICartItemRepository {
    Optional<CartItem> findById(Long id);
    List<CartItem> findAll();
    CartItem save(CartItem cart);
    void delete(CartItem cart);

    List<CartItem> findAllByCart(Cart cart);
    CartItem findCartItemByIdCartAndIdProduct(Long idCart, Long idProduct);
    void deleteCartItemByIdCartAndIdProduct(Long idCart, Long idProduct);
    void deleteAllByIdCart(Long idCart);
    void deleteById(Long id);
}
