package com.example.hannasbookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long id;
	private String title;
	private String author;
	private int publishYear;
	private String isbn;
	private double price;
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;

	public Book() {

	}

	public Book(String title, String author, int publishYear, String isbn, double price, Category category) {
		this.title = title;
		this.author = author;
		this.publishYear = publishYear;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Title " + title + " ,Author " + author + " ,Publishyear " + publishYear + " ,ISBN " + isbn + " ,Price "
				+ price + " ,Category " + category;
	}

}
