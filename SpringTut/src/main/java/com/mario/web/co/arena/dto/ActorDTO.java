package com.mario.web.co.arena.dto;

import com.mario.domain.model.arena.Actor;
import lombok.Data;

/**
 * Created by nowe konto on 2016-12-10.
 */
@Data
public class ActorDTO {

	private String fullName;

	private String dateOfBirth;

	private Integer height;

	private Double weight;

	private String eyesColor;

	private String hairsColor;

	public ActorDTO( Actor actor ) {
		String name = actor.getUser().getPersonalData().getName().concat( " " )
			.concat( actor.getUser().getPersonalData().getLastName() );
		this.fullName = name;
		this.dateOfBirth = actor.getUser().getPersonalData().getBirthday().toString();
		this.height = actor.getPersonalAttributes().getHeight();
		this.weight = actor.getPersonalAttributes().getWeight();
		this.eyesColor = actor.getPersonalAttributes().getEyeColor();
		this.hairsColor = actor.getPersonalAttributes().getHairColor();

	}

	public ActorDTO() {

	}

}
