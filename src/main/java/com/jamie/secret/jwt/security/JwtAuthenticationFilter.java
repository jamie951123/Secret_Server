package com.jamie.secret.jwt.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	 private final String protectUrlPattern;
	 private static final PathMatcher pathMatcher = new AntPathMatcher();

	 @Autowired
	 ValidateTokenService validateTokenService;
	 
	    public JwtAuthenticationFilter(String protectUrlPattern) {
	        this.protectUrlPattern = protectUrlPattern;
	    }
	    
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
	           if(pathMatcher.match(protectUrlPattern, request.getServletPath())) {
	               String token = request.getHeader(JwtUtil.HEADER_STRING);
	               validateTokenService = new ValidateTokenServiceImpl();
	               validateTokenService.validate_General(token);
	           }
	       } catch (Exception e) {
	           response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
	           return;
	       }
	       filterChain.doFilter(request, response);
	
	}

	
}
