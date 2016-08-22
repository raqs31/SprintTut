package com.mario.spring.domain.model.arena;

import com.mario.spring.domain.model.AuditableEntity;
import com.mario.spring.domain.model.auth.User;
import com.mario.spring.domain.model.embedable.PersonalAttributes;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

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

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID", unique = true, nullable = false)
	private User user;

	@OneToMany(mappedBy = "actor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ActorSkill> skills;

	@Embedded
	private PersonalAttributes personalAttributes;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer newId) {
		this.id = newId;
	}
}
