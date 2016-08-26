package com.mario.spring.co.auth;

import com.mario.spring.domain.model.auth.User;
import com.mario.spring.domain.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by raqsW on 2016-08-19.
 */
@Controller
@RequestMapping("/auth")
public class UserProfilleController {
	@Autowired
	private UserService userService;

	@GetMapping("/profile/{userLogin}")
	public String userProfile(
			@PathVariable("userLogin") String login,
			Map<String, Object> model) {

		User user = userService.loadUser(login);

		model.put("user", user);
		return "/auth/profile";
	}
}
