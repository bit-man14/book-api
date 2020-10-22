package pl.coderslab.book.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.book.model.Book;
import pl.coderslab.book.repository.BookRepository;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private static final Logger log = LogManager.getLogger(BookController.class);
    private final BookService bookService;
    private final BookRepository bookRepository;
    
    public BookController(BookRepository bookRepository,BookService bookService) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }
    
    // Get all books
    @GetMapping
    @ResponseBody
    public List<Book> getListOfBooks() {
        log.info("GET - all");
        return bookRepository.findAll();
    }
    
    // Get by id
    @GetMapping("/{id}")
    @ResponseBody
    public List<Book> bookById(@PathVariable Long id) {
        log.info("Book id={}", id);
        return bookRepository.findAllById(id);
    }
    
    //add Book in JSON via POST
    @PostMapping
    public void addBook(@RequestBody Book newBook) {
        log.info("POST - addBook");
        bookRepository.save(newBook);
    }
    
    //PUT - update book {id} with new data
    @PutMapping("/{id}")
    void replaceBook(@RequestBody Book newBook,@PathVariable Long id) {
        log.info("PUT - update");
        
        bookService.update(newBook,id);
    }
    
    //delete book{id}
    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable Long id) {
        log.info("DELETE - id={}", id);
        bookRepository.deleteById(id);
    }
    
    @ModelAttribute("books")
    public List<Book> books() {
        return bookRepository.findAll();
    }
}
