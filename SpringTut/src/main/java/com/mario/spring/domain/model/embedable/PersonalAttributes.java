package com.mario.spring.domain.model.embedable;

import lombok.Data;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by raqsW on 2016-08-22.
 */
@Data
@Embeddable
@Access(AccessType.FIELD)
public class PersonalAttributes {
	@Column(name = "EYE_COLOR")
	private String eyeColor;

	@Column(name = "HAIR_COLOR")
	private String hairColor;

	@Column(name = "HEIGHT")
	private Integer height;

	@Column(name = "WEIGHT", precision = 2)
	private Double weight;

	@Column(name = "EDUCATION", length = 4000)
	private String education;

	@Column(name = "ABOUT", length = 4000)
	private String aboutActor;
}
