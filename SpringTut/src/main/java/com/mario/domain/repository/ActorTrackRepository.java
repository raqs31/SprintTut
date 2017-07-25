package com.mario.domain.repository;

import com.mario.domain.model.arena.Actor;
import com.mario.domain.model.arena.ActorTrack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nowe konto on 2016-12-09.
 */
@Repository
public interface ActorTrackRepository
	extends CrudRepository<ActorTrack, Integer> {

	Iterable<ActorTrack> findByActor( Actor actor );
}
