package Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import Bookstore.domain.Book;
import Bookstore.domain.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JPATest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByLastnameShouldReturnStudent() {
        List<Book> books = repository.findByTitle("Live");
        
        assertThat(books).hasSize(0);
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("The Last One", "Mikael Levingsten", 2013, "A192342", 20);
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    

}
