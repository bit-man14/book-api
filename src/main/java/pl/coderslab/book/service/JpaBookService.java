package pl.coderslab.book.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.coderslab.book.model.Book;
import pl.coderslab.book.repository.BookRepository;

import java.util.List;


@Repository
@Primary
public class JpaBookService implements BookService {
    
    private final BookRepository bookRepository;
    
    public JpaBookService(BookRepository bookRepository) {
        
        this.bookRepository = bookRepository;
    }
    
    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
   
    
    @Override
    public void add(Book book) {
    
        bookRepository.save(book);
    }
    
    @Override
    public void deleteById(Long id) {
    
        bookRepository.deleteById(id);
    }
    
    @Override
    public void update(Book newBook, Long id) {
        Book updtBook=bookRepository.findAllById(id).stream().findFirst().get();
        updtBook.setAuthor(newBook.getAuthor());
        updtBook.setIsbn(newBook.getIsbn());
        updtBook.setPublisher(newBook.getPublisher());
        updtBook.setTitle(newBook.getTitle());
        updtBook.setType(newBook.getType());
        bookRepository.save(updtBook);
        
    }
    
  
    public List<Book> bookById(Long id) {
        
        return bookRepository.findAllById(id);
    }
    
}