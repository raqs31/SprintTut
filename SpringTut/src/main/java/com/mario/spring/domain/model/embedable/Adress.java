package com.mario.spring.domain.model.embedable;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by raqsW on 2016-08-19.
 */
@Data
@Embeddable
public class Adress {

	@Column(name = "STREET")
	private String street;

	@Column(name = "CITY")
	private String city;
}
