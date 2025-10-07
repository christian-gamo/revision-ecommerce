package com.cpg.pprojects.ecommerce.usecase.cart.dto;

import com.cpg.pprojects.ecommerce.usecase.product.ProductDTO;
import java.util.ArrayList;
import java.util.List;

public class CartDTO {
    private Long idCart;
    private Double totalPrice = 0.0;
    private List<ProductDTO> products = new ArrayList<>();

    public CartDTO() {
    }

    public CartDTO(Long idCart, Double totalPrice, List<ProductDTO> products) {
        this.idCart = idCart;
        this.totalPrice = totalPrice;
        this.products = products;
    }

    public Long getIdCart() {
        return idCart;
    }

    public void setIdCart(Long idCart) {
        this.idCart = idCart;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "idCart=" + idCart +
                ", totalPrice=" + totalPrice +
                ", products=" + products +
                '}';
    }
}
