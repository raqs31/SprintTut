package com.mario.web.co.admin;

import com.mario.domain.service.admin.migration.DataExtractor;
import com.mario.domain.service.admin.migration.DataMigrationService;
import com.mario.domain.service.admin.migration.MigrationTracks;
import com.mario.domain.service.admin.migration.Migrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by nowe konto on 2016-12-01.
 */
@Controller
@RequestMapping( value = "/admin" )
public class AdministratorPanelCO {

	@Autowired
	private DataExtractor<MigrationTracks> extractor;

	@Autowired
	@Migrator( MigrationTracks.class )
	private DataMigrationService<MigrationTracks> migrator;

	@GetMapping( value = "/console" )
	public String adminConsole() {
		return "/admin/administratorPanel";
	}

	@GetMapping( value = "/migrate" )
	public String migrateTracksFromCache() {
		migrator.migrateData( extractor );
		return "/admin/administratorPanel";
	}

	@GetMapping( value = "/administratorPanel" )
	public String admPanel() {
		return "/admin/administratorPanel";
	}

	@PostMapping( "/tracksFromFile" )
	public String storeTracksFromFile( @RequestParam( "uploadTrackFile" ) MultipartFile file ) {

		return "/admin/console";
	}
}
