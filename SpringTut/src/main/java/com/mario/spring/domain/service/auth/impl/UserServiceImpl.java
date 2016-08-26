package com.mario.spring.domain.service.auth.impl;

import com.mario.spring.domain.model.auth.User;
import com.mario.spring.domain.repository.repository.UserRepository;
import com.mario.spring.domain.service.auth.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by raqsW on 2016-08-18.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Inject
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		User u = userRepository.findOneByUserNameOrEmailAllIgnoreCase(s,s);
		if (u == null)
			return null;

		return new org.springframework.security.core.userdetails.User(u.getUserName(), u.getPassword(), getAuthorities(u));
	}

	private Set<GrantedAuthority> getAuthorities(User u) {
		Set<GrantedAuthority> authorities = new HashSet<>();
		u.getAuthorities().forEach(authority -> authorities.add(new SimpleGrantedAuthority(authority.getAuthority())));

		return authorities;
	}

	public User loadUser(String loginOrEmail) {
		return userRepository.findOneByUserNameOrEmailAllIgnoreCase(loginOrEmail, loginOrEmail);
	}
}
