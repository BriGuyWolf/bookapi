package com.brian.bookapi.model;

public record Book(
        Long id,
        String title,
        String author,
        String isbn,
        Integer publicationYear
) {
}
