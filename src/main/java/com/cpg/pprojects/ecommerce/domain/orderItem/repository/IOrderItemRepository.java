package com.cpg.pprojects.ecommerce.domain.orderItem.repository;

import com.cpg.pprojects.ecommerce.domain.orderItem.model.OrderItem;

import java.util.List;

public interface IOrderItemRepository {
    OrderItem findById(Long id);
    List<OrderItem> findAll();
    OrderItem save(OrderItem orderItem);
    void delete(OrderItem orderItem);

}
