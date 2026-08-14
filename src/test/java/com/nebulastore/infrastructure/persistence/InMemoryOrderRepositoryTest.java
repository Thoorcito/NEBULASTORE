package com.nebulastore.infrastructure.persistence;

import com.nebulastore.domain.entity.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("InMemoryOrderRepository")
class InMemoryOrderRepositoryTest {

    @Test
    @DisplayName("Deberia guardar y luego encontrar un Order por su id")
    void shouldSaveAndFindOrderById() {
        InMemoryOrderRepository repository = new InMemoryOrderRepository();
        Order order = new Order("ORD-001");

        repository.save(order);
        Optional<Order> found = repository.findById("ORD-001");

        assertTrue(found.isPresent());
        assertEquals("ORD-001", found.get().getId());
    }

    @Test
    @DisplayName("Deberia devolver Optional vacio cuando el id no existe")
    void shouldReturnEmptyWhenIdNotFound() {
        InMemoryOrderRepository repository = new InMemoryOrderRepository();

        Optional<Order> found = repository.findById("NO-EXISTE");

        assertTrue(found.isEmpty());
    }

    @Test
    @DisplayName("No deberia lanzar excepcion ni guardar nada cuando el order es nulo")
    void shouldDoNothingWhenOrderIsNull() {
        InMemoryOrderRepository repository = new InMemoryOrderRepository();

        repository.save(null);

        assertTrue(repository.findById("cualquier-id").isEmpty());
    }


    @Test
    @DisplayName("No deberia lanzar excepcion ni guardar nada cuando el id del order es nulo")
    void shouldDoNothingWhenOrderIdIsNull() {
        InMemoryOrderRepository repository = new InMemoryOrderRepository();
        Order orderWithNullId = mock(Order.class);
        when(orderWithNullId.getId()).thenReturn(null);

        repository.save(orderWithNullId);

        assertTrue(repository.findById("cualquier-id").isEmpty());
    }
}