package com.cpg.pprojects.ecommerce.domain.order.repository;

import com.cpg.pprojects.ecommerce.domain.order.model.Order;

import java.util.List;

public interface IOrderRepository {

    Order findById(Long id);
    List<Order> findAll();
    Order save(Order order);
    void delete(Order order);

    double getTotalRevenue();

}
