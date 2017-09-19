package com.jamie.secret.jwt.security;

import java.util.Date;
import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;

import com.jamie.secret.model.Role;
import com.jamie.secret.model.Status;
import com.jamie.secret.model.UserProfile;

@Service
public class GenerateTokenServiceImpl implements GenerateTokenService {


	@Override
	public String general_token(UserProfile userProfile) {
		// TODO Auto-generated method stub
		long long_time = System.currentTimeMillis();
		Date token_iat = new Date(new Long(long_time));
		Date token_exp = new Date(long_time + JwtUtil.EXPIRATION_TIME);
		Role role = userProfile.getRole();
		LinkedHashMap<String,Object> map = new LinkedHashMap<>();
		map.put("iss", JwtUtil.iss);
		map.put("sub", userProfile.getUsername());
		map.put("iat", token_iat);
		map.put("expired", token_exp);
		map.put("role", role);
		return JwtUtil.generateToken(map);
	}

}
