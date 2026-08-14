package com.nebulastore.application.usecase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.nebulastore.domain.OrderNotifier;

import static org.mockito.ArgumentMatchers.anyString;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

@DisplayName("NewOrderUseCase  procesamiento de pedidos")
class NewOrderUseCaseTest {

    @Test
    @DisplayName("Deberia notificar una vez cuando el pedido es valido")
    void shouldNotifyWhenOrderIsValid() {
        // Arrange: creamos un notifier falso (mock)
        OrderNotifier notifier = mock(OrderNotifier.class);
        NewOrderUseCase service = new NewOrderUseCase(notifier);

        // Act
        service.processOrder("ORD-001", "+56912345678");

        // Assert: verificamos que se llamo sendNotification exactamente 1 vez
        verify(notifier, times(1))
                .sendNotification("+56912345678", "Pedido ORD-001 recibido");
    }

    @Test
    @DisplayName("Deberia lanzar IllegalArgumentException cuando el orderId es nulo")
    void shouldThrowWhenOrderIdIsNull() {
        // Arrange
        OrderNotifier notifier = mock(OrderNotifier.class);
        NewOrderUseCase service = new NewOrderUseCase(notifier);

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> service.processOrder(null, "+56912345678"));

        // Assert extra: si fallo, NO debe haber notificado
        verify(notifier, never()).sendNotification(anyString(), anyString());
    }

    @Test
    @DisplayName("Deberia lanzar IllegalArgumentException cuando el orderId es vacio")
    void shouldThrowWhenOrderIdIsEmpty() {
        // Arrange
        OrderNotifier notifier = mock(OrderNotifier.class);
        NewOrderUseCase service = new NewOrderUseCase(notifier);

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> service.processOrder("", "+56912345678"));
    }
}