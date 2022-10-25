package com.example.hannasbookstore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.hannasbookstore.model.MyUser;
import com.example.hannasbookstore.model.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository urepository;
	
	@Test
	public void findByUserNameShouldReturnUser() {
		MyUser testUser = urepository.findByUsername("user");
		
		assertThat(testUser.getRole()).isEqualTo("USER");
		
	}
	
	@Test
	public void createNewUser() {
		MyUser testUser = new MyUser("Hanna", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "ADMIN");
		urepository.save(testUser);
		
		assertThat(testUser).isNotNull();
		assertThat(testUser.getUsername()).startsWith("H");
		assertThat(testUser.getRole()).contains("ADMIN");
	}
	
	@Test
	public void deleteNewUser() {
		List<MyUser> users = urepository.findByRole("ADMIN");
		MyUser testUser = users.get(0);
		urepository.delete(testUser);
		List<MyUser> newUsers = urepository.findByRole("ADMIN");
		assertThat(newUsers).hasSize(0);
	}
	
}
