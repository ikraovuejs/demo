package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Auth;
import com.example.demo.model.Users;

@Repository
public interface AuthRepo extends JpaRepository<Auth, String> {

	void save(Users user);
	
	//@Query("SELECT a FROM users a WHERE username = ?1 AND password = ?2")
	//Users findBy(String username, String password);

}
