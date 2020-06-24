package com.project.practice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.practice.entities.Product;
import com.project.practice.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository ur;
	
	
	public List<Product> findAll(){
		
		return ur.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> user = ur.findById(id);
		return user.get();
		
	}
}
