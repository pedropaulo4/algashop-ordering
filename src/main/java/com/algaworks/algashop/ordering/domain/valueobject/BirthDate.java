package com.algaworks.algashop.ordering.domain.valueobject;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public record BirthDate(LocalDate value) {

    public BirthDate {
        Objects.requireNonNull(value);
        if (value.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public Integer age() {
        return Period.between(value, LocalDate.now()).getYears();

    }
}
