package com.cpg.pprojects.ecommerce.model.order.repository;

import com.cpg.pprojects.ecommerce.model.order.model.Order;

import java.util.List;

public interface IOrderRepository {

    Order findById(long id);
    List<Order> findAll();
    Order save(Order order);
    void delete(Order order);

    double getTotalRevenue();

}
