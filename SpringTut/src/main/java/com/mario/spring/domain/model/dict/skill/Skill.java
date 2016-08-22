package com.mario.spring.domain.model.dict.skill;

import com.mario.spring.domain.model.dict.Dictionary;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by raqsW on 2016-08-22.
 */
@Entity
@DiscriminatorValue("SKILLS")
public class Skill extends Dictionary {

}
