package com.cpg.pprojects.ecommerce.usecase.order.dto;

public class OrderRequestDTO {
    private Long idAddress;
    private String paymentMethod;
    private String pgName;
    private String idPgPayment;
    private String pgStatus;
    private String pgResponseMessage;

    public OrderRequestDTO() {
    }

    public OrderRequestDTO(Long idAddress, String paymentMethod, String pgName,
                           String idPgPayment, String pgStatus, String pgResponseMessage) {
        this.idAddress = idAddress;
        this.paymentMethod = paymentMethod;
        this.pgName = pgName;
        this.idPgPayment = idPgPayment;
        this.pgStatus = pgStatus;
        this.pgResponseMessage = pgResponseMessage;
    }

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPgName() {
        return pgName;
    }

    public void setPgName(String pgName) {
        this.pgName = pgName;
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

    @Override
    public String toString() {
        return "OrderRequestDTO{" +
                "idAddress=" + idAddress +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", pgName='" + pgName + '\'' +
                ", idPgPayment='" + idPgPayment + '\'' +
                ", pgStatus='" + pgStatus + '\'' +
                ", pgResponseMessage='" + pgResponseMessage + '\'' +
                '}';
    }
}
