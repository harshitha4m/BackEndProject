package com.example.MySpring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
@SpringBootApplication
public class MyConfig implements WebMvcConfigurer{
	@Bean
	public ViewResolver viewResolver() {
		System.out.println("viewresolver");
	InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	resolver.setPrefix("/WEB-INF/myjsp/");
	resolver.setSuffix(".jsp");
	resolver.setViewClass(JstlView.class);
	return resolver;
	}
}
