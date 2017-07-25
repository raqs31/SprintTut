package com.mario.web.co.profile.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by nowe konto on 2016-11-30.
 */
@Data
public class FilmographyDTO {

	@NotNull
	private Integer year;

	@NotNull
	@Size( min = 1 )
	private String typOfMovie;

	@NotNull
	@Size( min = 1 )
	private String title;

	@NotNull
	@Size( min = 1 )
	private String subTitle;

	@NotNull
	private Integer episodeNumber;

	@NotNull
	@Size( min = 1 )
	private String role;

	@NotNull
	@Size( min = 1 )
	private String director;

}
