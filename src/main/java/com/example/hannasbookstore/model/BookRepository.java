package com.example.hannasbookstore.model;

import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Long>{
	
}
