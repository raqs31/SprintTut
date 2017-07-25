package com.mario.web.co.arena.dto;

import lombok.Data;

/**
 * Created by nowe konto on 2016-12-07.
 */
@Data
public class SkillsCriteria {

	private String name;

	private boolean checked;

	public SkillsCriteria( String name, boolean checked ) {
		this.name = name;
		this.checked = checked;
	}
}
