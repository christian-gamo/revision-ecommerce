package com.cpg.pprojects.ecommerce.domain.cart.model;

import com.cpg.pprojects.ecommerce.domain.cartItem.model.CartItem;
import com.cpg.pprojects.ecommerce.domain.user.model.User;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Long idCart;
    private Double totalPrice = 0.0;

    private User user;

    public Cart() {}

    public Cart(Long idCart, Double totalPrice, User user) {
        this.idCart = idCart;
        this.totalPrice = totalPrice;
        this.user = user;
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
