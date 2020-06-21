package com.project.practice.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.practice.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> test(){
		
		User user = new User(1L, "Fake", "fake.name@gmail.com", "91111111", "123456");
		
		return ResponseEntity.ok().body(user);
		
	}

}
