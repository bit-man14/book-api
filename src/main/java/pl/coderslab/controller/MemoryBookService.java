package pl.coderslab.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;


@Component
public class MemoryBookService implements BookService {
    private static final Logger log = LogManager.getLogger(MemoryBookService.class);
    private List<Book> books;
    
    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        books.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }
    
    //GET /books    OK
    public List<Book> allBooks() {
        return books;
    }
    
    //GET /books/{id}   OK
    public Optional<Book> bookById(Long id) {
        log.info("Searching for book id={}", id);
        return books.stream().filter(e -> e.getId().equals(id)).findFirst();
    }
    
    
    //POST /books   OK
    public void addBook(Book book) {
        log.info("Creating new  book via POST-JSON");
        OptionalLong maxId = books.stream().mapToLong(Book::getId).max();
        Long nextId = maxId.getAsLong() + 1;
        book.setId(nextId);
        books.add(book);
    }
    
    //DELETE /books/{id}  OK
    public void deleteById(Long id) {
        
        Optional<Book> bookToDelete = books.stream()
                .filter(e -> e.getId().equals(id)).findFirst();
        log.info("Book to delete:", bookToDelete);
        if (!bookToDelete.isEmpty()) {
            books.remove(bookToDelete.get());
        }
    }
    
    //PUT - update existing book
    public Optional<Book> update(Book book, Long id) {
        Optional<Book> bookToUpdate = books.stream()
                .filter(e -> e.getId().equals(id)).findFirst();
        if (!bookToUpdate.isEmpty()) {
            book.setId(id);
            int indexOf = books.indexOf(this.bookById(id).get());
            
            books.set(indexOf, book);
        }
    
        return bookToUpdate;
    }
    
    
}
