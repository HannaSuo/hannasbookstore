package com.example.hannasbookstore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<MyUser, Long> {
	MyUser findByUsername(String username);
	
	List<MyUser> findByRole(String role);
}
