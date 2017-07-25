package com.mario.domain.model.arena;

import com.mario.domain.model.AuditableEntity;
import com.mario.domain.model.arena.skill.Skill;
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

	@ManyToOne(optional = false)
	@JoinColumn(name = "ACTOR_ID", nullable = false)
	private Actor actor;

	@ManyToOne(optional = false)
	@JoinColumn(name = "DICT_ID", nullable = false)
	private Skill skill;

	@Override
	public Integer getId() {
		return skillId;
	}

	@Override
	public void setId(Integer newId) {
		this.skillId = newId;
	}
}
