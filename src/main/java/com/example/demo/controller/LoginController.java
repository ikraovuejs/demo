package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Auth;
import com.example.demo.model.Users;
import com.example.demo.repo.AuthRepo;
import com.example.demo.repo.UserRepo;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {
	
	@Autowired
	private AuthRepo authRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@PostMapping("/login")
	public Users login(@RequestBody Auth auth) {

		System.out.println("user:"+auth.getUserName());
		System.out.println("pwd:"+auth.getPassword());
		
		if(auth!=null) {
		
			Optional<Auth> auth1=authRepo.findById(auth.getUserName());
			Auth a=auth1.get();
		if(a.getUserName()!=null) {
		 Optional<Users> users= userRepo.findById(Integer.toString(7));
		 Users user=users.get();
		 System.out.println(user);
			return user;
		}
		}
		return null;
		
	}
	@PostMapping("/register")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String save(@RequestBody Users user) {
		
		if(user.getUserName()!=null) {
			Auth auth= new Auth();
			auth.setUserName(user.getUserName());
			auth.setPassword(user.getPassword());
			authRepo.save(auth);
		
		System.out.println(user);
		
		userRepo.save(user);
		return "ok";
		
		}
		return null;
	}

}
