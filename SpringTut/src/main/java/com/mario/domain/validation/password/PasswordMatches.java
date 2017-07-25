package com.mario.domain.validation.password;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by nowe konto on 2016-12-02.
 */
@Target( { TYPE, ANNOTATION_TYPE } )
@Retention( RUNTIME )
@Constraint( validatedBy = PasswordMatchesValidator.class )
@Documented
public @interface PasswordMatches {

	String message() default "Passwords don't match";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
