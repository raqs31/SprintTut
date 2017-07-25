package com.mario.web.co.arena;

import com.mario.domain.service.arena.ActorService;
import com.mario.web.co.arena.dto.ActorSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by nowe konto on 2016-11-29.
 */
@Controller
@RequestMapping( value = "/arena" )
public class SearchCO {

	@Autowired
	private ActorService actorService;

	/*
	 * @RequestMapping(value = "/search", method= RequestMethod.GET) public String
	 * search(@ModelAttribute("actorCriteria" ) ActorSearchCriteria actorCriteria) { return "arena/search"; }
	 */

	@RequestMapping( value = "/search", method = RequestMethod.GET )
	public String search( Model model ) {
		model.addAttribute( "actorCriteria", new ActorSearchCriteria() );
		model.addAttribute( "lisOfSkills", ActorSearchCriteria.SKILLS_CRITERIAS );
		return "arena/search";
	}

	@RequestMapping( value = "/search", method = RequestMethod.POST )
	public String searchaActor( @Valid ActorSearchCriteria actorCriteria, BindingResult bindingResult ) {
		if ( bindingResult.hasErrors() ) {

		}
		// actorService.searchActors(actorCriteria);
		return "arena/search";
	}

}
