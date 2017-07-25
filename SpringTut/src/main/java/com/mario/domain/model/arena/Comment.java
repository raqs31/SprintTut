package com.mario.domain.model.arena;

import com.mario.domain.model.AuditableEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by mario on 07.12.16.
 */
@Entity
@Table( name = "ACTOR_COMMENTS" )
@Data
@ToString( exclude = "actor" )
public class Comment
	extends AuditableEntity<Integer> {

	@Id
	@Column( name = "COMMENT_ID" )
	@SequenceGenerator( name = "commentSeq", sequenceName = "SEQ_COMMENT_IDS" )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "commentSeq" )
	private Integer commentId;

	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "ACTOR_ID", nullable = false, updatable = false )
	private Actor actor;

	@Column( name = "COMMENT", length = 4000 )
	private String comment;

	@Override
	public Integer getId() {
		return commentId;
	}

	@Override
	public void setId( Integer newId ) {
		this.commentId = newId;
	}
}
