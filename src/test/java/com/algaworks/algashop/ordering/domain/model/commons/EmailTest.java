package com.algaworks.algashop.ordering.domain.model.commons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void shouldCreateEmailWithValidValue() {
        String value = "pedro@email.com";

        Email email = new Email(value);

        assertEquals(value, email.value());
    }

    @Test
    void shouldThrowExceptionWhenEmailIsBlank() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Email("")
        );
    }

    @Test
    void shouldThrowExceptionWhenEmailHasInvalidFormat() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Email("pedro-email.com")
        );
    }

    @Test
    void shouldReturnCorrectStringRepresentation() {
        String value = "pedro@email.com";

        Email email = new Email(value);

        assertEquals(value, email.toString());
    }

    @Test
    void shouldBeEqualWhenUsingSameValue() {
        Email first = new Email("pedro@email.com");
        Email second = new Email("pedro@email.com");

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }
}