package com.cognixia.jumplus.project4.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/** Handles the creation of API documentation using Swagger.
 * <p>
 * To access this documentation, <br>
 * HTTP GET Request: <a href="http://localhost:8080/v2/api-docs">http://localhost:8080/v2/api-docs</a><br>
 * Web Browser: <a href="http://localhost:8080/swagger-ui.html">http://localhost:8080/swagger-ui.html</a><br>
 * <p>
 * @author	Alexandré Northouse
 * @version	1.0
 * @since	2020-06-22
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/** Creation of API docket to send out */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiDetails());
	}
	
	/** Actual information on the API */
	@Bean
	ApiInfo apiDetails() {
		return new ApiInfo(
				
		/*title*/		"DollarsBank API",
		/*description*/	"RESTful backend for a mock banking application",
		/*version*/		"1.0",
		
		/*TOS URL*/		"https://github.com/adversary-org/wtfnmf",
		
		/*Contact Obj*/	new Contact("Alexandre Northouse",
							"https://www.linkedin.com/in/alex-northouse/",
							"alex.j.northouse@gmail.com"),
		
		/*license*/		"Apache-2.0",
		/*license URL*/	"https://www.apache.org/licenses/LICENSE-2.0.txt",
		
		/*EOL*/			Collections.emptyList());
	}
}
