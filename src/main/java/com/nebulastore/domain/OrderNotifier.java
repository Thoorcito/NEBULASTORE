package com.nebulastore.domain;

public interface OrderNotifier {
    void sendNotification(String telefono, String mensaje);
}