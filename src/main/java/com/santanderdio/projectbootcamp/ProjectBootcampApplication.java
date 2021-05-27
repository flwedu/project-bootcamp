package com.santanderdio.projectbootcamp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class ProjectBootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectBootcampApplication.class, args);
	}
	
	// Swagger IO cria automaticamente uma documentação para a API.
	public OpenAPI customOpenAPI(
			@Value("${application.title_description}") String title_description,
			@Value("${application.version}") String version,
			@Value("${application.description}") String description
			) {
		return new OpenAPI()
				.info(new Info()
						.title(title_description)
						.version(version)
						.description(description)
						.termsOfService("http://swagger.io/terms")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
