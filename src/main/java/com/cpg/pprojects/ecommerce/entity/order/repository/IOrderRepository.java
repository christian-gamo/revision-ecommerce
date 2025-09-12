package com.cpg.pprojects.ecommerce.entity.order.repository;

import com.cpg.pprojects.ecommerce.entity.order.model.Order;

import java.util.List;

public interface IOrderRepository {

    Order findById(long id);
    List<Order> findAll();
    Order save(Order order);
    void delete(Order order);

    double getTotalRevenue();

}
