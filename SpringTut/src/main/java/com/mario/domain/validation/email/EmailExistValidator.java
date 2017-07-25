package com.mario.domain.validation.email;

import com.mario.domain.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by nowe konto on 2016-12-03.
 */
public class EmailExistValidator
	implements ConstraintValidator<ExistEmail, String> {

	@Autowired
	private UserService userService;

	@Override
	public void initialize( ExistEmail existEmail ) {

	}

	@Override
	public boolean isValid( String email, ConstraintValidatorContext context ) {
		return validate( email );
	}

	private boolean validate( String email ) {
		return userService.findUserByUsername( email ) == null;

	}
}
