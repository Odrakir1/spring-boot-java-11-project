package com.project.practice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.practice.entities.Order;
import com.project.practice.services.OrderService;

@RestController
@RequestMapping(value="/orders")
public class OrderResource {
	
	@Autowired
	private OrderService os;
	
	@GetMapping
	public ResponseEntity<List<Order>> getAll(){
		
		List<Order> Orders = os.findAll();
		
		return ResponseEntity.ok().body(Orders);
		
	}

	
	@GetMapping(value="/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		
		Order Order = os.findById(id);
		
		return ResponseEntity.ok().body(Order);
	}
}
