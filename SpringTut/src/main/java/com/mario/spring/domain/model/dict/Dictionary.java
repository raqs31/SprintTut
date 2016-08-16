package com.mario.spring.domain.model.dict;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by raqsW on 2016-08-16.
 */
@Data
@Entity
@Table(name = "DICTIONARIES")
public class Dictionary {
	@Id
	@Column(name = "DICT_ID")
	private Integer dictId;

	@Column(name = "DICT_NAME", nullable = false, length = 128)
	private String dictionaryName;
}
