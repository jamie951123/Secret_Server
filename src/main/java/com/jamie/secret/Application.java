package com.jamie.secret;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.CharacterEncodingFilter;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class Application extends SpringBootServletInitializer{

	 @Autowired
	    private ServletContext servletContext;
	 
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(Application.class);
	    }
	 
   public static void main(String[] args) {
       SpringApplication.run(Application.class, args);
   }
   
   @PostConstruct
   public void showIt() {
       System.out.println("Serve Base Path :"+servletContext.getContextPath());
   }
   
   @Bean
   public FilterRegistrationBean filterRegistrationBean() {
       FilterRegistrationBean registrationBean = new FilterRegistrationBean();
       CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
       characterEncodingFilter.setEncoding("UTF-8");
       registrationBean.setFilter(characterEncodingFilter);
       return registrationBean;
   }
	
}
