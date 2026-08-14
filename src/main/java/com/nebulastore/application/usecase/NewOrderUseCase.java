package com.nebulastore.application.usecase;

import com.nebulastore.domain.OrderNotifier;

public class NewOrderUseCase {

    private final OrderNotifier notifier;

    public NewOrderUseCase(OrderNotifier notifier) {
        this.notifier = notifier;
    }

    public void processOrder(String orderId, String telefono) {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException(
                "El orderId no puede ser nulo ni vacio");
        }
        notifier.sendNotification(telefono, "Pedido " + orderId + " recibido");
    }
}