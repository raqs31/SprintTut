package com.mario.spring.domain.model.auth;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by raqsW on 2016-08-16.
 */

@Data
@Entity
@Table(name = "USERS")
public class User {
	@Id
	@Column(name = "USERNAME", length = 256)
	private String userName;

	@Column(name = "PASSWORD", length = 256, nullable = false)
	private String password;

	@Column(name = "ENABLED", nullable = false)
	private Boolean enabled;
}
