package com.mario.domain.model.arena.skill;

import com.mario.domain.model.dict.Dictionary;
import com.mario.domain.model.dict.DictionaryType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by raqsW on 2016-08-22.
 */
@Entity
@DiscriminatorValue( SkillType.TYPE )
public class SkillType
	extends Dictionary<DictionaryType, Skill> {

	public static final String TYPE = "SKILL_TYPE";
}
