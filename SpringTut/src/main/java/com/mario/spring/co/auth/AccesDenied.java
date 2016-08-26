package com.mario.spring.co.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by raqsW on 2016-08-19.
 */
@Controller
public class AccesDenied {
	@GetMapping(value = "/403")
	public ModelAndView accessDenied(Principal user) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", user.getName());
		mv.setViewName("errors/403");

		return mv;
	}
}
