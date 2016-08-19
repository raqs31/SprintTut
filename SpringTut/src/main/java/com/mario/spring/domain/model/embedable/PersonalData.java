package com.mario.spring.domain.model.embedable;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by raqsW on 2016-08-19.
 */

@Data
@Embeddable
public class PersonalData {

	@Column(name = "NAME")
	private String name;

	@Column(name = "SECOND_NAME")
	private String secondName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "BIRTHDAY")
	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Embedded
	private Adress adress;
}
