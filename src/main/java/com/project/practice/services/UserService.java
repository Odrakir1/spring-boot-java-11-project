package com.project.practice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.practice.entities.User;
import com.project.practice.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository ur;
	
	
	public List<User> findAll(){
		
		return ur.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = ur.findById(id);
		return user.get();
		
	}
	
	public User insert(User user) {
		return ur.save(user);
	}
	
	public void delete(Long id) {
		ur.deleteById(id);
	}
	
	
	public User update(Long id,User user) {
		User entity = ur.getOne(id);
		updateUser(entity,user);
		return ur.save(entity) ;
	}

	private void updateUser(User entity, User user) {
		entity.setName(user.getName());
		entity.setFone(user.getFone());
		entity.setEmail(user.getEmail());
		
	}
}
