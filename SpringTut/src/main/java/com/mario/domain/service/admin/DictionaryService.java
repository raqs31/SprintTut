package com.mario.domain.service.admin;

import com.mario.domain.model.dict.Dictionary;
import com.mario.domain.model.dict.DictionaryType;

import java.util.List;

/**
 * Created by raqsW on 2016-09-02.
 */
public interface DictionaryService {

	List<DictionaryType> getDictionaryTypes();

	Dictionary findDictionary( Integer dictId );

	<T extends Dictionary> T save( T dict );

	List<Dictionary> findAllDictionaries();

	<T extends Dictionary> T findOrCreateDictionary( Class<T> dictionaryClass, String value );
}
