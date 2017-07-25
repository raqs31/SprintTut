package com.mario.domain.validation.phoneNumber;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by nowe konto on 2016-12-07.
 */
@Target( { TYPE, FIELD, ANNOTATION_TYPE } )
@Retention( RUNTIME )
@Constraint( validatedBy = PhoneNumberValidator.class )
@Documented
public @interface PhoneNumber {

	String message() default "Invalid phone number";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
