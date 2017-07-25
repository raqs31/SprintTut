package com.mario.domain.model;

import java.io.Serializable;

/**
 * Created by raqsW on 2016-08-18.
 */
public interface BaseEntity<T> extends Serializable {
	T getId();

	void setId(T newId);
}
