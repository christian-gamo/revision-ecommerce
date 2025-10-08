package com.cpg.pprojects.ecommerce.domain.cart.model;

import com.cpg.pprojects.ecommerce.domain.cartItem.model.CartItem;
import com.cpg.pprojects.ecommerce.domain.user.model.User;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Long idCart;
    private Double totalPrice = 0.0;

    private User user;
    private List<CartItem> cartItems = new ArrayList<>();

    public Cart() {}

    public Cart(Long idCart, User user,  List<CartItem> cartItems, Double totalPrice) {
        this.idCart = idCart;
        this.user = user;
        this.cartItems = cartItems;
        this.totalPrice = totalPrice;
    }

    public Long getIdCart() {
        return idCart;
    }

    public void setIdCart(Long idCart) {
        this.idCart = idCart;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
