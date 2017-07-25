package com.mario.domain.service.admin.migration.extractor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.inject.Singleton;
import java.io.FileNotFoundException;

/**
 * Created by mario on 08.12.16.
 */
@Component
@Singleton
public class TracksFromCacheExtractor
	extends TrackFromFileExtractor {

	public TracksFromCacheExtractor( @Value( "${TRACKS_FILE_PATH}" ) String cacheFilePath )
		throws FileNotFoundException {
		super( ResourceUtils.getFile( cacheFilePath ) );
	}
}
