package com.algaworks.algashop.ordering.domain.model.commons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentTest {

    @Test
    void shouldCreateDocumentWithValidValue() {
        String value = "12345678901";

        Document document = new Document(value);

        assertEquals(value, document.value());
    }

    @Test
    void shouldThrowExceptionWhenValueIsNull() {
        assertThrows(
                NullPointerException.class,
                () -> new Document(null)
        );
    }

    @Test
    void shouldThrowExceptionWhenValueIsEmpty() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Document("")
        );
    }

    @Test
    void shouldThrowExceptionWhenValueContainsOnlySpaces() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Document("   ")
        );
    }

    @Test
    void shouldReturnCorrectStringRepresentation() {
        String value = "12345678901";

        Document document = new Document(value);

        assertEquals(value, document.toString());
    }

    @Test
    void shouldBeEqualWhenUsingSameValue() {
        Document first = new Document("12345678901");
        Document second = new Document("12345678901");

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }
}