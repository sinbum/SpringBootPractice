package com.mongta.myspringboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	@PostMapping("/adduser")
	public String addUser (@Valid User user,BindingResult result) {
		//입력항목 검증 오류가 있을격우
		if(result.hasErrors()) {
			//등록페이지로 다시 돌아감.
			return "add-user";
		}
		userRepository.save(user);
		//완료가 되었기에 DB에서 정보를 다시 가져오기 위해서 
		//User 리스트 요청하는 url로 redirect
		return "redirect:/index";
		
	}
	
	@GetMapping("/signup")
	public String showSignUpForm(User user) {
	return "add-user";
	}
	
	
	
	
	
}
