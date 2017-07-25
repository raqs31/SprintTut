package com.mario.domain.repository;

import com.mario.domain.model.arena.Actor;
import com.mario.domain.model.auth.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by raqsW on 2016-08-22.
 */
@Repository
public interface ActorRepository
	extends CrudRepository<Actor, Integer> {

	Actor findActorByUser( User user );
}
