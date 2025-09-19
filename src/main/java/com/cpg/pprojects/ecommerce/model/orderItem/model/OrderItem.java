package com.cpg.pprojects.ecommerce.model.orderItem.model;

import com.cpg.pprojects.ecommerce.model.product.model.Product;
import com.cpg.pprojects.ecommerce.model.order.model.Order;

public class OrderItem {
    private long idOrderItem;
    private int quantity;
    private double discount;
    private double orderedProductPrice;

    private Product product;
    private Order order;

    public OrderItem() {}

    public OrderItem(
            long idOrderItem,
            int quantity,
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

    public long getIdOrderItem() {
        return idOrderItem;
    }

    public void setIdOrderItem(long idOrderItem) {
        this.idOrderItem = idOrderItem;
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
