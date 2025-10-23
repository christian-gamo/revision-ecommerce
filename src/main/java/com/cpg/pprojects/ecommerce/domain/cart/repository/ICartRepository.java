package com.cpg.pprojects.ecommerce.domain.cart.repository;

import com.cpg.pprojects.ecommerce.domain.cart.model.Cart;

import java.util.List;
import java.util.Optional;

public interface ICartRepository {
    List<Cart> findAll();
    Optional<Cart> findById(Long id);
    Cart save(Cart cart);
    void delete(Cart cart);

    Cart findCartByEmail(String email);
    Cart findCartByEmailAndIdCart(String email, Long idCart);
    List<Cart> findCartsByIdProduct(Long idProduct);

}
