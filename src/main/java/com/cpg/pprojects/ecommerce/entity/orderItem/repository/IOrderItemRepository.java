package com.cpg.pprojects.ecommerce.entity.orderItem.repository;

import com.cpg.pprojects.ecommerce.entity.orderItem.model.OrderItem;

import java.util.List;

public interface IOrderItemRepository {
    OrderItem findById(long id);
    List<OrderItem> findAll();
    OrderItem save(OrderItem orderItem);
    void delete(OrderItem orderItem);

}
