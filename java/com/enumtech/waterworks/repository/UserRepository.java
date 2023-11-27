package com.enumtech.waterworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.enumtech.waterworks.entity.User;



public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select u from User u where u.username like ?1")
	public User getUserByUsername(String username);
}
