package com.langton;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig{

	@Value("${application.version}")
	private String version;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.langton"))
				.paths(PathSelectors.any()).build();
	}

	/**
	 * will add some importants information to the swagger docs
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfo("Langton ant app", "rest api for langton ant app", version, null,
				new Contact("leclerc", "N/A", "leclerc.cyril@hotmail.fr"), null, null, Collections.EMPTY_LIST);
	}

}