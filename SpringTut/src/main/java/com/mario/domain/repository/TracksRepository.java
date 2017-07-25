package com.mario.domain.repository;

import com.mario.domain.model.tracks.Track;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mario on 07.12.16.
 */
@Repository
public interface TracksRepository
	extends CrudRepository<Track, Integer> {

	@Query( value = "select count(t) > 0 from Track t where t.sorTrackId = ?1" )
	Boolean sorTrackIdExists( Integer sorTrackId );
}
