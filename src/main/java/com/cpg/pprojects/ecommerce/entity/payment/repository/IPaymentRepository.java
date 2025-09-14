package com.cpg.pprojects.ecommerce.entity.payment.repository;

import com.cpg.pprojects.ecommerce.entity.payment.model.Payment;

import java.util.List;

public interface IPaymentRepository {
    Payment findById(long id);
    List<Payment> findAll();
    Payment save(Payment payment);
    void delete(Payment payment);
}
