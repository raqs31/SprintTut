package com.mario.spring.domain.model.arena;

import com.mario.spring.domain.model.AuditableEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by raqsW on 2016-08-22.
 */
@Data
@Entity
@Table(name = "ACTOR_SKILLS")
public class ActorSkill extends AuditableEntity<Integer>{
	@Id
	@Column(name = "ACTOR_SKILL_ID")
	@SequenceGenerator(name = "actorSkillsSeq", sequenceName = "ACTOR_SKILLS_IDX_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actorSkillsSeq")
	private Integer skillId;

	@Override
	public Integer getId() {
		return skillId;
	}

	@Override
	public void setId(Integer newId) {
		this.skillId = newId;
	}
}
