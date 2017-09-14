package com.jamie.secret.service;

import java.util.List;

import com.jamie.secret.model.UserProfile;

public interface UserProfileService {
	List<UserProfile> findAll();
}
