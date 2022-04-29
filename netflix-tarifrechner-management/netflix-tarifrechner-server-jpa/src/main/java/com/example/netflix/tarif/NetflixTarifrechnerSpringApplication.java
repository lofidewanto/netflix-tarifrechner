package com.example.netflix.tarif;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetflixTarifrechnerSpringApplication {

	private static final Logger logger = LoggerFactory.getLogger(NetflixTarifrechnerSpringApplication.class);

	public static void main(String[] args) {
		logger.info("STARTING THE APPLICATION");

		SpringApplication.run(NetflixTarifrechnerSpringApplication.class, args);

		logger.info("STOP THE APPLICATION");
	}

}
