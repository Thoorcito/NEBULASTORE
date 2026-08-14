package com.nebulastore.domain.repository;

import com.nebulastore.domain.entity.Order;
import java.util.Optional;

public interface OrderRepository {
    void save(Order order);
    Optional<Order> findById(String id);
}