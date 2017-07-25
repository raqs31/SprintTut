package com.mario.web.co.arena;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by raqsW on 2016-08-19.
 */
@Controller
@RequestMapping(value = "/arena")
public class FavouritesCO {

	@GetMapping( value = "/favourites" )
	public String favourites( Map<String, Object> model ) {
		return "arena/favourites";
	}
}
