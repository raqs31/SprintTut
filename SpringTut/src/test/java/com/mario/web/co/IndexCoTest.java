package com.mario.web.co;

import com.mario.domain.model.arena.Actor;
import com.mario.domain.repository.ActorRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * Created by Damian Grzankowski on 2016-11-29.
 */
public class IndexCoTest {

	@Test
	public void testIndexPage()
		throws Exception {
		IndexCO index = new IndexCO();
		MockMvc mockMvc = standaloneSetup( index ).build();
		mockMvc.perform( get( "/" ) ).andExpect( view().name( "index" ) );
		assertEquals( index.index(), "index" );
	}

	@Test
	public void shouldShowAllActors()
		throws Exception {
		List<Actor> expectedActors = createActorsList( 20 );
		ActorRepository mockRepository = mock( ActorRepository.class );

		when( mockRepository.findAll() ).thenReturn( expectedActors );

		IndexCO controller = new IndexCO();
		// todo

	}

	private List<Actor> createActorsList( int count ) {
		List<Actor> actors = new ArrayList<>();
		for ( int i = 0; i < count; i++ ) {
			actors.add( new Actor() );
		}
		return actors;
	}

}
