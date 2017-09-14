package com.jamie.secret.jwt.security;

import org.springframework.stereotype.Service;

import com.jamie.secret.model.UserProfile;

@Service
public class LoginServiceImpl implements LoginService{

	@Override
	public boolean hardcodeChecking(UserProfile userProfile) {
		// TODO Auto-generated method stub
		 return "admin".equals(userProfile.getUsername())
	                && "admin".equals(userProfile.getPassword());
	}

	@Override
	public boolean generalChecking(UserProfile userProfile) {
		// TODO Auto-generated method stub
		return false;
	}

}
