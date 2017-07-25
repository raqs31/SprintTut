package com.mario.domain.service.admin.migration;

/**
 * Created by mario on 07.12.16.
 */
public interface DataMigrationService<T> {

	void migrateData( DataExtractor<T> extractor );
}
