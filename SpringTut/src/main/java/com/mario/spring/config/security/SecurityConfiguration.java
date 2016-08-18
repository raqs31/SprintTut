package com.mario.spring.config.security;

import com.mario.spring.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.inject.Inject;
import javax.sql.DataSource;

/**
 * Created by raqsW on 2016-08-16.
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource ds;

	@Inject
	private UserService userService;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
		auth.jdbcAuthentication()
				.dataSource(this.ds);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
	}
}
