package com.mario.domain.service.admin.impl;

import com.google.common.collect.Lists;
import com.mario.domain.model.dict.Dictionary;
import com.mario.domain.model.dict.DictionaryType;
import com.mario.domain.repository.DictionariesRepository;
import com.mario.domain.service.admin.DictionaryService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.DiscriminatorValue;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by raqsW on 2016-09-02.
 */
@Service
@Transactional
public class DictionaryServiceImpl
	implements DictionaryService {

	@Inject
	private DictionariesRepository dictRepository;

	@Override
	public List<DictionaryType> getDictionaryTypes() {
		return dictRepository.findAllDictionaryTypes();
	}

	@Override
	public Dictionary findDictionary( Integer dictId ) {
		return dictRepository.findOne( dictId );
	}

	@Override
	public <T extends Dictionary> T save( T dict ) {
		return dictRepository.save( dict );
	}

	@Override
	public List<Dictionary> findAllDictionaries() {
		return Lists.newArrayList( dictRepository.findAll() );
	}

	@Override
	public <T extends Dictionary> T findOrCreateDictionary( Class<T> dictionaryClass, String value ) {
		String dictType = dictionaryClass.getAnnotation( DiscriminatorValue.class ).value();

		T dictionary = (T) dictRepository.findOneByDictTypeAndValue( dictType, value );

		if ( dictionary == null )
			dictionary = createDictionary( dictionaryClass, value );

		return dictionary;
	}

	public <T extends Dictionary> T createDictionary( Class<T> clazz, String value ) {
		T newDict;
		try {
			newDict = clazz.getConstructor().newInstance();
		}
		catch ( Exception e ) {
			throw new RuntimeException( e.getMessage() );
		}

		newDict.setValue( value );
		return save( newDict );
	}
}
