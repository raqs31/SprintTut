package com.mario.domain.model.arena;

import com.mario.domain.model.AuditableEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by mario on 05.12.16.
 */
@Data
@Entity
@Table( name = "ACTOR_PHOTOS_GALLERY" )
@ToString( exclude = { "actor", "photos" } )
@EqualsAndHashCode( exclude = { "actor", "gallery" } )
public class PhotoGallery
	extends AuditableEntity<Integer> {

	@Id
	@SequenceGenerator( name = "galeryIdSeq", sequenceName = "SEQ_PHOTO_GALERY_ID" )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "galeryIdSeq" )
	private Integer galeryId;

	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "ACTOR_ID", nullable = false )
	private Actor actor;

	@OneToMany( mappedBy = "gallery", orphanRemoval = true, cascade = CascadeType.ALL )
	private Set<Photo> photos;

	@Override
	public Integer getId() {
		return galeryId;
	}

	@Override
	public void setId( Integer newId ) {
		galeryId = newId;
	}
}
