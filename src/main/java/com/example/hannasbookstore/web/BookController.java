package com.example.hannasbookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hannasbookstore.model.Book;
import com.example.hannasbookstore.model.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;

	@GetMapping("/booklist")
	public String bookController(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@GetMapping("/addbook") 
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@PostMapping("/save")
	public String save(Book book){
	 repository.save(book);
	 return "addbook";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id, Model model){ 
		repository.deleteById(id);
	 return "redirect:../booklist";
	}
	
	
}
