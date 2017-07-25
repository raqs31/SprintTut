package com.mario.domain.service.track;

import com.mario.domain.model.tracks.Track;
import com.mario.domain.service.admin.migration.MigrationTrack;

/**
 * Created by mario on 09.12.16.
 */
public interface TrackService {

	Track createTrack( Track toAdd );

	void createTrack( MigrationTrack toMigrate );
}
