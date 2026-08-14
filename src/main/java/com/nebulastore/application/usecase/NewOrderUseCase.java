package com.nebulastore.application.usecase;

import com.nebulastore.domain.OrderNotifier;
import com.nebulastore.domain.entity.Order;
import com.nebulastore.domain.repository.OrderRepository;

public class NewOrderUseCase {

    private final OrderRepository orderRepository;
    private final OrderNotifier notifier;

    public NewOrderUseCase(OrderRepository orderRepository, OrderNotifier notifier) {
        this.orderRepository = orderRepository;
        this.notifier = notifier;
    }

    public void processOrder(String orderId, String telefono) {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException(
                "El orderId no puede ser nulo ni vacio");
        }

        if (orderRepository.findById(orderId).isPresent()) {
            throw new IllegalStateException(
                "El pedido " + orderId + " ya se encuentra registrado");
        }

        orderRepository.save(new Order(orderId));
        notifier.sendNotification(telefono, "Pedido " + orderId + " recibido");
    }
}