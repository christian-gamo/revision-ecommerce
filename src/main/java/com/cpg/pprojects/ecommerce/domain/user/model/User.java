package com.cpg.pprojects.ecommerce.domain.user.model;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;
import com.cpg.pprojects.ecommerce.domain.cart.model.Cart;
import com.cpg.pprojects.ecommerce.domain.product.model.Product;
import com.cpg.pprojects.ecommerce.domain.role.model.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class User {
    private Long idUser;
    private String username;
    private String email;
    private String password;

    private Set<Role> roles;
    private List<Address> addresses = new ArrayList<>();
    private Cart cart;
    private Set<Product> products;

    public User(){}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
