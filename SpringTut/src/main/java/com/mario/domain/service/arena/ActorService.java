package com.mario.domain.service.arena;

import com.mario.domain.model.arena.Actor;
import com.mario.domain.model.auth.User;
import com.mario.web.co.arena.dto.ActorSearchCriteria;

/**
 * Created by raqsW on 2016-08-22.
 */
public interface ActorService {

	Iterable<Actor> getAllActors();

	Actor getActorByID( Integer id );

	Actor save( Actor actor );

	Iterable<Actor> searchActors( ActorSearchCriteria actorCriteria );

	Actor getActorByUser( User user );
}
