package com.mongta.myspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongta.myspringboot.entity.User;
import com.mongta.myspringboot.repository.UserRepository;

@RestController
public class UserRestController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/users")
	public User create(@RequestBody User user) {		
		return userRepository.save(user);		
	}
	
	
}
