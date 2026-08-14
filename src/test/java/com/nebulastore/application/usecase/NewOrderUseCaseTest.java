package com.nebulastore.application.usecase;

import com.nebulastore.domain.OrderNotifier;
import com.nebulastore.domain.entity.Order;
import com.nebulastore.domain.repository.OrderRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@DisplayName("NewOrderUseCase procesamiento de pedidos")
class NewOrderUseCaseTest {

    @Test
    @DisplayName("Deberia guardar y notificar una vez cuando el pedido es valido y no existe")
    void shouldSaveAndNotifyWhenOrderIsValid() {
        OrderRepository repository = mock(OrderRepository.class);
        OrderNotifier notifier = mock(OrderNotifier.class);
        when(repository.findById("ORD-001")).thenReturn(Optional.empty());

        NewOrderUseCase useCase = new NewOrderUseCase(repository, notifier);

        useCase.processOrder("ORD-001", "+56912345678");

        verify(repository, times(1)).save(any(Order.class));
        verify(notifier, times(1))
                .sendNotification("+56912345678", "Pedido ORD-001 recibido");
    }

    @Test
    @DisplayName("Deberia lanzar IllegalStateException cuando el pedido ya existe")
    void shouldThrowWhenOrderAlreadyExists() {
        OrderRepository repository = mock(OrderRepository.class);
        OrderNotifier notifier = mock(OrderNotifier.class);
        when(repository.findById("ORD-001")).thenReturn(Optional.of(new Order("ORD-001")));

        NewOrderUseCase useCase = new NewOrderUseCase(repository, notifier);

        assertThrows(IllegalStateException.class,
                () -> useCase.processOrder("ORD-001", "+56912345678"));

        verify(repository, never()).save(any(Order.class));
        verify(notifier, never()).sendNotification(anyString(), anyString());
    }

    @Test
    @DisplayName("Deberia lanzar IllegalArgumentException cuando el orderId es nulo")
    void shouldThrowWhenOrderIdIsNull() {
        OrderRepository repository = mock(OrderRepository.class);
        OrderNotifier notifier = mock(OrderNotifier.class);
        NewOrderUseCase useCase = new NewOrderUseCase(repository, notifier);

        assertThrows(IllegalArgumentException.class,
                () -> useCase.processOrder(null, "+56912345678"));

        verify(notifier, never()).sendNotification(anyString(), anyString());
        verify(repository, never()).save(any(Order.class));
    }

    @Test
    @DisplayName("Deberia lanzar IllegalArgumentException cuando el orderId es vacio")
    void shouldThrowWhenOrderIdIsEmpty() {
        OrderRepository repository = mock(OrderRepository.class);
        OrderNotifier notifier = mock(OrderNotifier.class);
        NewOrderUseCase useCase = new NewOrderUseCase(repository, notifier);

        assertThrows(IllegalArgumentException.class,
                () -> useCase.processOrder("", "+56912345678"));
    }
}