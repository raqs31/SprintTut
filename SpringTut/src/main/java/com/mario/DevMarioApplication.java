package com.mario;

import com.mario.domain.model.auth.User;
import com.mario.domain.service.auth.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Inject;

@SpringBootApplication
@Profile( DevMarioApplication.PROFILE_NAME )
public class DevMarioApplication {

	public static final String PROFILE_NAME = "dev";

	@Inject
	private UserService userService;

	public static void main( String[] args ) {
		System.setProperty( "spring.devtools.restart.enabled", "false" );
		SpringApplication.run( DevMarioApplication.class, args );
	}

	@EventListener( ContextStartedEvent.class )
	private void onContextStart( ContextStartedEvent event ) {
		User user = new User();
		user.setUserName( "ADMIN" );
		user.setEmail( "ADMIN@ADMIN" );
		user.setPassword( new BCryptPasswordEncoder().encode( "ADMIN" ) );
		user.setEnabled( true );
		userService.createUser( user );
	}

}
