package com.cpg.pprojects.ecommerce.usecase.order.dto;

public class PaymentDTO {
    private Long idPayment;
    private String paymentMethod;
    private String pgPaymentId;
    private String pgStatus;
    private String pgResponseMessage;
    private String pgName;

    public PaymentDTO() {
    }

    public PaymentDTO(Long idPayment, String paymentMethod, String pgPaymentId,
                      String pgStatus, String pgResponseMessage, String pgName) {
        this.idPayment = idPayment;
        this.paymentMethod = paymentMethod;
        this.pgPaymentId = pgPaymentId;
        this.pgStatus = pgStatus;
        this.pgResponseMessage = pgResponseMessage;
        this.pgName = pgName;
    }

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

    public String getPgPaymentId() {
        return pgPaymentId;
    }

    public void setPgPaymentId(String pgPaymentId) {
        this.pgPaymentId = pgPaymentId;
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

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "idPayment=" + idPayment +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", pgPaymentId='" + pgPaymentId + '\'' +
                ", pgStatus='" + pgStatus + '\'' +
                ", pgResponseMessage='" + pgResponseMessage + '\'' +
                ", pgName='" + pgName + '\'' +
                '}';
    }
}
