package com.mario.domain.model.arena;

import com.mario.domain.model.AuditableEntity;
import com.mario.domain.model.auth.User;
import com.mario.domain.model.embedable.PersonalAttributes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by raqsW on 2016-08-19.
 */
@Data
@EqualsAndHashCode( exclude = { "user", "galleries", "filmographyList", "profilePhoto", "comments" } )
@ToString( exclude = { "user", "galleries", "filmographyList", "profilePhoto", "comments" } )
@Entity
@Table( name = "ACTORS" )
public class Actor
	extends AuditableEntity<Integer> {

	@Id
	@Column( name = "ACTOR_ID" )
	@SequenceGenerator( name = "actorsIdxSeq", initialValue = 0, sequenceName = "ACTORS_IDX_SEQ" )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "actorsIdxSeq" )
	private Integer id;

	@OneToOne( fetch = FetchType.EAGER )
	@JoinColumn( name = "USER_ID", unique = true, nullable = false )
	private User user;

	@OneToMany( mappedBy = "actor", cascade = CascadeType.ALL, orphanRemoval = true )
	private List<ActorSkill> skills;

	@OneToMany( mappedBy = "actor", cascade = {
		CascadeType.REMOVE,
		CascadeType.DETACH,
		CascadeType.REFRESH }, orphanRemoval = true )
	private List<PhotoGallery> galleries;

	@OneToMany( mappedBy = "actor", cascade = {
		CascadeType.REMOVE,
		CascadeType.DETACH,
		CascadeType.REFRESH }, orphanRemoval = true )
	private List<Comment> comments;

	@OrderBy( "creationDate" )
	@OneToMany( mappedBy = "actor", cascade = {
		CascadeType.REMOVE,
		CascadeType.DETACH,
		CascadeType.REFRESH }, orphanRemoval = true )
	private List<ActorTrack> filmographyList;

	@OneToOne( fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH, CascadeType.DETACH } )
	@JoinColumn( name = "PROFILE_PHOTO_ID" )
	private Photo profilePhoto;

	@Column( name = "LAST_LOGIN_DATE" )
	@Temporal( TemporalType.TIMESTAMP )
	private Date lastLoginDate;

	@Embedded
	private PersonalAttributes personalAttributes;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId( Integer newId ) {
		this.id = newId;
	}
}
