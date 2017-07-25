package com.mario.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Created by mario on 05.12.16.
 */
@MappedSuperclass
public abstract class VersionEntity<T>
	extends AuditableEntity<T> {

	@Getter
	@Setter
	@Version
	@Column( name = "VERSION_NUM" )
	private Integer version;
}
