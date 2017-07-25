package com.mario.domain.repository.ext.impl;

import com.mario.domain.model.dict.DictionaryType;
import com.mario.domain.repository.ext.DictionariesRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

/**
 * Created by raqsW on 2016-09-02.
 */
public class DictionariesRepositoryImpl
	implements DictionariesRepositoryCustom {

	@PersistenceContext( type = PersistenceContextType.EXTENDED )
	EntityManager em;

	@Override
	public List<DictionaryType> findAllDictionaryTypes() {
		return em.createQuery( "SELECT d from DictionaryType d", DictionaryType.class ).getResultList();
	}
}
