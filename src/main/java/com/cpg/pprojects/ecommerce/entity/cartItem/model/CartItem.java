package com.cpg.pprojects.ecommerce.entity.cartItem.model;

import com.cpg.pprojects.ecommerce.entity.cart.model.Cart;
import com.cpg.pprojects.ecommerce.entity.product.model.Product;

public class CartItem {
    private long idCartItem;
    private int quantity;
    private double discount;
    private double productPrice;

    private Cart cart;
    private Product product;

    public long getIdCartItem() {
        return idCartItem;
    }

    public void setIdCartItem(long idCartItem) {
        this.idCartItem = idCartItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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
