package com.project.practice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.practice.entities.Product;
import com.project.practice.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductResource {
	
	@Autowired
	private ProductService us;
	
	@GetMapping
	public ResponseEntity<List<Product>> getAll(){
		
		List<Product> users = us.findAll();
		
		return ResponseEntity.ok().body(users);
		
	}

	
	@GetMapping(value="/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		
		Product user = us.findById(id);
		
		return ResponseEntity.ok().body(user);
	}
}
