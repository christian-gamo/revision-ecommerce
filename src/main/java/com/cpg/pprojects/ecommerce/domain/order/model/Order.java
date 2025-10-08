package com.cpg.pprojects.ecommerce.domain.order.model;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;
import com.cpg.pprojects.ecommerce.domain.orderItem.model.OrderItem;
import com.cpg.pprojects.ecommerce.domain.payment.model.Payment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long idOrder;
    private String email;
    private LocalDate orderDate;
    private String orderStatus;
    private Double totalAmount;

    private List<OrderItem> orderItems = new ArrayList<>();
    private Address address;
    private Payment payment;

    public Order() {}

    public Order(
            Long idOrder,
            String email,
            LocalDate orderDate,
            String orderStatus,
            Double totalAmount,
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


    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
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

    public String getOrderStatus() { return orderStatus; }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
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
