package com.project.practice.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.practice.entities.Category;
import com.project.practice.entities.Order;
import com.project.practice.entities.Product;
import com.project.practice.entities.User;
import com.project.practice.entities.enums.OrderStatus;
import com.project.practice.repositories.CategoryRepository;
import com.project.practice.repositories.OrderRepository;
import com.project.practice.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository pr;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "C++ for algorithms guide", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		cr.saveAll(Arrays.asList(cat1,cat2,cat3));
		pr.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		pr.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		User u1 = new User(null,"Bryan","bryan@gmail.com","1111111","12345");
		User u2 = new User(null,"Kenny","kenny@gmail.com","2222222","123456");
		
		Order o1 = new Order(null, Instant.parse("2020-06-24T16:00:00Z"), OrderStatus.AWAITING_PAYING ,u1);
		Order o2 = new Order(null, Instant.parse("2020-06-24T17:37:25Z"), OrderStatus.AWAITING_PAYING,u2);
		Order o3 = new Order(null, Instant.parse("2020-06-24T13:16:14Z"), OrderStatus.CANCELED,u1);
		
		ur.saveAll(Arrays.asList(u1,u2));
		or.saveAll(Arrays.asList(o1,o2,o3));
		
		
	}

	
	
}
