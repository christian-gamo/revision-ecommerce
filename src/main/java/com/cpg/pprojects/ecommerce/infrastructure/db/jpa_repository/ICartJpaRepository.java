package com.cpg.pprojects.ecommerce.infrastructure.db.jpa_repository;

import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICartJpaRepository extends JpaRepository<CartEntity,Long> {
    @Query("SELECT c FROM CartEntity c WHERE c.user.email = ?1")
    CartEntity findCartByEmail(String email);

    @Query("SELECT c FROM CartEntity c WHERE c.user.email = ?1 AND c.idCart = ?2")
    CartEntity findCartByEmailAndIdCart(String idEmail, Long idCart);

    @Query("SELECT c FROM CartEntity c JOIN FETCH c.cartItems ci JOIN FETCH ci.product p WHERE p.idProduct = ?1")
    List<CartEntity> findCartsByIdProduct(Long idProduct);
}
