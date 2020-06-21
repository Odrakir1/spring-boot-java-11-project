package com.project.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.practice.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
}
