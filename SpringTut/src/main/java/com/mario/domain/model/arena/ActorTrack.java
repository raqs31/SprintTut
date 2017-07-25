package com.mario.domain.model.arena;

import com.mario.domain.model.AuditableEntity;
import com.mario.domain.model.tracks.Track;
import com.mario.domain.model.tracks.dict.Role;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mario on 07.12.16.
 */
@Entity
@Table( name = "ACTOR_TRACKS" )
@Data
@IdClass( ActorTrack.ActorTrackId.class )
@ToString( exclude = { "actor", "track", "role" } )
@EqualsAndHashCode( exclude = { "actor", "track", "role" } )
public class ActorTrack
	extends AuditableEntity<ActorTrack.ActorTrackId> {

	@Id
	@ManyToOne
	@JoinColumn( name = "ACTOR_ID", nullable = false, updatable = false )
	private Actor actor;

	@Id
	@ManyToOne
	@JoinColumn( name = "TRACK_ID", nullable = false, updatable = false )
	private Track track;

	@Id
	@ManyToOne
	@JoinColumn( name = "ROLE_ID", nullable = false, updatable = false )
	private Role role;

	@Override
	public ActorTrackId getId() {
		return new ActorTrackId( actor, track, role );
	}

	@Override
	public void setId( ActorTrackId newId ) {
		actor = newId.actor;
		track = newId.track;
		role = newId.role;
	}

	@NoArgsConstructor
	@AllArgsConstructor
	public class ActorTrackId
		implements Serializable {

		private Actor actor;

		private Track track;

		private Role role;

	}
}
