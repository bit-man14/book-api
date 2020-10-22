package pl.coderslab.book.service;

import org.springframework.stereotype.Component;
import pl.coderslab.book.model.Book;

import java.util.List;

@Component
public interface BookService {
    List<Book> getBooks();

    List<Book> bookById(Long id);

    void add(Book book);

    void update(Book book,Long id);

    void deleteById(Long id);
}
