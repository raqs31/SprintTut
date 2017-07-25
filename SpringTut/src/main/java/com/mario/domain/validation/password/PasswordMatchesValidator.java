package com.mario.domain.validation.password;

import com.mario.web.co.auth.dto.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by nowe konto on 2016-12-02.
 */
public class PasswordMatchesValidator
	implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize( PasswordMatches constraintAnnotation ) {
	}

	@Override
	public boolean isValid( Object obj, ConstraintValidatorContext context ) {
		UserDTO user = (UserDTO) obj;
		return user.getPassword().equals( user.getConfirmPassword() );
	}
}
