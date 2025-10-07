package com.cpg.pprojects.ecommerce.usecase.cart.dto;

public class CartItemDTO {
    private Long idProduct;
    private Integer quantity;

    public CartItemDTO() {
    }

    public CartItemDTO(Long idProduct, Integer quantity) {
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItemDTO{" +
                "productId=" + idProduct +
                ", quantity=" + quantity +
                '}';
    }
}
