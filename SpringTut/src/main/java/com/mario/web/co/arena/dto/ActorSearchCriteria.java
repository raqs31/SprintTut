package com.mario.web.co.arena.dto;

import com.google.common.collect.ImmutableList;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by nowe konto on 2016-12-06.
 */
@Data
public class ActorSearchCriteria {

	public static final ImmutableList<String> SKILLS = ImmutableList.of( "Altówka", "Bębny", "Fagot", "Flet koncertowy",
																		 "Altówka", "Akordeon" );

	public static final ImmutableList<SkillsCriteria> SKILLS_CRITERIAS = ImmutableList
		.of( new SkillsCriteria( "Altówka", false ), new SkillsCriteria( "Bębny", false ),
			 new SkillsCriteria( "Altówka", false ), new SkillsCriteria( "Fagot", false ),
			 new SkillsCriteria( "Flet koncertowy", false ) );

	private String name;

	private String surname;

	private String height;

	private String startWeight;

	private String endWeight;

	private String eyesColor;

	private String hairsColor;

	private Map<String, Boolean> skillsMap;

	private List<SkillsCriteria> skills = new ArrayList<>( SKILLS_CRITERIAS );

	private List<LanguagesDTO> languages;

	private List<String> specialization;

	public static enum HairsColor {
		BLONDE, RED, BLACK, BROWN
	}
}
