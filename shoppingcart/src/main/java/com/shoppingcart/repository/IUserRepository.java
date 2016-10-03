package com.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.models.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);

}
