package com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cart_items")
@NoArgsConstructor
@AllArgsConstructor
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCartItem;

    @ManyToOne
    @JoinColumn(name = "id_cart")
    private CartEntity cart;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private ProductEntity product;

    private Integer quantity;
    private double discount;
    private double productPrice;
}