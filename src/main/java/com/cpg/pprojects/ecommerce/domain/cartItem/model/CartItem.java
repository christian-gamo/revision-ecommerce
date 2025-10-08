package com.cpg.pprojects.ecommerce.domain.cartItem.model;

import com.cpg.pprojects.ecommerce.domain.cart.model.Cart;
import com.cpg.pprojects.ecommerce.domain.product.model.Product;

public class CartItem {
    private Long idCartItem;
    private Integer quantity;
    private double discount;
    private double productPrice;

    private Cart cart;
    private Product product;

    public CartItem() {}

    public CartItem(
            Long idCartItem,
            Integer quantity,
            double discount,
            double productPrice,
            Cart cart,
            Product product
    ) {
        this.idCartItem = idCartItem;
        this.quantity = quantity;
        this.discount = discount;
        this.productPrice = productPrice;
        this.cart = cart;
        this.product = product;
    }

    public Long getIdCartItem() {
        return idCartItem;
    }

    public void setIdCartItem(Long idCartItem) {
        this.idCartItem = idCartItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
