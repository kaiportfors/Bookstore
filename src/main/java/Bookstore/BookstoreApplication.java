package Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import Bookstore.domain.Book;
import Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
		
		@Bean
		public CommandLineRunner booksDemo(BookRepository repository) {
			return (args) -> {
				log.info("save a couple of students");
				repository.save(new Book("The Last One", "Mikael Levingsten", 2013, "A192342", 20));
				repository.save(new Book("The Lost Child", "Kimberly Louis", 2012, "A342131", 10));
				repository.save(new Book("The Lost Woman", "Mike Tyson", 2010, "B223432", 20));
				log.info("fetch all books");
				for (Book book : repository.findAll()) {
					log.info(book.toString());
				}

			};
		}
}
