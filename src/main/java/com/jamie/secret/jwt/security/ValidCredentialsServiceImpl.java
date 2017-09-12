package com.jamie.secret.jwt.security;

import org.springframework.stereotype.Service;

@Service
public class ValidCredentialsServiceImpl implements ValidCredentialsService{

	@Override
	public boolean hardcodeChecking(AccountCredentials credentials) {
		// TODO Auto-generated method stub
		 return "admin".equals(credentials.username)
	                && "admin".equals(credentials.password);
	}

}
