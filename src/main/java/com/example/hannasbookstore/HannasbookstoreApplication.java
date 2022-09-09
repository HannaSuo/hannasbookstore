package com.example.hannasbookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.hannasbookstore.model.Book;
import com.example.hannasbookstore.model.BookRepository;


@SpringBootApplication
public class HannasbookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(HannasbookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book book1 = new Book("Harry Potter", "J.K.Rowling", 1997, "ISBN-6767", 100.00);
			repository.save(book1);

		};

	}
}
