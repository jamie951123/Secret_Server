package com.jamie.secret.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamie.secret.model.UserProfile;

public interface UserProfileDao extends JpaRepository<UserProfile,Long> {

	List<UserProfile> findAll();
	
	UserProfile findByUsername(String username);
	
	UserProfile findByUsernameAndPassword(String username,String password);
}
