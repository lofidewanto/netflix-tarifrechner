package com.example.netflix.tarif;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class MvcConfig {
    
    public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("greeting");
		registry.addViewController("/").setViewName("greeting");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/netflix-tarifrechner").setViewName("netflix-tarifrechner");
		registry.addViewController("/login").setViewName("login");
	}

}
