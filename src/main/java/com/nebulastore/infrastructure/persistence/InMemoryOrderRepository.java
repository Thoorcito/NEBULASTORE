package com.nebulastore.infrastructure.persistence;

import com.nebulastore.domain.entity.Order;
import com.nebulastore.domain.repository.OrderRepository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryOrderRepository implements OrderRepository {

    private final Map<String, Order> storage = new ConcurrentHashMap<>();

    @Override
    public void save(Order order) {
        if (order != null && order.getId() != null) {
            storage.put(order.getId(), order);
        }
    }

    @Override
    public Optional<Order> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }
}