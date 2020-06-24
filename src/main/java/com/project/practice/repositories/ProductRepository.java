package com.project.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.practice.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	
}
