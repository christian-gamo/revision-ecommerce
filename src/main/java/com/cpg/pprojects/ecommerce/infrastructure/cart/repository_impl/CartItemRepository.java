package com.cpg.pprojects.ecommerce.infrastructure.cart.repository_impl;

import com.cpg.pprojects.ecommerce.domain.cart.model.Cart;
import com.cpg.pprojects.ecommerce.domain.cartItem.model.CartItem;
import com.cpg.pprojects.ecommerce.domain.cartItem.repository.ICartItemRepository;
import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities.CartEntity;
import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities.CartItemEntity;
import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_repository.ICartItemJpaRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CartItemRepository implements ICartItemRepository {
    ICartItemJpaRepository cartItemJpaRepository;

    public CartItemRepository(ICartItemJpaRepository cartItemJpaRepository) {
        this.cartItemJpaRepository = cartItemJpaRepository;
    }

    @Override
    public Optional<CartItem> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<CartItem> findAll() {
        List<CartItemEntity> cartItemEntities = cartItemJpaRepository.findAll();

        if(cartItemEntities.isEmpty()){
            return Collections.emptyList();
        }


        return cartItemEntities
                .stream()
                .map(CartItemEntity::toCartItem)
                .toList();
    }

    @Override
    public CartItem save(CartItem cartItem) {
        return cartItemJpaRepository.save(new CartItemEntity(cartItem)).toCartItem();
    }

    @Override
    public void delete(CartItem cartItem) {
        cartItemJpaRepository.delete(new CartItemEntity(cartItem));
    }

    @Override
    public List<CartItem> findAllByCart(Cart cart){
        return cartItemJpaRepository.findAllByCart(new CartEntity(cart))
                .stream()
                .map(CartItemEntity::toCartItem)
                .toList();
    }

    @Override
    public CartItem findCartItemByIdCartAndIdProduct(Long idCart, Long idProduct) {
        return cartItemJpaRepository.findCartItemByIdCartAndIdProduct(idCart, idProduct).toCartItem();
    }

    @Override
    public void deleteCartItemByIdCartAndIdProduct(Long idCart, Long idProduct) {
        cartItemJpaRepository.deleteCartItemByIdCartAndIdProduct(idCart, idProduct);
    }

    @Override
    public void deleteAllByIdCart(Long idCart) {
        cartItemJpaRepository.deleteAllByIdCart(idCart);
    }

    @Override
    public void deleteById(Long id) {
        cartItemJpaRepository.deleteById(id);
    }
}
