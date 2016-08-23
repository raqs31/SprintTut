package com.mario.spring.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

/**
 * Created by raqsW on 2016-08-22.
 */
@Configuration
public class ThymeleafConfiguration {
	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}

	@Bean
	public SpringSecurityDialect springSecurityDialect() {
		return new SpringSecurityDialect();
	}

	/*@Bean
	public ITemplateResolver defaultTemplateResolver(ThymeleafProperties thProperties,
													 @Value("${spring.thymeleaf.templates_root:}") String templatesRoot) {
		TemplateResolver resolver = new FileTemplateResolver();
		resolver.setSuffix(thProperties.getSuffix());
		resolver.setPrefix("classpath:/templatesZ");
		resolver.setTemplateMode(thProperties.getMode());
		resolver.setCharacterEncoding(thProperties.getEncoding().name());
		resolver.setCacheable(thProperties.isCache());
		return resolver;
	}*/
}
