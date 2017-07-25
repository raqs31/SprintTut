package com.mario.domain.service.arena.impl;

import com.mario.domain.model.arena.Actor;
import com.mario.domain.model.arena.ActorSkill;
import com.mario.domain.model.auth.User;
import com.mario.domain.model.embedable.PersonalAttributes;
import com.mario.domain.model.embedable.PersonalData;
import com.mario.domain.repository.ActorRepository;
import com.mario.domain.service.arena.ActorService;
import com.mario.web.co.arena.dto.ActorSearchCriteria;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by raqsW on 2016-08-22.
 */
@Service
public class ActorServiceImpl
	implements ActorService {

	@Inject
	private ActorRepository actorRepository;

	@PersistenceContext
	private EntityManager em;

	@Override
	public Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	@Override
	public Actor save( Actor actor ) {
		return actorRepository.save( actor );
	}

	public Actor getActorByUser( User user ) {
		return actorRepository.findActorByUser( user );
	}

	public Actor getActorByID( Integer id ) {
		PersonalAttributes pa = new PersonalAttributes();
		pa.setAboutActor( "About" );
		pa.setEducation( "ASP" );
		pa.setEyeColor( "Green" );
		pa.setHairColor( "Blonde" );
		pa.setHeight( 180 );
		pa.setWeight( 90.0 );
		PersonalData pd = new PersonalData();
		pd.setName( "Jan" );
		pd.setLastName( "Kowalski" );
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/M/yyyy" );
		String dt = "31/8/1891";
		Date date = null;
		try {
			date = sdf.parse( dt );
		}
		catch ( ParseException e ) {
			e.printStackTrace();
		}
		pd.setBirthday( date );
		pd.setGender( PersonalData.Gender.MALE );
		pd.setPhoneNumber( "511697828" );
		pd.setSecondName( "Janusz" );
		User us = new User();
		us.setId( 1 );
		us.setPersonalData( pd );
		Actor actor = new Actor();
		ActorSkill as = new ActorSkill();
		as.setActor( actor );
		as.setId( 1 );
		List<ActorSkill> actorSkillList = new ArrayList<>();
		actorSkillList.add( as );
		actor.setPersonalAttributes( pa );
		actor.setId( 1 );
		actor.setSkills( actorSkillList );
		actor.setUser( us );
		return actor;
		// return actorRepository.findOne(id);
	}

	@Override
	public Iterable<Actor> searchActors( ActorSearchCriteria actorCriteria ) {
		boolean firstCriteria = false;
		StringBuilder search = new StringBuilder( "Select a from Actor a, User u"
			+ " where 1=1 and a.user_id = u.id " );

		if ( actorCriteria.getName() != null && !actorCriteria.getName().equals( "" ) ) {
			search.append( "and u.name = '" + actorCriteria.getName() + "' " );
		}
		if ( actorCriteria.getSurname() != null && !actorCriteria.equals( "" ) ) {
			search.append( "and u.surname = '" + actorCriteria.getSurname() + "' " );
		}
		if ( actorCriteria.getHeight() != null && !actorCriteria.getHeight().equals( "" ) ) {
			search.append( "and u.height > " + actorCriteria.getHeight() + " " );
		}
		if ( actorCriteria.getStartWeight() != null && !actorCriteria.getStartWeight().equals( "" ) ) {
			if ( actorCriteria.getEndWeight() != null && !actorCriteria.getEndWeight().equals( "" ) ) {
				search.append( "and u.weight between " + actorCriteria.getStartWeight() + " and "
					+ actorCriteria.getEndWeight() + " " );
			}
			else {
				search.append( "and u.weight > " + actorCriteria.getHeight() + " " );
			}
		}
		if ( actorCriteria.getEndWeight() != null && !actorCriteria.getEndWeight().equals( "" )
			&& ( actorCriteria.getStartWeight() == null || actorCriteria.getStartWeight().equals( "" ) ) ) {
			search.append( "and u.weight < " + actorCriteria.getEndWeight() + " " );

		}

		search.append( ";" );

		return new ArrayList<>();

		// return em.createQuery(search.toString()).getResultList();

	}
}
