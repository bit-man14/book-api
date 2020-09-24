package pl.coderslab.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private static final Logger log = LogManager.getLogger(BookController.class);
    private final BookService bookService;
    
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    // Get All
    @GetMapping("")
    public @ResponseBody
    List<Book> getListofBooks() {
        return bookService.allBooks();
    }
    
    // Get by id
    @GetMapping("/{id}")
    public Book bookById(@PathVariable Long id) {
        log.info("Book id={}", id);
        return bookService.bookById(id);
    }
    
    //add Book in JSON via POST
    @PostMapping("")
    public void addBook(@RequestBody Book newBook) {
        log.info("POST - addBook");
        bookService.addBook(newBook);
    }
    
    @PutMapping("/{id}")
    Book replaceBook(@RequestBody Book newBook, @PathVariable Long id) {

        return bookService.bookById(id);
//                .map(book -> {
//                    book.setIsbn(newBook.getIsbn());
//                    //book.setRole(newBook.getRole());
//                    return bookService.update(book,id);
//                })
//                .orElseGet(() -> {
//                    newBook.setId(id);
//                    return bookService.update(newBook);
//                });
    }

    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }
    
    
}
