package com.mario.domain.service.admin.migration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mario on 08.12.16.
 */
@XmlRootElement( name = "tracks" )
@XmlAccessorType( XmlAccessType.FIELD )
@NoArgsConstructor
public class MigrationTracks {

	@Getter
	@Setter
	@XmlElement( name = "migrationTrack" )
	private List<MigrationTrack> tracks;

	public MigrationTracks( MigrationTrack... tracks ) {
		this.tracks = new LinkedList();

		for ( MigrationTrack track : tracks ) {
			this.tracks.add( track );
		}
	}
}
