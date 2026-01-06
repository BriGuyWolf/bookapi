package com.brian.bookapi.controller;

import com.brian.bookapi.model.Book;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final Map<Long, Book> books = new HashMap<>();
    private long nextId = 1;

    @GetMapping
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return books.get(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        Book newBook = new Book(nextId++, book.title(),
                book.author(), book.isbn(),
                book.publicationYear());
        books.put(newBook.id(), newBook);
        return newBook;
    }
}