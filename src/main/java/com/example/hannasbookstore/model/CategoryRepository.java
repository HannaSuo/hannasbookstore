package com.example.hannasbookstore.model;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CategoryRepository extends CrudRepository <Category, Long> {
	List<Category> findByName(@Param("name")String name);
}

