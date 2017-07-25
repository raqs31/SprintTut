package com.mario.domain.repository;

/**
 * Created by mario on 07.12.16.
 */
public enum Hints {
	FETCH_GRAPH( "javax.persistence.fetchgraph" ), LOAD_GRAPH( "javax.persistence.loadgraph" );

	public final String name;

	Hints( String name ) {
		this.name = name;
	}
}
