package com.example.hannasbookstore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.hannasbookstore.model.Category;
import com.example.hannasbookstore.model.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository crepository;
	
	@Test
	public void findByCategoryShouldReturnCategory() {
		List<Category> categories = crepository.findByName("Fantasy");
		
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Fantasy");
	}
	
	@Test
	public void createNewCategory() {
		Category category = new Category("Detective stories");
		crepository.save(category);
		assertThat(category.getCategoryId()).isNotNull();
	}
	
	@Test
	public void deleteNewCategory() {
		List<Category> categories = crepository.findByName("Fantasy");
		Category category = categories.get(0);
		crepository.delete(category);
		List<Category> newCategories = crepository.findByName("Fantasy");
		assertThat(newCategories).hasSize(0);
	}
}
