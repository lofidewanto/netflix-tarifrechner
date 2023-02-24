package com.example.netflix.tarif;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class NetflixTarifrechnerSpringApplication {

	private static final Logger logger = LoggerFactory.getLogger(NetflixTarifrechnerSpringApplication.class);

	public static void main(String[] args) {
		logger.info("STARTING THE APPLICATION");

		SpringApplication.run(NetflixTarifrechnerSpringApplication.class, args);

		logger.info("STOP THE APPLICATION");
	}

	@Bean
	OpenAPI customOpenAPI(@Value("${netflix.api.version}") String appVersion) {
		return new OpenAPI().components(new Components()).info(new Info().title("Netflix Tarif API").version(appVersion)
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
