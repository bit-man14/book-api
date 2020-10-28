package pl.coderslab.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.book.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
//    List<Book> findAllById(Long id);
    
    @Query("SELECT b FROM Book b WHERE b.author like CONCAT('%',:author,'%') AND b.title like CONCAT('%',:title,'%')")
    List<Book> findAllByAuthorOrTitle(@Param("author")String author,@Param("title")String title);
    
}
