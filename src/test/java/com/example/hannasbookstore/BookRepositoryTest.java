package com.example.hannasbookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.hannasbookstore.model.Book;
import com.example.hannasbookstore.model.BookRepository;
import com.example.hannasbookstore.model.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository repository;
	
	@Test
	public void findByAuthorShouldReturnAuthor() {
		List<Book> books = repository.findByAuthor("Douglas Adams");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("The Hitchhiker's Guide to the Galaxy");
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("The bible", "Unknown", 100, "ISBN-13", 1000.00, new Category("misc"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteNewBook() {
		List<Book> books = repository.findByAuthor("Douglas Adams");
		Book book = books.get(0);
		repository.delete(book);
		List<Book> newBooks = repository.findByAuthor("Douglas Adams");
		assertThat(newBooks).hasSize(0);
	}

}
