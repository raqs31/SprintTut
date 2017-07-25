package com.mario.domain.service.admin.migration;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by mario on 09.12.16.
 */
@Target( { ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE } )
@Retention( RetentionPolicy.RUNTIME )
@Qualifier
public @interface Migrator {

	Class value();
}
