package com.algaworks.algashop.ordering.domain.model.valueobject;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BirthDateTest {

    @Test
    void shouldCreateBirthDateWithValidDate() {
        LocalDate date = LocalDate.of(1990, 5, 10);

        BirthDate birthDate = new BirthDate(date);

        assertEquals(date, birthDate.value());
    }

    @Test
    void shouldThrowExceptionWhenDateIsNull() {
        assertThrows(
                NullPointerException.class,
                () -> new BirthDate(null)
        );
    }

    @Test
    void shouldThrowExceptionWhenDateIsInFuture() {
        LocalDate futureDate = LocalDate.now().plusDays(1);

        assertThrows(
                IllegalArgumentException.class,
                () -> new BirthDate(futureDate)
        );
    }

    @Test
    void shouldReturnCorrectAge() {
        LocalDate birthDateValue = LocalDate.now().minusYears(30);

        BirthDate birthDate = new BirthDate(birthDateValue);

        assertEquals(30, birthDate.age());
    }

    @Test
    void shouldReturnCorrectAgeWhenBirthdayHasNotOccurredThisYear() {
        LocalDate birthDateValue = LocalDate.now()
                .minusYears(30)
                .plusDays(1);

        BirthDate birthDate = new BirthDate(birthDateValue);

        assertEquals(29, birthDate.age());
    }

    @Test
    void shouldReturnCorrectStringRepresentation() {
        LocalDate date = LocalDate.of(1990, 5, 10);

        BirthDate birthDate = new BirthDate(date);

        assertEquals("1990-05-10", birthDate.toString());
    }
}
