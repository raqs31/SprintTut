package com.mario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile( MarioApplication.PROFILE_NAME )
public class MarioApplication {

	public static final String PROFILE_NAME = "PROD";

	public static void main( String[] args ) {
		System.setProperty( "spring.devtools.restart.enabled", "false" );
		SpringApplication.run( MarioApplication.class, args );
	}
}
