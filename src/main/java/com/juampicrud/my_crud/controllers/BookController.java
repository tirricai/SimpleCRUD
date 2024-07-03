package com.juampicrud.my_crud.controllers;

import com.juampicrud.my_crud.model.Book;
import com.juampicrud.my_crud.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/book")
    public long createBook(@RequestBody Book newBook) {
        return bookService.createBook(newBook);
    }
}
