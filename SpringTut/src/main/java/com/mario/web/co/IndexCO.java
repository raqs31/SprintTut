package com.mario.web.co;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by mario on 24.11.16.
 */
@Controller
public class IndexCO {

	@GetMapping( "/" )
	public String index() {

		return "index";
	}

	@GetMapping( "/reg" )
	public String register() {
		return "auth/register";
	}

	@GetMapping( "/log" )
	public String log() {
		return "auth/login";
	}
}
