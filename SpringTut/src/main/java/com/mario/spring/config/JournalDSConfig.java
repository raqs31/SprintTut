package com.mario.spring.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by raqsW on 2016-08-23.
 */
@Configuration
public class JournalDSConfig {
	@Bean
	@ConfigurationProperties(prefix = "datasource.journal")
	public DataSource dataSource(/*DataSourceProperties properties*/) {
		return DataSourceBuilder
				.create()
				/*.driverClassName(properties.getDriverClassName())
				.password(properties.getPassword())
				.username(properties.getUsername())
				.url(properties.getUrl())*/
				.build();
	}
}
