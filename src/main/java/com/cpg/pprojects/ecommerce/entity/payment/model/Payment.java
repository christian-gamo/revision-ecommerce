package com.cpg.pprojects.ecommerce.entity.payment.model;

import com.cpg.pprojects.ecommerce.entity.order.model.Order;

public class Payment {
    private long idPayment;
    private String paymentMethod;

    private String idPgPayment;
    private String pgStatus;
    private String pgResponseMessage;
    private String pgName;

    private Order order;

    public Payment() {}

    public Payment(
            long idPayment,
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
}
