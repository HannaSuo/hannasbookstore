package com.example.hannasbookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.hannasbookstore.model.Book;
import com.example.hannasbookstore.model.BookRepository;
import com.example.hannasbookstore.model.CategoryRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository crepository;

	@PostMapping("/login")
	public String login() {
		return "login";
	}

	// Retrieves the booklist
	@GetMapping("/booklist")
	public String bookController(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	// Action in the editbook page, is this needed? Mapped this to save also
	/*
	 * @PostMapping("/booklist") public String postBookList(Model model) {
	 * repository.save(book); return "redirect:booklist"; }
	 */

	// Gets the addbook page
	@GetMapping("/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}

	// saves a new book
	@PostMapping("/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}

	// deletes selected book by id
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../booklist";
	}

	// gets the selected book by id and opens editbook page
	@GetMapping("/update/{id}")
	public String updateBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", repository.findById(id));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}

	// RESTful service, all books
	@GetMapping("/books")
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}

	// RESTful service, book by ID
	@GetMapping("/book/{id}")
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {
		return repository.findById(id);
	}

}
