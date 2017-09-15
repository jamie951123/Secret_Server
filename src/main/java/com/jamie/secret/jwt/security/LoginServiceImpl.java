package com.jamie.secret.jwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.secret.core.util.ObjectUtils;
import com.jamie.secret.model.UserProfile;
import com.jamie.secret.service.UserProfileService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	UserProfileService userProfileService;
	
	@Override
	public boolean hardcodeChecking(UserProfile userProfile) {
		// TODO Auto-generated method stub
		 return "admin".equals(userProfile.getUsername())
	                && "admin".equals(userProfile.getPassword());
	}

	@Override
	public boolean generalChecking(UserProfile userProfile) {
		// TODO Auto-generated method stub
		if(userProfile != null && ObjectUtils.isNotNullEmpty(userProfile.getUsername()) && ObjectUtils.isNotNullEmpty(userProfile.getPassword())){
			try{
				if(userProfileService.findByUsernameAndpPassword(userProfile.getUsername(), userProfile.getPassword()) != null){
					return true;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return false;
	}

}
