package com.cpg.pprojects.ecommerce.usecase.order.dto;

import com.cpg.pprojects.ecommerce.usecase.product.ProductDTO;

public class OrderItemDTO {
    private Long idOrderItem;
    private ProductDTO product;
    private Integer quantity;
    private double discount;
    private double orderedProductPrice;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Long idOrderItem, ProductDTO product, Integer quantity,
                        double discount, double orderedProductPrice) {
        this.idOrderItem = idOrderItem;
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
        this.orderedProductPrice = orderedProductPrice;
    }

    public Long getIdOrderItem() {
        return idOrderItem;
    }

    public void setIdOrderItem(Long idOrderItem) {
        this.idOrderItem = idOrderItem;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
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

    public double getOrderedProductPrice() {
        return orderedProductPrice;
    }

    public void setOrderedProductPrice(double orderedProductPrice) {
        this.orderedProductPrice = orderedProductPrice;
    }

    @Override
    public String toString() {
        return "OrderItemDTO{" +
                "idOrderItem=" + idOrderItem +
                ", product=" + product +
                ", quantity=" + quantity +
                ", discount=" + discount +
                ", orderedProductPrice=" + orderedProductPrice +
                '}';
    }
}