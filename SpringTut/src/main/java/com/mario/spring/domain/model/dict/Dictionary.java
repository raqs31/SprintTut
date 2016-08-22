package com.mario.spring.domain.model.dict;

import com.mario.spring.domain.model.AuditableEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by raqsW on 2016-08-16.
 */
@Data
@Entity
@Table(name = "DICTIONARIES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DICT_NAME", discriminatorType = DiscriminatorType.STRING)
public abstract class Dictionary extends AuditableEntity<Integer>{
	@Id
	@Column(name = "DICT_ID")
	private Integer dictId;

	@Column(name = "DICT_NAME", nullable = false, length = 128)
	private String dictionaryName;

	@Column(name = "DESCRIPTION")
	private String descrition;

	@Column(name = "VALUE")
	private String value;

	@Column(name = "ATTR_1")
	private String attr1;

	@Column(name = "ATTR_2")
	private String attr2;

	@Column(name = "NUM_ATTR_1")
	private BigDecimal numAttr1;

	@Column(name = "NUM_ATTR_2")
	private BigDecimal numAttr2;

	@Override
	public Integer getId() {
		return dictId;
	}

	@Override
	public void setId(Integer newId) {
		this.dictId = newId;
	}
}
