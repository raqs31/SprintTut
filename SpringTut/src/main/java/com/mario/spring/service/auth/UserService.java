package com.mario.spring.service.auth;

import com.mario.spring.domain.model.auth.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by raqsW on 2016-08-18.
 */
public interface UserService extends UserDetailsService {
	User loadUser(String loginOrEmail);
}
