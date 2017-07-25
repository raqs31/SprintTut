package com.mario.web.co.auth.dto;

import com.mario.domain.validation.phoneNumber.PhoneNumber;
import com.mario.domain.validation.email.ExistEmail;
import com.mario.domain.validation.email.ValidEmail;
import com.mario.domain.validation.password.PasswordMatches;
import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by nowe konto on 2016-12-02.
 */
@Data
@PasswordMatches( message = "register.form.password.match" )
public class UserDTO {

	@ValidEmail( message = "register.form.email.invalid" )
	@NotNull( message = "register.form.null" )
	@ExistEmail( message = "register.form.email.exist" )
	private String email;

	@NotNull( message = "register.form.null" )
	@Size( min = 6, max = 16, message = "register.form.password.size" )
	private String password;

	@NotNull( message = "register.form.null" )
	private String confirmPassword;

	@NotNull( message = "register.form.null" )
	@Size( min = 1, message = "register.form.country" )
	private String country;

	@NotNull( message = "register.form.null" )
	@Size( min = 1, message = "register.form.null" )
	private String fullName;

	@NotNull( message = "register.form.null" )
	@Size( min = 1, message = "register.form.null" )
	private String nip;

	@NotNull( message = "register.form.null" )
	@Size( min = 1, message = "register.form.null" )
	private String address;

	@NotNull( message = "register.form.null" )
	@Size( min = 1, message = "register.form.null" )
	private String city;

	@NotNull( message = "register.form.null" )
	@Size( min = 1, message = "register.form.null" )
	private String postalCode;

	@NotNull( message = "register.form.null" )
	@Size( min = 1, message = "register.form.null" )
	private String province;

	@NotNull( message = "register.form.null" )
	@PhoneNumber( message = "register.from.phone.invalid" )
	private String phoneNumber;

	@AssertTrue( message = "register.form.checkbox.rules" )
	private boolean checkBoxRules;

	@AssertTrue( message = "register.form.checkbox.information" )
	private boolean checkBoxInformation;

}
