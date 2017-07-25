package com.mario.domain.service.auth.impl;

import com.mario.aop.Profiled;
import com.mario.domain.model.auth.User;
import com.mario.domain.model.embedable.Adress;
import com.mario.domain.model.embedable.PersonalData;
import com.mario.domain.repository.UserRepository;
import com.mario.domain.service.auth.UserService;
import com.mario.web.co.auth.dto.UserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class UserServiceImpl
	implements UserService {

	@Inject
	private UserRepository userRepository;

	public User findUserByUsername( String s )
		throws UsernameNotFoundException {
		User u = userRepository.findOneByUserNameOrEmailAllIgnoreCase( s, s );
		return u == null ? null : u;

	}

	@Profiled
	@Override
	public UserDetails loadUserByUsername( String s )
		throws UsernameNotFoundException {
		User u = userRepository.findOneByUserNameOrEmailAllIgnoreCase( s, s );
		if ( u == null )
			return null;

		return new org.springframework.security.core.userdetails.User( u.getUserName(), u.getPassword(),
																	   getAuthorities( u ) );
	}

	private Set<GrantedAuthority> getAuthorities( User u ) {
		Set<GrantedAuthority> authorities = new HashSet<>();
		u.getAuthorities()
			.forEach( authority -> authorities.add( new SimpleGrantedAuthority( authority.getAuthority().name() ) ) );

		return authorities;
	}

	public User loadUser( String loginOrEmail ) {
		return userRepository.findOneByUserNameOrEmailAllIgnoreCase( loginOrEmail, loginOrEmail );
	}

	@Override
	public void createUser( User newUser ) {
		if ( newUser == null )
			throw new NullPointerException( "newUser is null" );
		newUser.setPassword( new BCryptPasswordEncoder().encode( newUser.getPassword() ) );
		userRepository.save( newUser );
	}

	@Override
	public void createUserFromDTO( UserDTO userDTO ) {
		if ( userDTO == null ) {
			throw new NullPointerException( "newUser is null" );
		}
		User user = new User();
		user.setEmail( userDTO.getEmail() );
		user.setPassword( new BCryptPasswordEncoder().encode( userDTO.getPassword() ) );
		user.setUserName( userDTO.getEmail() );
		PersonalData personalData = new PersonalData();
		String[] tokens = userDTO.getFullName().split( " " );
		personalData.setName( tokens[0] );
		personalData.setLastName( tokens[1] );
		personalData.setPhoneNumber( userDTO.getPhoneNumber() );
		personalData.setNip( userDTO.getNip() );
		Adress address = new Adress();
		address.setCity( userDTO.getCity() );
		address.setStreet( userDTO.getAddress() );
		address.setCountryCode( userDTO.getCountry() );
		address.setProvince( userDTO.getProvince() );
		address.setPostalCode( userDTO.getPostalCode() );
		personalData.setAdress( address );
		user.setPersonalData( personalData );
		user.setEnabled( true );
		userRepository.save( user );
	}
}
