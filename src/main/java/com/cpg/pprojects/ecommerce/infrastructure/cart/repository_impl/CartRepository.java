package com.cpg.pprojects.ecommerce.infrastructure.cart.repository_impl;

import com.cpg.pprojects.ecommerce.domain.cart.model.Cart;
import com.cpg.pprojects.ecommerce.domain.cart.repository.ICartRepository;
import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities.CartEntity;
import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_repository.ICartJpaRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CartRepository implements ICartRepository {

    ICartJpaRepository cartJpaRepository;

    public CartRepository(ICartJpaRepository cartJpaRepository) {
        this.cartJpaRepository = cartJpaRepository;
    }

    @Override
    public List<Cart> findAll() {
        List<CartEntity> cartEntities = cartJpaRepository.findAll();

        if(cartEntities.isEmpty())
            return Collections.emptyList();

        return cartEntities
                .stream()
                .map(CartEntity::toCart)
                .toList();
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return cartJpaRepository.findById(id)
                .map(CartEntity::toCart);

    }

    @Override
    public Cart save(Cart cart) {
        return cartJpaRepository.save(new CartEntity(cart)).toCart();
    }

    @Override
    public void delete(Cart cart) {
        cartJpaRepository.delete(new CartEntity(cart));
    }

    @Override
    public Cart findCartByEmail(String email) {
        return cartJpaRepository.findCartByEmail(email).toCart();
    }

    @Override
    public Cart findCartByEmailAndIdCart(String email, Long idCart) {
        return cartJpaRepository.findCartByEmailAndIdCart(email, idCart).toCart();
    }

    @Override
    public List<Cart> findCartsByIdProduct(Long idProduct) {
        return cartJpaRepository.findCartsByIdProduct(idProduct)
                .stream()
                .map(CartEntity::toCart)
                .toList();
    }
}
