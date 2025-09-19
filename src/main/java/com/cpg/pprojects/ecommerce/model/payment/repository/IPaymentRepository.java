package com.cpg.pprojects.ecommerce.model.payment.repository;

import com.cpg.pprojects.ecommerce.model.payment.model.Payment;

import java.util.List;

public interface IPaymentRepository {
    Payment findById(long id);
    List<Payment> findAll();
    Payment save(Payment payment);
    void delete(Payment payment);
}
