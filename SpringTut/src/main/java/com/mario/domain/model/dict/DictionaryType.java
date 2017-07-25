package com.mario.domain.model.dict;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by raqsW on 2016-09-02.
 */
@Entity
@DiscriminatorValue( "DICTIONARY_TYPE" )
public class DictionaryType<P extends Dictionary, C extends Dictionary>
	extends Dictionary<P, C> {
}
