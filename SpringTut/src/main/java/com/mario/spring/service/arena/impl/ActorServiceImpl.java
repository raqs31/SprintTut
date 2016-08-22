package com.mario.spring.service.arena.impl;

import com.mario.spring.domain.model.arena.Actor;
import com.mario.spring.repository.ActorRepository;
import com.mario.spring.service.arena.ActorService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Iterator;

/**
 * Created by raqsW on 2016-08-22.
 */
@Service
public class ActorServiceImpl implements ActorService {
	@Inject
	private ActorRepository actorRepository;

	@Override
	public Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}
}
