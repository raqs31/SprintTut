package com.mario.spring.domain.model.auth;

import com.mario.spring.domain.model.AuditableEntity;
import com.mario.spring.domain.model.embedable.PersonalData;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by raqsW on 2016-08-16.
 */

@Entity
@Table(name = "USERS")
@Data
@ToString(exclude = {"authorities", "password"})
public class User extends AuditableEntity<Integer> {
	public enum Gender {
		MALE("M"),
		FEMALE("F"),
		UNSPECIFIED("WTF");

		private String code;

		Gender(String code) {
			this.code = code;
		}
	}
	@Id
	@Column(name = "USER_ID")
	@SequenceGenerator(name = "userIdSeq", initialValue = 1, sequenceName = "USER_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdSeq")
	private Integer id;

	@Column(name = "USERNAME", nullable = false, length = 256, unique = true)
	private String userName;

	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;

	@Column(name = "PASSWORD", length = 256, nullable = false)
	private String password;

	@Column(name = "ENABLED", nullable = false)
	private Boolean enabled;

	@Column(name = "GENDER")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@ManyToMany
	@JoinTable(
			name = "USER_AUTHORITIES",
			joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"),
			inverseJoinColumns = @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "AUTHORITY_ID")
	)
	private List<Authority> authorities;

	@Embedded
	PersonalData personalData;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer newId) {
		this.id = newId;
	}
}
