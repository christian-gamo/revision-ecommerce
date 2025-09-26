package com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPayment;

    @OneToOne(mappedBy = "payment", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private OrderEntity order;

    @NotBlank
    @Size(min = 4, message = "Payment method must contain at least 4 characters")
    private String paymentMethod;

    private String idPgPayment;
    private String pgStatus;
    private String pgResponseMessage;

    private String pgName;


    public PaymentEntity(String paymentMethod, String idPgPayment, String pgStatus,
                         String pgResponseMessage, String pgName) {
        this.paymentMethod = paymentMethod;
        this.idPgPayment = idPgPayment;
        this.pgStatus = pgStatus;
        this.pgResponseMessage = pgResponseMessage;
        this.pgName = pgName;
    }
}
