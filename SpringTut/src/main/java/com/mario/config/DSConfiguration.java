package com.mario.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 * Created by raqsW on 2016-08-23.
 */
@Configuration
@EnableAutoConfiguration( exclude = { DataSourceAutoConfiguration.class } )
@EnableTransactionManagement
@EnableJpaRepositories( basePackages = "com.mario.domain", entityManagerFactoryRef = "entityManager" )
public class DSConfiguration {

	@Bean( name = "mainDS" )
	@Primary
	@ConfigurationProperties( prefix = "datasource.mario" )
	public DataSource mainDataSource( /* DataSourceProperties properties */ ) {
		return DataSourceBuilder.create()
			/*
			 * .driverClassName(properties.getDriverClassName()) .password(properties.getPassword())
			 * .username(properties.getUsername()) .url(properties.getUrl())
			 */
			.build();
	}

	@SuppressWarnings( "SpringJavaAutowiringInspection" )
	@Bean( name = "entityManager" )
	@Primary
	@PersistenceContext( unitName = "mario" )
	public LocalContainerEntityManagerFactoryBean mainContainerEMFactory( DataSource ds,
																		  EntityManagerFactoryBuilder builder,
																		  JpaProperties jpaProperties ) {
		return builder.dataSource( ds ).persistenceUnit( "mario" ).properties( jpaProperties.getProperties() )
			.properties( jpaProperties.getHibernateProperties( ds ) ).packages( "com.mario.domain" ).build();
	}
}
