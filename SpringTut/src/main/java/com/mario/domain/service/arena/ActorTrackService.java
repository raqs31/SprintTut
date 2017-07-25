package com.mario.domain.service.arena;

import com.mario.domain.model.arena.Actor;
import com.mario.domain.model.arena.ActorTrack;

/**
 * Created by nowe konto on 2016-12-09.
 */
public interface ActorTrackService {

	Iterable<ActorTrack> findActorTrackByActorID( Actor actor );

	ActorTrack create( ActorTrack actorTrack );
}
