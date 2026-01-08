package com.cpg.pprojects.ecommerce.infrastructure.db.jpa_repository;

import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities.CartEntity;
import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICartItemJpaRepository extends JpaRepository<CartItemEntity, Long> {

    List<CartItemEntity> findAllByCart(CartEntity cart);


    @Query("SELECT ci FROM CartItemEntity ci WHERE ci.cart.idCart = ?1 AND ci.product.idProduct = ?2")
    CartItemEntity findCartItemByIdCartAndIdProduct(Long idCart, Long idProduct);

    @Modifying
    @Query("DELETE FROM CartItemEntity ci WHERE ci.cart.idCart = ?1 AND ci.product.idProduct = ?2")
    void deleteCartItemByIdCartAndIdProduct(Long idCart, Long idProduct);

    @Modifying
    @Query("DELETE FROM CartItemEntity ci WHERE ci.cart.idCart = ?1")
    void deleteAllByIdCart(Long idCart);
}
