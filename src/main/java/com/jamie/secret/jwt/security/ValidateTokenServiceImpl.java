package com.jamie.secret.jwt.security;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jamie.secret.exception.TokenValidationException;
import com.jamie.secret.model.UserProfile;
import com.jamie.secret.service.UserProfileService;
import com.jamie.secret.service.UserProfileServiceImpl;

@Service
public class ValidateTokenServiceImpl implements ValidateTokenService {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	UserProfileService userProfileService;
	
	@Override
	public boolean validate_General(String token) {
		// TODO Auto-generated method stub
		Map<String,Object> body = JwtUtil.validateToken(token);
		try{
			String iss = (String) (body.get("iss"));
			String sub = (String) (body.get("sub"));
			long iat = (long) (body.get("iat"));
			long expired = (long) (body.get("expired"));
			log.info("iss: " + iss);
			log.info("sub: " + sub);
			log.info("iat: " + iat);
			log.info("expired: " + expired);
			
			userProfileService = new UserProfileServiceImpl();
			UserProfile userProfile = userProfileService.findByUsername(sub);
			if(userProfile != null){
				return true;
			}
		}catch (Exception e){
			e.printStackTrace();
			throw new TokenValidationException("Wrong token without username");
		}
		return false;
	}

	
	
}
