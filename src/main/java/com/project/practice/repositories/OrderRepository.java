package com.project.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.practice.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	
}
