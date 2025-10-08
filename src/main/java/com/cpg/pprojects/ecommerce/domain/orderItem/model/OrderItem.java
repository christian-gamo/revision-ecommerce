package com.cpg.pprojects.ecommerce.domain.orderItem.model;

import com.cpg.pprojects.ecommerce.domain.order.model.Order;
import com.cpg.pprojects.ecommerce.domain.product.model.Product;

public class OrderItem {
    private Long idOrderItem;
    private Integer quantity;
    private double discount;
    private double orderedProductPrice;

    private Product product;
    private Order order;

    public OrderItem() {}

    public OrderItem(
            Long idOrderItem,
            Integer quantity,
            double discount,
            double orderedProductPrice,
            Product product,
            Order order
    ) {
        this.idOrderItem = idOrderItem;
        this.quantity = quantity;
        this.discount = discount;
        this.orderedProductPrice = orderedProductPrice;
        this.product = product;
        this.order = order;
    }

    public Long getIdOrderItem() {
        return idOrderItem;
    }

    public void setIdOrderItem(Long idOrderItem) {
        this.idOrderItem = idOrderItem;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
