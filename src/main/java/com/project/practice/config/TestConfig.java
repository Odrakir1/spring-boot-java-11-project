package com.project.practice.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.practice.entities.Category;
import com.project.practice.entities.Order;
import com.project.practice.entities.User;
import com.project.practice.entities.enums.OrderStatus;
import com.project.practice.repositories.CategoryRepository;
import com.project.practice.repositories.OrderRepository;
import com.project.practice.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private OrderRepository or;

	@Autowired
	private CategoryRepository cr;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 

		
		User u1 = new User(null,"Bryan","bryan@gmail.com","1111111","12345");
		User u2 = new User(null,"Kenny","kenny@gmail.com","2222222","123456");
		
		Order o1 = new Order(null, Instant.parse("2020-06-24T16:00:00Z"), OrderStatus.AWAITING_PAYING ,u1);
		Order o2 = new Order(null, Instant.parse("2020-06-24T17:37:25Z"), OrderStatus.AWAITING_PAYING,u2);
		Order o3 = new Order(null, Instant.parse("2020-06-24T13:16:14Z"), OrderStatus.CANCELED,u1);
		
		ur.saveAll(Arrays.asList(u1,u2));
		or.saveAll(Arrays.asList(o1,o2,o3));
		cr.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		
	}

	
	
}
