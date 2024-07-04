package com.juampicrud.my_crud.services;

import com.juampicrud.my_crud.model.Book;
import com.juampicrud.my_crud.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Book updateBook(Long id, Book updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setName(updatedBook.getName());
            bookRepository.updateBook(existingBook);
            return existingBook;
        } else {
            throw new RuntimeException("Book not found with id " + id);
        }
    }

    public void deleteBook(Long id) {
        bookRepository.deleteBook(id);
    }

}
