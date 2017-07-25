package com.mario.web.co.profile;

import com.mario.domain.model.arena.Actor;
import com.mario.domain.model.arena.ActorTrack;
import com.mario.domain.service.arena.ActorService;
import com.mario.domain.service.arena.ActorTrackService;
import com.mario.domain.service.auth.UserService;
import com.mario.web.co.arena.dto.ActorDTO;
import com.mario.web.co.profile.dto.FilmographyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by raqsW on 2016-08-19.
 */
@Controller
@RequestMapping( "/profile" )
public class EditProfileCO {

	@Autowired
	ActorTrackService actorTrackService;

	@Autowired
	ActorService actorService;

	@Autowired
	UserService userService;

	@RequestMapping( value = "/edit", method = RequestMethod.GET )
	public String userEditableData( Model model ) {
		User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		com.mario.domain.model.auth.User user = userService.findUserByUsername( userName );
		Actor actor = actorService.getActorByUser( user );
		ActorDTO actorDTO;
		if ( actor != null ) {
			actorDTO = new ActorDTO( actor );
		}
		else {
			actorDTO = new ActorDTO();
			actorDTO.setFullName( "Jan Kowalski" );
			actorDTO.setDateOfBirth( "23/11/1992" );
			actorDTO.setEyesColor( "Blue" );
			actorDTO.setHairsColor( "Black" );
			actorDTO.setHeight( 200 );
			actorDTO.setWeight( 100.5 );
		}

		List<FilmographyDTO> filmographyDTOSet = new ArrayList<>();
		Iterable<ActorTrack> trackList = actorTrackService.findActorTrackByActorID( actor );

		for ( ActorTrack actorTrack : trackList ) {
			FilmographyDTO filmographyDTO = new FilmographyDTO();
			filmographyDTO.setYear( actorTrack.getTrack().getYear() );
			filmographyDTO.setRole( actorTrack.getRole().getDescription() );
			filmographyDTO.setDirector( actorTrack.getTrack().getDirector().getDescription() );
			filmographyDTO.setTitle( actorTrack.getTrack().getTitle() );
			filmographyDTO.setSubTitle( actorTrack.getTrack().getSubTitle() );
			filmographyDTO.setEpisodeNumber( actorTrack.getTrack().getSerialNo() );
			filmographyDTO.setTypOfMovie( actorTrack.getTrack().getTrackType().getDescription() );
			filmographyDTOSet.add( filmographyDTO );
		}

		FilmographyDTO dto = new FilmographyDTO();
		// Reczne generowanie dnaych w tabeli do wyrzucenia gdy bedzie działało juz wyszukiwanie
		for ( int i = 0; i < 6; i++ ) {
			FilmographyDTO filmography = new FilmographyDTO();
			filmography.setYear( 2013 );
			filmography.setTypOfMovie( "serial" + i );
			filmography.setTitle( "Rodzinka.pl" + i );
			filmography.setSubTitle( "odc 87" );
			filmography.setEpisodeNumber( 87 );
			filmography.setRole( "1 planowa" );
			filmography.setDirector( "Mitja Okorn" );
			filmographyDTOSet.add( filmography );
		}
		model.addAttribute( "actorData", actorDTO );
		model.addAttribute( "filmographyDto", dto );
		model.addAttribute( "filmographyDTOSet", filmographyDTOSet );

		return "/profile/profil-edit";
	}

	@RequestMapping( value = "/edit", method = RequestMethod.POST )
	public String filmographyAdder( @Valid @ModelAttribute( "filmographyDto" ) FilmographyDTO filmography,
									BindingResult bindingResult ) {
		if ( bindingResult.hasErrors() ) {
			return "/profile/profil-edit";
		}
		ActorTrack actorTrack = new ActorTrack();

		// actorTrackService.create(actorTrack);

		return "redirect:/profile/edit";

	}

}
