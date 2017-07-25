package com.mario.config.security;

import com.mario.DevMarioApplication;
import com.mario.domain.model.auth.Authority;
import com.mario.domain.model.auth.User;
import com.mario.domain.repository.AuthoritiesRepository;
import com.mario.domain.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by raqsW on 2016-08-16.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity( prePostEnabled = true, securedEnabled = true, jsr250Enabled = true )
class SecurityConfiguration
	extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource ds;

	@Autowired
	private Environment cfg;

	@Autowired
	private UserService userService;

	@Autowired
	private AuthoritiesRepository authoritiesRepository;

	@Value( "${DEFAULT_USER_NAME}" )
	private String userName;

	@Value( "${DEFAULT_USER_PASSWORD}" )
	private String password;

	@Value( "${DEFAULT_USER_EMAIL}" )
	private String email;

	@Override
	protected void configure( AuthenticationManagerBuilder auth )
		throws Exception {
		for ( Authority.Role role : Authority.Role.values() ) {
			if ( authoritiesRepository.findOne( role ) == null )
				authoritiesRepository.save( new Authority( role ) );
		}

		if ( userService.loadUser( userName ) == null ) {
			List<Authority> authorities = new LinkedList<>();
			authoritiesRepository.findAll().forEach( authorities::add );

			User u = new User();
			u.setUserName( userName );
			u.setEmail( email );
			u.setPassword( password );
			u.setEnabled( true );
			u.setAuthorities( authorities );

			userService.createUser( u );
		}

		auth.userDetailsService( userService ).passwordEncoder( new BCryptPasswordEncoder() ).and().jdbcAuthentication()
			.dataSource( this.ds );
	}

	@Override
	protected void configure( HttpSecurity http )
		throws Exception {
		http.authorizeRequests().antMatchers( "/css/**", "/fonts/**", "/img/**", "/js/**", "/auth/register" )
			.permitAll().anyRequest().authenticated().and().formLogin().loginPage( "/auth/login" )
			.failureUrl( "/auth/login?error" ).permitAll().and().logout().permitAll()
			.logoutRequestMatcher( new AntPathRequestMatcher( "/logout" ) ).and().exceptionHandling()
			.accessDeniedPage( "/403" );

		// for (Authority.Role role: Authority.Role.values()) {
		// http.authorizeRequests()
		// .antMatchers(role.getGrantForMatch().toArray(new String[0])).hasRole(role.name());
		// }

		if ( Arrays.stream( cfg.getActiveProfiles() ).anyMatch( s -> s.equals( DevMarioApplication.PROFILE_NAME ) ) ) {
			// Udostepnienie konsolki
			http.csrf().disable().headers().frameOptions().disable().and().authorizeRequests()
				.antMatchers( "/console/*" ).permitAll().anyRequest().permitAll();
		}
	}
}
