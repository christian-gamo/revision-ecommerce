package com.cpg.pprojects.ecommerce.domain.payment.repository;

import com.cpg.pprojects.ecommerce.domain.payment.model.Payment;

import java.util.List;
import java.util.Optional;

public interface IPaymentRepository {
    Optional<Payment> findById(Long id);
    List<Payment> findAll();
    Payment save(Payment payment);
    void delete(Payment payment);
}
