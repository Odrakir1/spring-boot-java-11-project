package com.project.practice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.practice.entities.Category;
import com.project.practice.services.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService us;
	
	@GetMapping
	public ResponseEntity<List<Category>> getAll(){
		
		List<Category> users = us.findAll();
		
		return ResponseEntity.ok().body(users);
		
	}

	
	@GetMapping(value="/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		
		Category user = us.findById(id);
		
		return ResponseEntity.ok().body(user);
	}
}
