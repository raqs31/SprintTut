package com.mario.domain.service.admin.migration.impl;

import com.mario.domain.service.admin.migration.DataExtractor;
import com.mario.domain.service.admin.migration.DataMigrationService;
import com.mario.domain.service.admin.migration.MigrationTracks;
import com.mario.domain.service.admin.migration.Migrator;
import com.mario.domain.service.track.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * Created by mario on 07.12.16.
 */
@Migrator( MigrationTracks.class )
@Service
@Transactional( isolation = Isolation.REPEATABLE_READ )
public class TrackMigrationServiceImpl
	implements DataMigrationService<MigrationTracks> {

	@Autowired
	private TrackService trackService;

	@Override
	public void migrateData( DataExtractor<MigrationTracks> extractor ) {
		Assert.notNull( extractor, "Pass null extractor" );

		MigrationTracks toMigrate = extractor.extract();

		toMigrate.getTracks().forEach( trackService::createTrack );
	}
}
