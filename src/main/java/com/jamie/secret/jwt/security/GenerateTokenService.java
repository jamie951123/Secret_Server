package com.jamie.secret.jwt.security;

import com.jamie.secret.model.UserProfile;

public interface GenerateTokenService {
	String general_token(UserProfile userProfile);
}
