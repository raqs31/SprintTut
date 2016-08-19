package com.mario.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.Date;
import java.util.Map;

/**
 * Created by raqsW on 2016-08-16.
 */
@Controller
public class GreetingController extends WebMvcConfigurerAdapter {
	@GetMapping("/")
	public String home(Map<String, Object> model, Principal principal) {
		model.put("message", "Hello World");
		model.put("date", new Date());
		model.put("user", principal);
		return "greeting";
	}

	@GetMapping("/buu")
	@RolesAllowed({"SUPERADMI"})
	public String accesDeniedPage(Map<String, Object> model) {
		model.put("message", "Hello World buuuuuuuuuu");
		model.put("title", "Hello Home buuuuuu");
		model.put("date", new Date());
		return "greeting";
	}
}
