package com.mario.domain.service.arena.impl;

import com.mario.domain.model.arena.Actor;
import com.mario.domain.model.arena.ActorTrack;
import com.mario.domain.repository.ActorTrackRepository;
import com.mario.domain.service.arena.ActorTrackService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by nowe konto on 2016-12-09.
 */
@Service
public class ActorTrackServiceImpl
	implements ActorTrackService {

	@Inject
	private ActorTrackRepository actorTrackRepository;

	@Override
	public Iterable<ActorTrack> findActorTrackByActorID( Actor actor ) {
		return actorTrackRepository.findByActor( actor );
	}

	@Override
	public ActorTrack create( ActorTrack actorTrack ) {
		return actorTrackRepository.save( actorTrack );
	}

}
