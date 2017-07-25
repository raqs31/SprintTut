package com.mario.web.co.admin.dicts;

import com.mario.domain.model.dict.Dictionary;
import com.mario.domain.service.admin.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by nowe konto on 2016-11-30.
 */
@Controller
@RequestMapping( value = "/admin" )
public class DictionaryAdderCO {

	private DictionaryService dictService;

	@Autowired
	public DictionaryAdderCO( DictionaryService dictService ) {
		this.dictService = dictService;
	}

	@RequestMapping( value = "/dicts/{id}", method = RequestMethod.GET )
	public String showAddedDict( @PathVariable String id, Model model ) {
		Dictionary dict = dictService.findDictionary( Integer.parseInt( id ) );
		model.addAttribute( "dictionary", dict );
		return "/admin/dicts/dictAdder";

	}

	@RequestMapping( value = "/dict/adder", method = RequestMethod.POST )
	public String processDictRegistration( @Valid Dictionary dict, BindingResult bindingResult ) {
		if ( bindingResult.hasErrors() ) {
			return "/admin/dicts/dictParentAdder";
		}
		dictService.save( dict );
		return "redirect:/admin/dicts/" + dict.getId();
	}

	@RequestMapping( value = "/dict/adder", method = RequestMethod.GET )
	public String disctAdd( Model model ) {
		List<Dictionary> dictList = dictService.findAllDictionaries();
		Dictionary d = new Dictionary();
		d.setDescription( "Opis" );
		d.setId( 5 );
		dictList.add( d );
		model.addAttribute( "dictionary", new Dictionary() );
		model.addAttribute( "dictList", dictList );
		return "/admin/dicts/dictAdder";
	}

	@RequestMapping( value = "/dict/parentAdder", method = RequestMethod.GET )
	public String disctParentAdd( Dictionary dict ) {
		return "/admin/dicts/dictParentAdder";
	}

	@RequestMapping( value = "/dict/parentAdder", method = RequestMethod.POST )
	public String processDictParentRegistration( @Valid Dictionary dict, BindingResult bindingResult ) {
		if ( bindingResult.hasErrors() ) {
			return "/admin/dicts/dictParentAdder";
		}
		dictService.save( dict );
		return "redirect:/admin/dict/adder";
	}

}
