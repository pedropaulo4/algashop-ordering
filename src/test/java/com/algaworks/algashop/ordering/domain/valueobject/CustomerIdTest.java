package com.algaworks.algashop.ordering.domain.valueobject;

import com.algaworks.algashop.ordering.domain.valueobject.id.CustomerId;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CustomerIdTest {

    @Test
    void shouldCreateCustomerIdWithValidUuid() {
        UUID uuid = UUID.randomUUID();

        CustomerId customerId = new CustomerId(uuid);

        assertEquals(uuid, customerId.value());
    }

    @Test
    void shouldThrowExceptionWhenUuidIsNull() {
        assertThrows(
                NullPointerException.class,
                () -> new CustomerId(null)
        );
    }

    @Test
    void shouldGenerateCustomerIdWhenUsingDefaultConstructor() {
        CustomerId customerId = new CustomerId();

        assertNotNull(customerId.value());
    }

    @Test
    void shouldGenerateDifferentIds() {
        CustomerId first = new CustomerId();
        CustomerId second = new CustomerId();

        assertNotEquals(first.value(), second.value());
    }

    @Test
    void shouldReturnCorrectStringRepresentation() {
        UUID uuid = UUID.randomUUID();

        CustomerId customerId = new CustomerId(uuid);

        assertEquals(uuid.toString(), customerId.toString());
    }
}