package com.mario.web.co.admin.dicts;

import com.mario.domain.model.dict.DictionaryType;
import com.mario.domain.service.admin.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by raqsW on 2016-08-22.
 */
@Controller
@RequestMapping( value = "/admin/dicts" )
public class DictionaryListCO {

	@Inject
	private DictionaryService dictionaryService;

	@GetMapping( value = { "/", "dictList" } )
	public String dictList() {
		return "/admin/dicts/dictList";
	}

	@ModelAttribute( "dictTypes" )
	public List<DictionaryType> findAllDictionaryTypes() {
		return dictionaryService.getDictionaryTypes();
	}
}
