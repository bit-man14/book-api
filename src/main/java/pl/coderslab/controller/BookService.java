package pl.coderslab.controller;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface BookService {
    List<Book> allBooks();
    
    Optional<Book> bookById(Long id);
    
    void addBook(Book book);
    
    void deleteById(Long id);
    
    Optional<Book> update(Book book, Long id);
}
