package com.cpg.pprojects.ecommerce.domain.product.model;

import com.cpg.pprojects.ecommerce.domain.cartItem.model.CartItem;
import com.cpg.pprojects.ecommerce.domain.category.model.Category;
import com.cpg.pprojects.ecommerce.domain.user.model.User;

import java.util.List;

public class Product {
    private String idProduct;
    private String productName;
    private String description;
    private String image;
    private Integer quantity;
    private double price;
    private double specialPrice;
    private double discount;

    private Category category;
    private User user;
    private List<CartItem> cartItems;

    public Product() {}

    public Product(
            String idProduct,
            String productName,
            String description,
            String image,
            Integer quantity,
            double price,
            double specialPrice,
            double discount,
            Category category,
            User user,
            List<CartItem> cartItems
    ){
        this.idProduct = idProduct;
        this.productName = productName;
        this.description = description;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.specialPrice = specialPrice;
        this.discount = discount;
        this.category = category;
        this.user = user;
        this.cartItems = cartItems;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(double specialPrice) {
        this.specialPrice = specialPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
}
