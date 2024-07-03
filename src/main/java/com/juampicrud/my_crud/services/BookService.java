package com.juampicrud.my_crud.services;

import com.juampicrud.my_crud.model.Book;
import com.juampicrud.my_crud.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public long createBook(Book newBook) {
       return bookRepository.createBook(newBook);
    }
}
