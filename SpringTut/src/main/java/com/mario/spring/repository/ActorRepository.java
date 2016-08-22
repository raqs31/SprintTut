package com.mario.spring.repository;

import com.mario.spring.domain.model.arena.Actor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by raqsW on 2016-08-22.
 */
public interface ActorRepository extends CrudRepository<Actor, Integer> {
}
