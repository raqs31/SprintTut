package com.mario.spring.domain.model.auth;

import com.mario.spring.domain.model.AuditableEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by raqsW on 2016-08-18.
 */
@Data
@Entity
@Table(name = "AUTHORITIES")
public class Authority extends AuditableEntity<Integer> {
	@Id
	@Column(name = "AUTHORITY_ID")
	@SequenceGenerator(name = "authIdSeq", initialValue = 0, sequenceName = "AUTHORITY_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authIdSeq")
	private Integer id;

	@Column(name = "AUTHORITY")
	private String authority;

	@ManyToMany(mappedBy = "authorities")
	private List<User> userWithAuthority;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer newId) {
		this.id = newId;
	}
}
