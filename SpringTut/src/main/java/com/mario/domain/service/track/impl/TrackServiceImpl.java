package com.mario.domain.service.track.impl;

import com.mario.domain.model.tracks.Track;
import com.mario.domain.model.tracks.dict.Director;
import com.mario.domain.model.tracks.dict.TrackType;
import com.mario.domain.repository.TracksRepository;
import com.mario.domain.service.admin.DictionaryService;
import com.mario.domain.service.admin.migration.MigrationTrack;
import com.mario.domain.service.track.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mario on 09.12.16.
 */
@Service
public class TrackServiceImpl
	implements TrackService {

	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	private TracksRepository tracksRepository;

	@Override
	@Transactional( propagation = Propagation.REQUIRED )
	public Track createTrack( Track toAdd ) {
		return tracksRepository.save( toAdd );
	}

	@Override
	@Transactional( propagation = Propagation.MANDATORY )
	public void createTrack( MigrationTrack toMigrate ) {
		if ( tracksRepository.sorTrackIdExists( toMigrate.getTrackId() ) )
			return;

		Track newTrack = new Track();

		newTrack.setTitle( toMigrate.getTitle() );
		newTrack.setSubTitle( toMigrate.getSubTitle() );
		newTrack.setSorTrackId( toMigrate.getTrackId() );
		newTrack.setYear( toMigrate.getYear() );
		newTrack.setSerialNo( toMigrate.getSerialNo() );
		newTrack.setDirector( dictionaryService.findOrCreateDictionary( Director.class, toMigrate.getDirector() ) );
		newTrack.setTrackType( dictionaryService.findOrCreateDictionary( TrackType.class, toMigrate.getTrackType() ) );

		createTrack( newTrack );
	}
}
