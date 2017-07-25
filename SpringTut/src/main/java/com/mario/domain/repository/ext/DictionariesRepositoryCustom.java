package com.mario.domain.repository.ext;

import com.mario.domain.model.dict.DictionaryType;

import java.util.List;

/**
 * Created by raqsW on 2016-09-02.
 */
public interface DictionariesRepositoryCustom {

	List<DictionaryType> findAllDictionaryTypes();
}
