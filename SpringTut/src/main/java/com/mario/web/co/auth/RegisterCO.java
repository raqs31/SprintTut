package com.mario.web.co.auth;

import com.mario.domain.service.auth.UserService;
import com.mario.web.co.auth.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by nowe konto on 2016-12-02.
 */
@Controller
@RequestMapping( value = "/auth" )
public class RegisterCO {

	@Autowired
	private UserService userService;

	@Autowired
	public RegisterCO( UserService userService ) {
		this.userService = userService;
	}

	@RequestMapping( value = "/register", method = RequestMethod.GET )
	public String register( Model model ) {
		UserDTO userDTO = new UserDTO();
		model.addAttribute( "acountDTO", userDTO );
		return "/auth/register";
	}

	@RequestMapping( value = "/register", method = RequestMethod.POST )
	public String userRegistration( @Valid @ModelAttribute( "acountDTO" ) UserDTO acountDTO,
									BindingResult bindingResult ) {
		if ( bindingResult.hasErrors() ) {
			return "/auth/register";
		}
		userService.createUserFromDTO( acountDTO );
		return "redirect:/profile/edit";

	}

}
