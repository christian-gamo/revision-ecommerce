package com.cpg.pprojects.ecommerce.model.cartItem.repository;

import com.cpg.pprojects.ecommerce.model.cart.model.Cart;
import com.cpg.pprojects.ecommerce.model.cartItem.model.CartItem;

import java.util.List;

public interface ICartItemRepository {
    CartItem findById(long id);
    List<CartItem> findAll();
    Cart save(Cart cart);
    void delete(Cart cart);

    CartItem findCartItemByIdProductAndIdCart(long idCart, long idProduct);
    void deleteCartItemByIdProduct(long idCart, long idProduct);
    void deleteAllByIdCart(long idCart);
}
