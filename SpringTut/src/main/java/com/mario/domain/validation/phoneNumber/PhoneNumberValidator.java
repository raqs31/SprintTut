package com.mario.domain.validation.phoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nowe konto on 2016-12-07.
 */
public class PhoneNumberValidator
	implements ConstraintValidator<PhoneNumber, String> {

	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile( "[0-9]+" );

	private Matcher matcher;

	@Override
	public void initialize( PhoneNumber phoneNumber ) {

	}

	@Override
	public boolean isValid( String phoneNumber, ConstraintValidatorContext context ) {
		return validatePhone( phoneNumber );
	}

	private boolean validatePhone( String phone ) {
		matcher = VALID_EMAIL_ADDRESS_REGEX.matcher( phone );
		return matcher.matches();
	}
}
