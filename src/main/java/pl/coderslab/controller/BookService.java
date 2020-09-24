package pl.coderslab.controller;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface BookService {
    List<Book> allBooks();
    Book bookById(Long id);
    void addBook(Book book);
    
    void deleteById(Long id);
    
    void update(Book book,Long id);
}
