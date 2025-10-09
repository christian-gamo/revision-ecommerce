package com.cpg.pprojects.ecommerce.domain.orderItem.repository;

import com.cpg.pprojects.ecommerce.domain.orderItem.model.OrderItem;

import java.util.List;
import java.util.Optional;

public interface IOrderItemRepository {
    Optional<OrderItem> findById(Long id);
    List<OrderItem> findAll();
    OrderItem save(OrderItem orderItem);
    void delete(OrderItem orderItem);

}
