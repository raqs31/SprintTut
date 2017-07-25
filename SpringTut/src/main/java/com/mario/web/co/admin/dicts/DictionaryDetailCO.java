package com.mario.web.co.admin.dicts;

import com.mario.domain.service.admin.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Map;

/**
 * Created by raqsW on 2016-09-02.
 */
@Controller
@RequestMapping( value = "/admin/dicts/details" )
public class DictionaryDetailCO {

	@Inject
	private DictionaryService dictService;

	@GetMapping( value = "/{dictId}" )
	public String dictDetails( @PathVariable( "dictId" ) Integer dictId, Map<String, Object> model ) {
		model.put( "dict", dictService.findDictionary( dictId ) );

		return "/admin/dicts/details";

	}

}
