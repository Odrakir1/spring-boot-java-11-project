package com.project.practice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.practice.entities.Category;
import com.project.practice.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository ur;
	
	
	public List<Category> findAll(){
		
		return ur.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> user = ur.findById(id);
		return user.get();
		
	}
}
