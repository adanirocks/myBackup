/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */

package il.co.luemi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * The Class SwaggerConfiguration.
 *
 * @author TCS
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	/**
	 * Api.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.paths(PathSelectors.regex("/application/.*")).build().pathMapping("/").apiInfo(apiInfo())
				.useDefaultResponseMessages(false);
	}

	/**
	 * Api info.
	 *
	 * @return the api info
	 */
	@Bean
	public ApiInfo apiInfo() {
		final ApiInfoBuilder builder = new ApiInfoBuilder();
		builder.title("APPLICATION DATA MGMT API through Swagger UI").version("1.0").license("(C) Copyright Test")
				.description("List of all the APIs of APPLICATION DATA MGMT App through Swagger UI");
		return builder.build();
	}

}
