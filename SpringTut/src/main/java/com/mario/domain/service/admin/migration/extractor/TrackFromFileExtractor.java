package com.mario.domain.service.admin.migration.extractor;

import com.mario.domain.service.admin.migration.DataExtractor;
import com.mario.domain.service.admin.migration.MigrationTrack;
import com.mario.domain.service.admin.migration.MigrationTracks;
import org.apache.log4j.Logger;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * Created by mario on 08.12.16.
 */
public class TrackFromFileExtractor
	implements DataExtractor<MigrationTracks> {

	private static final Logger LOGGER = Logger.getLogger( TrackFromFileExtractor.class );

	private final File file;

	private Jaxb2Marshaller unmarshaller;

	public TrackFromFileExtractor( File file ) {
		this.file = file;

		unmarshaller = new Jaxb2Marshaller();
		unmarshaller.setClassesToBeBound( MigrationTrack.class, MigrationTracks.class );
	}

	@Override
	public MigrationTracks extract() {
		LOGGER.debug( "Parsed file: " + file.getName() );

		try (InputStream inputStream = new FileInputStream( file )) {
			MigrationTracks tracks = (MigrationTracks) unmarshaller.unmarshal( new StreamSource( inputStream ) );
			LOGGER.debug( tracks );
			return tracks;
		}
		catch ( FileNotFoundException e ) {
			e.printStackTrace();
		}
		catch ( IOException e ) {
			e.printStackTrace();
		}

		// TODO dodać produkcję wyjątku

		return null;
	}
}
