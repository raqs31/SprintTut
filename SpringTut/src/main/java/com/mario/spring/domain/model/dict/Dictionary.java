package com.mario.spring.domain.model.dict;

import com.mario.spring.domain.model.AuditableEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by raqsW on 2016-08-16.
 */
@Data
@Entity
@Table(name = "DICTIONARIES",
		indexes = {@Index(name = "PARENT_DICT_IDX", columnList = "PARENT_DICT_ID"),
					@Index(name = "DICT_TYPE_IDX", columnList = "DICT_TYPE")})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DICT_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class Dictionary extends AuditableEntity<Integer>{
	@Id
	@Column(name = "DICT_ID")
	@SequenceGenerator(name = "dictIdSeq", initialValue = 1, sequenceName = "DICTIONARY_IDX_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictIdSeq")
	private Integer dictId;

	@Column(name = "DICT_TYPE", nullable = false, length = 128, insertable = false, updatable = false)
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

	@ManyToOne
	@JoinColumn(name = "PARENT_DICT_ID")
	private Dictionary parentDict;

	@OneToMany(mappedBy = "parentDict", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Dictionary> childrens;

	@Override
	public Integer getId() {
		return dictId;
	}

	@Override
	public void setId(Integer newId) {
		this.dictId = newId;
	}
}
