package com.cpg.pprojects.ecommerce.domain.cart.repository;

import com.cpg.pprojects.ecommerce.domain.cart.model.Cart;

import java.util.List;

public interface ICartRepository {
    List<Cart> findAll();
    Cart findById(Long id);
    Cart save(Cart cart);
    void delete(Cart cart);

    Cart findCartByEmail(String email);
    Cart findCartByEmailAndIdCart(String email, int idCart);
    List<Cart> findCartsByIdProduct(Long idProduct);

}
