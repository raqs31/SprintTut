package com.mario.spring.domain.model.embedable;

import lombok.Data;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by raqsW on 2016-08-19.
 */
@Data
@Embeddable
@Access(AccessType.FIELD)
public class Adress {

	@Column(name = "STREET")
	private String street;

	@Column(name = "CITY")
	private String city;

	@Column(name = "POSTAL_CODE")
	private String postalCode;

	@Column(name = "PROVINCE")
	private String province;

	@Column(name = "COUNTRY_CODE", length = 3)
	private String countryCode;
}
