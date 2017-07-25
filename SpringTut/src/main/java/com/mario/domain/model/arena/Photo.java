package com.mario.domain.model.arena;

import com.mario.domain.model.AuditableEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by mario on 05.12.16.
 */

@Data
@Entity
@Table( name = "GALLERY_PHOTOS" )
@ToString( exclude = { "gallery" } )
@EqualsAndHashCode( exclude = { "gallery" } )
public class Photo
	extends AuditableEntity<Integer> {

	@Id
	@SequenceGenerator( name = "galeryPhoto", sequenceName = "SEQ_GALLERY_PHOTOS_ID" )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "galeryPhoto" )
	private Integer photoId;

	@ManyToOne( fetch = FetchType.LAZY, optional = false )
	@JoinColumn( name = "GALLERY_ID", nullable = false )
	private PhotoGallery gallery;

	@Column( name = "USER_PHOTO_NAME", length = 256 )
	private String userPhotoName;

	@Column( name = "DESCRIPTION", length = 2000 )
	private String description;

	@Column( name = "FILE_NAME", length = 256, unique = true, nullable = false )
	private String fileName;

	@Column( name = "PATH", length = 1000, nullable = false )
	private String path;

	@Override
	public Integer getId() {
		return photoId;
	}

	@Override
	public void setId( Integer newId ) {
		photoId = newId;
	}
}
