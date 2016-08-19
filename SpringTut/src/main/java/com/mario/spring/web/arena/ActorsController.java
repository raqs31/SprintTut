package com.mario.spring.web.arena;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by raqsW on 2016-08-19.
 */
@Controller
@RequestMapping(value = "/arena")
public class ActorsController {

	@GetMapping(value = "/actors")
	public String actorList(Map<String, Object> model) {

		return "arena/actors";
	}
}
