package com.project.practice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.practice.entities.User;
import com.project.practice.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService us;
	
	@GetMapping
	public ResponseEntity<List<User>> getAll(){
		
		List<User> users = us.findAll();
		
		return ResponseEntity.ok().body(users);
		
	}

	
	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		
		User user = us.findById(id);
		
		return ResponseEntity.ok().body(user);
	}
}
