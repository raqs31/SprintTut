package com.mario.web.co.admin.dict;

import com.mario.domain.model.dict.Dictionary;
import com.mario.domain.service.admin.DictionaryService;
import org.junit.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Created by nowe konto on 2016-12-01.
 */
public class DictionaryControllerTest {

	@Test
	public void shouldProcessDictionaryRegistraction()
		throws Exception {

		DictionaryService mockDictionaryService = mock( DictionaryService.class );
		Dictionary dictionaryUnsaved = new Dictionary();
		dictionaryUnsaved.setDictType( "Type" );
		dictionaryUnsaved.setDescription( "Description" );
		dictionaryUnsaved.setValue( "value" );
		dictionaryUnsaved.setAttr1( "atr1" );
		dictionaryUnsaved.setAttr2( "attr2" );
		dictionaryUnsaved.setNumAttr1( new BigDecimal( 5 ) );
		dictionaryUnsaved.setNumAttr2( new BigDecimal( 6 ) );
		dictionaryUnsaved.setOrder( 1 );
		Dictionary dictionarySaved = new Dictionary();

		dictionarySaved.setId( 1 );
		dictionarySaved.setDictType( "Type" );
		dictionarySaved.setDescription( "Description" );
		dictionarySaved.setValue( "value" );
		dictionarySaved.setAttr1( "atr1" );
		dictionarySaved.setAttr2( "attr2" );
		dictionarySaved.setNumAttr1( new BigDecimal( 5 ) );
		dictionarySaved.setNumAttr2( new BigDecimal( 6 ) );
		dictionarySaved.setOrder( 1 );

		when( mockDictionaryService.save( dictionaryUnsaved ) ).thenReturn( dictionarySaved );

	}

}
