package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Auth;
import com.example.demo.model.Users;
import com.example.demo.repo.UserRepo;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/login")
	public String login(String user, String pwd) {

		System.out.println("user:"+user);
		System.out.println("pwd:"+pwd);
		
		if(user.equalsIgnoreCase(pwd)) {
			System.out.println("helooo:");
			
			return "success";
		}
		else {
			return "failed";
			
		}
		
		
	}
	@PostMapping("/register")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String save(@RequestBody Users user) {
		
		if(user.getUserName()!=null) {
			Auth auth= new Auth();
			auth.setUserName(user.getUserName());
			auth.setPassword(user.getPassword());
			userRepo.save(auth);
		
		System.out.println(user);
		
		userRepo.save(user);
		return "ok";
		
		}
		return null;
	}

}
