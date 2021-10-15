package com.mongta.myspringboot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mongta.myspringboot.entity.User;
import com.mongta.myspringboot.repository.UserRepository;

@Controller
public class UserController {
	
	private final UserRepository userRepository;
	
	//생성자 주입 Constructor Injection
	public UserController(UserRepository repository) {
		this.userRepository = repository;
	};
	
	
	@GetMapping("/index")
	public ModelAndView index() {
		List<User> userList = userRepository.findAll();
		return new ModelAndView("index","users",userList);
	}
	
	@GetMapping("thymeleaf")
	public String leaf(Model model) {	
		model.addAttribute("name", "myname is shin beomchoi");
		return "leaf";
	}
	
}
