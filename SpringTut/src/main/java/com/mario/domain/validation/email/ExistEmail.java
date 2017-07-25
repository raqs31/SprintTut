package com.mario.domain.validation.email;

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
 * Created by nowe konto on 2016-12-03.
 */
@Target( { TYPE, FIELD, ANNOTATION_TYPE } )
@Retention( RUNTIME )
@Constraint( validatedBy = EmailExistValidator.class )
@Documented
public @interface ExistEmail {

	String message() default "User exist in databe";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
