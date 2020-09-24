package pl.coderslab.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Book {
    private static final Logger log = LogManager.getLogger(Book.class);
    //private static Long nextId = 1L;
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;
    
    public Book(Long id,String isbn, String title, String author, String publisher, String type) {
        //this.id = nextId;
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.type = type;
        //nextId++;
        //log.info("Book id={} created",id);
    }
    public Book(){}
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
}
