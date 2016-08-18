package com.mario.spring.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Date;
import java.util.Map;

/**
 * Created by raqsW on 2016-08-16.
 */
@Controller
public class GreetingController extends WebMvcConfigurerAdapter {
	@GetMapping("/")
	public String home(Map<String, Object> model) {
		model.put("message", "Hello World");
		model.put("title", "Hello Home");
		model.put("date", new Date());
		return "greeting";
	}
}
