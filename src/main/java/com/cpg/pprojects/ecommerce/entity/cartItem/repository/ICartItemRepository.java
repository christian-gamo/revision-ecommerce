package com.cpg.pprojects.ecommerce.entity.cartItem.repository;

import com.cpg.pprojects.ecommerce.entity.cart.model.Cart;
import com.cpg.pprojects.ecommerce.entity.cartItem.model.CartItem;

import java.util.List;

public interface ICartItemRepository {
    CartItem findById(int id);
    List<CartItem> findAll();
    Cart save(Cart cart);
    void delete(Cart cart);

    CartItem findCartItemByIdProductAndIdCart(long idCart, long idProduct);
    void deleteCartItemByIdProduct(long idCart, long idProduct);
    void deleteAllByIdCart(long idCart);
}
