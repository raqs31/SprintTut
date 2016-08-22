package com.mario.spring.domain.model.arena;

import com.mario.spring.domain.model.AuditableEntity;
import com.mario.spring.domain.model.auth.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by raqsW on 2016-08-19.
 */
@Data
@EqualsAndHashCode(exclude = {"user"})
@Entity
@Table(name = "ACTORS")
public class Actor extends AuditableEntity<Integer> {

	@Id
	@Column(name = "ACTOR_ID")
	@SequenceGenerator(name = "actorsIdxSeq", initialValue = 0, sequenceName = "ACTORS_IDX_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actorsIdxSeq")
	private Integer id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", unique = true, nullable = false)
	private User user;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer newId) {
		this.id = newId;
	}
}
