package com.jamie.secret.jwt.security;

import com.jamie.secret.model.UserProfile;

public interface LoginService {
	boolean generalChecking(UserProfile userProfile);
	boolean hardcodeChecking(UserProfile userProfile);
}
