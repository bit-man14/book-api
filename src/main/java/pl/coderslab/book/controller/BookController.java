package pl.coderslab.book.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.book.entity.Book;
import pl.coderslab.book.service.BookService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private static final Logger log = LogManager.getLogger(BookController.class);
    
    private final BookService bookService;
    
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/list")
    public String allBooks(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        log.info("GET - all");
        return "list";
    }
    

//    @GetMapping("/addBook")
//    public String showFormForAdd(Model theModel) {
//        Book book = new Book();
//        theModel.addAttribute("book", book);
//        return "add";
//    }
    
    // Get by id
    @GetMapping("/{id}")
    @ResponseBody
    public Book bookById(@PathVariable Long id) {
        log.info("Book id={}", id);
        return bookService.getBook(id);
    }
    
    
    @GetMapping("/addBook")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add";
    }
    
    @PostMapping("/saveBook")
    public String add(@Valid Book newBook, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add";
        }
        bookService.saveBook(newBook);
        return "redirect:/books/list";
    }
    
    //display form with data id...
    @GetMapping("/editBook/{id}")
    public String editBookForm(@PathVariable Long id, @Valid Model model) throws ResourceNotFoundException{
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        return "add";
    }
   
//
//    @PostMapping("/editBook/{id}")
//    public String editBook(Book newBook, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "add";
//        }
//        bookRepository.save(newBook);
//        return "redirect:/books/tables";
//    }
    
    
    @GetMapping("/deleteById/{id}")
    public String delete(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books/list";
    }
    
    @GetMapping("/confirm/{id}")
    public String confirmDel(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "confirm";
    }
    
    @GetMapping("/filter")
    public String booksByAuthor(@RequestParam String author, @RequestParam String title, Model model) {
        List<Book> books = bookService.findAllByAuthorOrTitle(author, title);
        model.addAttribute("books", books);
        return "list";
    }
    
}
