package com.jamie.secret.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jamie.secret.model.TestModel;
import com.jamie.secret.service.TestService;

@RequestMapping(value="/secret/authentication")
@Controller
public class TestController {
	Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private TestService testService; 
	
	@RequestMapping("/hello")
	public ModelAndView firstPage() {
		return new ModelAndView("hello");
	}
	
	@RequestMapping(value ="/findAll")
	public @ResponseBody List<TestModel> findAll(){
		List<TestModel> testModel = testService.findAll();
		log.info("[TestModel]-[findAll]-User Response() : "+ testModel);
		return testModel;
	} 
}
