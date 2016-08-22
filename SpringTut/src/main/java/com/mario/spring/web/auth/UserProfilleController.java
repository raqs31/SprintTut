package com.mario.spring.web.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by raqsW on 2016-08-19.
 */
@Controller
@RequestMapping("/auth")
public class UserProfilleController {

	@GetMapping("/profile")
	public String userProfile(Map<String, Object> model) {

//		return "/auth/profile";
		throw new RuntimeException("test wyjątku");
	}
}
