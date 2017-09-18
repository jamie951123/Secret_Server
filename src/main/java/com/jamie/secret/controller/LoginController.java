package com.jamie.secret.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jamie.secret.jwt.security.GenerateTokenService;
import com.jamie.secret.jwt.security.JwtUtil;
import com.jamie.secret.jwt.security.LoginService;
import com.jamie.secret.model.UserProfile;

@RequestMapping(value="/secret/login")
@Controller
public class LoginController {
	Logger log = LoggerFactory.getLogger(LoginController.class);
	
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	GenerateTokenService generateTokenService;
	
	 @PostMapping("/general")
	    public void login(HttpServletResponse response,
	                      @RequestBody final UserProfile userProfile) throws IOException {
	        if(loginService.generalChecking(userProfile)) {
	            String token = generateTokenService.general_token(userProfile);
	            response.addHeader(JwtUtil.HEADER_STRING, JwtUtil.TOKEN_PREFIX + " " + token);
	        }else
	            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Wrong credentials");
	    }
	  
}
