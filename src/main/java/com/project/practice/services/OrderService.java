package com.project.practice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.practice.entities.Order;
import com.project.practice.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository or;
	
	
	public List<Order> findAll(){
		
		return or.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> Order = or.findById(id);
		return Order.get();
		
	}
}
