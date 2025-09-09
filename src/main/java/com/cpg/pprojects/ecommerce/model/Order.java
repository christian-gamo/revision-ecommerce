package com.cpg.pprojects.ecommerce.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private long idOrder;
    private String email;
    private LocalDate orderDate;
    private String orderStatus;
    private double totalAmount;

    private List<OrderItem> orderItems = new ArrayList<>();
    private Address address;
    private Payment payment;

    public Order() {}

    public Order(
            long idOrder,
            String email,
            LocalDate orderDate,
            String orderStatus,
            double totalAmount,
            List<OrderItem> orderItems,
            Address address,
            Payment payment
    ) {
        this.idOrder = idOrder;
        this.email = email;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
        this.orderItems = orderItems;
        this.address = address;
        this.payment = payment;
    }


    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
