package com.algaworks.algashop.ordering.domain.valueobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FullNameTest {

    @Test
    void shouldCreateFullNameWithValidValues() {
        FullName fullName = new FullName("Pedro", "Bertolini");

        assertEquals("Pedro", fullName.firstName());
        assertEquals("Bertolini", fullName.lastName());
    }

    @Test
    void shouldThrowExceptionWhenFirstNameIsNull() {
        assertThrows(
                NullPointerException.class,
                () -> new FullName(null, "Bertolini")
        );
    }

    @Test
    void shouldThrowExceptionWhenLastNameIsNull() {
        assertThrows(
                NullPointerException.class,
                () -> new FullName("Pedro", null)
        );
    }

    @Test
    void shouldThrowExceptionWhenFirstNameIsBlank() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new FullName("   ", "Bertolini")
        );
    }

    @Test
    void shouldThrowExceptionWhenLastNameIsBlank() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new FullName("Pedro", "   ")
        );
    }

    @Test
    void shouldTrimNames() {
        FullName fullName = new FullName(
                "  Pedro  ",
                "  Bertolini  "
        );

        assertEquals("Pedro", fullName.firstName());
        assertEquals("Bertolini", fullName.lastName());
    }

    @Test
    void shouldReturnFullNameAsString() {
        FullName fullName = new FullName("Pedro", "Bertolini");

        assertEquals(
                "Pedro Bertolini",
                fullName.toString()
        );
    }

    @Test
    void shouldBeEqualWhenUsingSameValues() {
        FullName first = new FullName("Pedro", "Bertolini");
        FullName second = new FullName("Pedro", "Bertolini");

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }
}