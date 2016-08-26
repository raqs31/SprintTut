package com.mario.spring.config.security;

import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by raqsW on 2016-08-18.
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/auth/login");
	}

	@Bean
	public ErrorViewResolver errorViewResolver() {
		return (request, status, model) -> {
				ModelAndView modelAndView = new ModelAndView();
				modelAndView.addObject("statusCode", status.value());
				modelAndView.addObject("errMsg", status.getReasonPhrase());
				modelAndView.setViewName("/errors/error");
				return modelAndView;
			};
	}
}
