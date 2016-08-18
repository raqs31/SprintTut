package com.mario.spring.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by raqsW on 2016-08-18.
 */
@MappedSuperclass
public abstract class AuditableEntity<T> implements BaseEntity<T> {
	@Getter
	@Setter
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Getter
	@Setter
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdatedDate;

	@Getter
	@Setter
	@Column(name = "CREATED_BY")
	private String createdBy;

	@Getter
	@Setter
	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;

	@PreUpdate
	protected void preUpdate() {
		lastUpdatedDate = Calendar.getInstance().getTime();
		lastUpdatedBy = SecurityContextHolder.getContext().getAuthentication().getName();
	}

	@PrePersist
	protected void prePersist() {
		creationDate = Calendar.getInstance().getTime();
		createdBy = SecurityContextHolder.getContext().getAuthentication().getName();
		preUpdate();
	}
}
