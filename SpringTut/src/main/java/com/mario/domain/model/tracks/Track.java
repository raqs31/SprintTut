package com.mario.domain.model.tracks;

import com.mario.domain.model.AuditableEntity;
import com.mario.domain.model.tracks.dict.Director;
import com.mario.domain.model.tracks.dict.TrackType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by mario on 05.12.16.
 */
@Data
@Entity
@Table( name = "TRACKS", indexes = {
	@Index( name = "IDX_SOR_TRACK_ID", columnList = "SOR_TRACK_ID" ),
	@Index( columnList = "TRACK_TYPE_ID, YEAR" ) } )
@ToString( exclude = { "typeOfFilm" } )
@EqualsAndHashCode( exclude = { "typeOfFilm" } )
public class Track
	extends AuditableEntity<Integer> {

	@Id
	@Column( name = "TRACK_ID" )
	@SequenceGenerator( name = "tracksSeq", sequenceName = "SEQ_TRACK_IDS" )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "tracksSeq" )
	private Integer trackId;

	@Column( name = "YEAR" )
	private Integer year;

	@Column( name = "TITLE", nullable = false, length = 300 )
	private String title;

	@Column( name = "SUB_TITLE", length = 300 )
	private String subTitle;

	@Column( name = "SERIAL_NO" )
	private Integer serialNo;

	@Column( name = "SOR_TRACK_ID", updatable = false )
	private Integer sorTrackId;

	@ManyToOne( fetch = FetchType.LAZY, optional = false )
	@JoinColumn( name = "DIRECTOR_ID", nullable = false )
	private Director director;

	@ManyToOne( fetch = FetchType.LAZY, optional = false )
	@JoinColumn( name = "TRACK_TYPE_ID", nullable = false )
	private TrackType trackType;

	@Override
	public Integer getId() {
		return trackId;
	}

	@Override
	public void setId( Integer newId ) {
		trackId = newId;
	}
}
