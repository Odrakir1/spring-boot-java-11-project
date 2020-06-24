package com.project.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.practice.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	
}
