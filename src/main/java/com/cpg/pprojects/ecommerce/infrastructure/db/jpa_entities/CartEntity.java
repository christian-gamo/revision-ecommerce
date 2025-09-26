package com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "carts")
@NoArgsConstructor
@AllArgsConstructor
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCart;

    @OneToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @OneToMany(
            mappedBy = "cart",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            orphanRemoval = true
    )
    private List<CartItemEntity> cartItems = new ArrayList<>();

    private Double totalPrice = 0.0;
}
