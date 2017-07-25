package com.mario.domain.repository;

import com.mario.domain.model.dict.Dictionary;
import com.mario.domain.repository.ext.DictionariesRepositoryCustom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by raqsW on 2016-09-02.
 */
@Repository
public interface DictionariesRepository
	extends CrudRepository<Dictionary, Integer>, DictionariesRepositoryCustom {

	Dictionary findOneByDictTypeAndValue( String dictType, String value );
}
