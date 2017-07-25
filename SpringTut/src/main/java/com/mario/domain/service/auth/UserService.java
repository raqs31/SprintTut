package com.mario.domain.service.auth;

import com.mario.domain.model.auth.User;
import com.mario.web.co.auth.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by raqsW on 2016-08-18.
 */
public interface UserService
	extends UserDetailsService {

	User loadUser( String loginOrEmail );

	void createUser( User newUser );

	void createUserFromDTO( UserDTO userDTO );

	User findUserByUsername( String s )
		throws UsernameNotFoundException;

}
