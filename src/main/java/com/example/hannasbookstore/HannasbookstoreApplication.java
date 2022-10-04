package com.example.hannasbookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.hannasbookstore.model.Book;
import com.example.hannasbookstore.model.BookRepository;
import com.example.hannasbookstore.model.Category;
import com.example.hannasbookstore.model.CategoryRepository;
import com.example.hannasbookstore.model.MyUser;
import com.example.hannasbookstore.model.UserRepository;

@SpringBootApplication
public class HannasbookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(HannasbookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository,
			UserRepository urepository) {
		return (args) -> {
			Category category1 = new Category("Fantasy");
			Category category2 = new Category("Sci-fi");
			Category category3 = new Category("Crime");
			crepository.save(category1);
			crepository.save(category2);
			crepository.save(category3);

			Book book1 = new Book("Harry Potter", "J.K.Rowling", 1997, "ISBN-12", 100.00, category1);
			Book book2 = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1980, "ISBN-55", 30.00,
					category2);
			Book book3 = new Book("The Hound of the Baskervilles", "Arthur Conan Doyle", 1902, "ISBN-89", 250.00,
					category3);
			repository.save(book1);
			repository.save(book2);
			repository.save(book3);

			MyUser user1 = new MyUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			MyUser user2 = new MyUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

		};

	}

}
