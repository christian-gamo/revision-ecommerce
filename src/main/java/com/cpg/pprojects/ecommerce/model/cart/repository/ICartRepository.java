package com.cpg.pprojects.ecommerce.model.cart.repository;

import com.cpg.pprojects.ecommerce.model.cart.model.Cart;

import java.util.List;

public interface ICartRepository {
    List<Cart> findAll();
    Cart findById(long id);
    Cart save(Cart cart);
    void delete(Cart cart);

    Cart findCartByEmail(String email);
    Cart findCartByEmailAndIdCart(String email, int idCart);
    List<Cart> findCartsByIdProduct(long idProduct);

}
