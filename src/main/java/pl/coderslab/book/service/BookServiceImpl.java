package pl.coderslab.book.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.book.entity.Book;
import pl.coderslab.book.repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    @Override
    @Transactional
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
    
    @Override
    @Transactional
    public void saveBook(Book book) {
        bookRepository.save(book);
    }
    
    
    @Override
    @Transactional
    public Book getBook(long id) throws ResourceNotFoundException {
        return bookRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.valueOf(id)));
    }
    
    @Override
    @Transactional
    public void deleteBook(long id) throws ResourceNotFoundException {
        bookRepository.deleteById(id);
    }
    
    @Override
    public List<Book> findAllByAuthorOrTitle(String author, String title) {
        return bookRepository.findAllByAuthorOrTitle(author, title);
    }
    
}
