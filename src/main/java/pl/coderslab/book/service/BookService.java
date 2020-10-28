package pl.coderslab.book.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import pl.coderslab.book.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    
    void saveBook(Book book);
    
    Book getBook(long id) throws ResourceNotFoundException;
    
    void deleteBook(long id) throws ResourceNotFoundException;
    
    List<Book> findAllByAuthorOrTitle(String author, String title);
    
}
