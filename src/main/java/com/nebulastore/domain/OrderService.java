package com.nebulastore.domain;

public class OrderService {

    private final OrderNotifier notifier;

    public OrderService(OrderNotifier notifier) {
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