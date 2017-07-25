package com.mario.web.co.arena;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nowe konto on 2016-11-29.
 */
@Controller
@RequestMapping( value = "/arena" )
public class SideBarCO {

	@GetMapping( value = "/rules" )
	public String rules() {

		return "/arena/rules";
	}

	@GetMapping( value = "/about" )
	public String about() {

		return "/arena/about";
	}

	@GetMapping( value = "/contact" )
	public String contact() {

		return "/arena/rules";
	}
}
