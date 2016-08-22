package com.mario.spring.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by raqsW on 2016-08-22.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminConsoleController {

	@GetMapping(value = "/console")
	public String adminConsole() {
		return "/admin/console";
	}
}
