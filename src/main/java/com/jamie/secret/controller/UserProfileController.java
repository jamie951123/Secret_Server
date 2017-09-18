package com.jamie.secret.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jamie.secret.model.UserProfile;
import com.jamie.secret.service.UserProfileService;

@RequestMapping(value="/secret/authentication")
//@RequestMapping(value="/jamie")
@Controller
public class UserProfileController {
	Logger log = LoggerFactory.getLogger(UserProfileController.class);
	
	@Autowired
	private UserProfileService userProfileService; 
	
	@RequestMapping("/hello")
	public ModelAndView firstPage() {
		return new ModelAndView("hello");
	}
	
	@GetMapping(value ="/findAll")
	public @ResponseBody List<UserProfile> findAll(){
		List<UserProfile> userProfiles = userProfileService.findAll();
		log.info("[UserProfile]-[findAll]-User Response() : "+ userProfiles);
		return userProfiles;
	} 
}
