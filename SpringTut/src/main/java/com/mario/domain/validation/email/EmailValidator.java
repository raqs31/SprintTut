package com.mario.domain.validation.email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nowe konto on 2016-12-02.
 */
public class EmailValidator
	implements ConstraintValidator<ValidEmail, String> {

	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
		.compile( "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE );

	private Matcher matcher;

	@Override
	public void initialize( ValidEmail constraintAnnotation ) {
	}

	@Override
	public boolean isValid( String email, ConstraintValidatorContext context ) {
		return ( validateEmail( email ) );
	}

	private boolean validateEmail( String email ) {
		matcher = VALID_EMAIL_ADDRESS_REGEX.matcher( email );
		return matcher.matches();
	}
}
