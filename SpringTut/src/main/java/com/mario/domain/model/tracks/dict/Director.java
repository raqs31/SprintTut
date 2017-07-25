package com.mario.domain.model.tracks.dict;

import com.mario.domain.model.dict.Dictionary;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by mario on 05.12.16.
 */
@Entity
@DiscriminatorValue( Director.TYPE )
public class Director
	extends Dictionary {

	public static final String TYPE = "DIRECTORS";
}
