package com.jamie.secret.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.secret.dao.UserProfileDao;
import com.jamie.secret.model.UserProfile;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	private UserProfileDao userProfileDao;
	
	@Override
	public List<UserProfile> findAll() {
		// TODO Auto-generated method stub
		return userProfileDao.findAll();
	}

}