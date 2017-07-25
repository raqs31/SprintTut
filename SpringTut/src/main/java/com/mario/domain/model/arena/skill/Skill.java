package com.mario.domain.model.arena.skill;

import com.mario.domain.model.dict.Dictionary;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by raqsW on 2016-08-22.
 */
@Entity
@DiscriminatorValue( Skill.TYPE )
public class Skill
	extends Dictionary<SkillType, Dictionary> {

	public static final String TYPE = "SKILLS";
}
