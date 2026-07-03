package com.algaworks.algashop.ordering.domain.valueobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    @Test
    void shouldCreatePhoneWithValidValue() {
        String value = "62999999999";

        Phone phone = new Phone(value);

        assertEquals(value, phone.value());
    }

    @Test
    void shouldThrowExceptionWhenValueIsNull() {
        assertThrows(
                NullPointerException.class,
                () -> new Phone(null)
        );
    }

    @Test
    void shouldThrowExceptionWhenValueIsEmpty() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Phone("")
        );
    }

    @Test
    void shouldThrowExceptionWhenValueContainsOnlySpaces() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Phone("   ")
        );
    }

    @Test
    void shouldReturnCorrectStringRepresentation() {
        String value = "62999999999";

        Phone phone = new Phone(value);

        assertEquals(value, phone.toString());
    }

    @Test
    void shouldBeEqualWhenUsingSameValue() {
        Phone first = new Phone("62999999999");
        Phone second = new Phone("62999999999");

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    void shouldNotBeEqualWhenUsingDifferentValues() {
        Phone first = new Phone("62999999999");
        Phone second = new Phone("62888888888");

        assertNotEquals(first, second);
    }
}