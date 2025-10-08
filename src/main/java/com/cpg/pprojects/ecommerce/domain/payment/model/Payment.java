package com.cpg.pprojects.ecommerce.domain.payment.model;

import com.cpg.pprojects.ecommerce.domain.order.model.Order;

public class Payment {
    private Long idPayment;
    private String paymentMethod;

    private String idPgPayment;
    private String pgStatus;
    private String pgResponseMessage;
    private String pgName;

    private Order order;

    public Payment() {}

    public Payment(
            Long idPayment,
            String paymentMethod,
            String pgStatus,
            String pgResponseMessage,
            String pgName,
            Order order
    ) {
        this.idPayment = idPayment;
        this.paymentMethod = paymentMethod;
        this.pgStatus = pgStatus;
        this.pgResponseMessage = pgResponseMessage;
        this.pgName = pgName;
        this.order = order;
    }

    public Payment(
            String paymentMethod,
            String idPgPayment,
            String pgStatus,
            String pgResponseMessage,
            String pgName
    ) {
        this.paymentMethod = paymentMethod;
        this.idPgPayment = idPgPayment;
        this.pgStatus = pgStatus;
        this.pgResponseMessage = pgResponseMessage;
        this.pgName = pgName;
    }

    // Getters and Setters

    public Long getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Long idPayment) {
        this.idPayment = idPayment;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getIdPgPayment() {
        return idPgPayment;
    }

    public void setIdPgPayment(String idPgPayment) {
        this.idPgPayment = idPgPayment;
    }

    public String getPgStatus() {
        return pgStatus;
    }

    public void setPgStatus(String pgStatus) {
        this.pgStatus = pgStatus;
    }

    public String getPgResponseMessage() {
        return pgResponseMessage;
    }

    public void setPgResponseMessage(String pgResponseMessage) {
        this.pgResponseMessage = pgResponseMessage;
    }

    public String getPgName() {
        return pgName;
    }

    public void setPgName(String pgName) {
        this.pgName = pgName;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}