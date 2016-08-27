package com.mario.spring.domain.service.arena.impl;

import com.mario.spring.domain.model.arena.Actor;
import com.mario.spring.domain.repository.ActorRepository;
import com.mario.spring.domain.service.arena.ActorService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

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
