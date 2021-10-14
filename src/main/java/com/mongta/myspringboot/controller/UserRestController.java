package com.mongta.myspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongta.myspringboot.entity.User;
import com.mongta.myspringboot.entity.Users;
import com.mongta.myspringboot.exception.ResourceNotFoundException;
import com.mongta.myspringboot.repository.UserRepository;

@RestController
public class UserRestController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/users")
	public User create(@RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
		Optional<User> optional = userRepository.findById(id);
		User user = optional.orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
		return user;
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	// 등록이랑 유사함.
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User userDetail) {
		// 찾는 id 값이 없을경우에는 findById(id).orElseThrow 람다식 을통해 낫 파운드 익셉션을 리턴한다.
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		// user.setName과 setEmail 을 바꿀 데이터 객체를 재수정한다.
		user.setName(userDetail.getName());
		user.setEmail(userDetail.getEmail());
		// .save를 통해서 수정한다.
		// 원하는 필드만 수정할 경우에는 patch를 사용한다.
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}

//	@DeleteMapping("/users/{id}")
//	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
//		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
//		userRepository.delete(user);
//		// return ResponseEntity.ok(user);
//		return ResponseEntity.ok().build();
//	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id){
		Optional<User> optional = userRepository.findById(id);
		//찾은 아이디의 객체가 없다면 예외처리 한다.
		if (optional.isEmpty()) {
		return new ResponseEntity<>("User Not Fount", HttpStatus.NOT_FOUND);				
		}
		userRepository.deleteById(id);
		return ResponseEntity.ok(id + "User 삭제됨!");
	}
	
	@GetMapping(value = "/userxml",produces = {"application/xml"})
	public Users getUserXml(){
		Users users = new Users();
		users.setUsers(userRepository.findAll());
		return users;
	}

}
