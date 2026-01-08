package com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities;

import com.cpg.pprojects.ecommerce.domain.cartItem.model.CartItem;
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
    private Integer quantity;
    private double discount;
    private double productPrice;

    @ManyToOne
    @JoinColumn(name = "id_cart")
    private CartEntity cart;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private ProductEntity product;

    public CartItemEntity(CartItem cartItem) {
        this.idCartItem = cartItem.getIdCartItem();

        this.quantity = cartItem.getQuantity();
        this.discount = cartItem.getDiscount();
        this.productPrice = cartItem.getProduct().getPrice();

        this.cart = new CartEntity(cartItem.getCart());
        this.product = new ProductEntity(cartItem.getProduct());
    }

    public CartItem toCartItem() {
        return new CartItem(
                this.getIdCartItem(),
                this.getQuantity(),
                this.getDiscount(),
                this.getProductPrice(),
                this.cart.toCart(),
                this.product.toProduct()
        );
    }

}