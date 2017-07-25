package com.mario.domain.model.dict;

import com.mario.domain.model.AuditableEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by raqsW on 2016-08-16.
 */
@Data
@ToString( exclude = { "parentDict", "childrens" } )
@Entity
@Table(name = "DICTIONARIES",
	indexes = { @Index( name = "IDX_DICT_TYPE_VALUE", columnList = "DICT_TYPE,VALUE", unique = true ) } )
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DICT_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Dictionary<P extends Dictionary, C extends Dictionary>
	extends AuditableEntity<Integer> {
	@Id
	@Column(name = "DICT_ID")
	@SequenceGenerator( name = "dictIdSeq", initialValue = 1, sequenceName = "SEQ_DICTIONARY_IDX" )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictIdSeq")
	private Integer dictId;

	@Column(name = "DICT_TYPE", nullable = false, length = 128, insertable = false, updatable = false)
	private String dictType;

	@Column(name = "DESCRIPTION")
	private String description;

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

	@Column( name = "DICT_ORDER" )
	private Integer order;

	@ManyToOne( targetEntity = Dictionary.class )
	@JoinColumn(name = "PARENT_DICT_ID")
	private P parentDict;

	@OneToMany( mappedBy = "parentDict", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Dictionary.class )
	private List<C> childrens;

	@Override
	public Integer getId() {
		return dictId;
	}

	@Override
	public void setId(Integer newId) {
		this.dictId = newId;
	}
}
