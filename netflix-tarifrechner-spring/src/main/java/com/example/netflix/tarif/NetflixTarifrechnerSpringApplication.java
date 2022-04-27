package com.example.netflix.tarif;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetflixTarifrechnerSpringApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(NetflixTarifrechnerSpringApplication.class);

	@Autowired
	private NetflixTarifRechnerService netflixTarifRechnerService;

	public static void main(String[] args) {
		logger.info("STARTING THE APPLICATION");

		SpringApplication.run(NetflixTarifrechnerSpringApplication.class, args);

		logger.info("STOP THE APPLICATION");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("EXECUTING : command line runner");

		// https://springhow.com/spring-boot-application-arguments
		// Beispiel
		// args[0] = "Max";
		// args[1] = "18";

		for (int i = 0; i < args.length; ++i) {
			logger.info("args[{}]: {}", i, args[i]);
		}

		if (args.length == 2) {
			double endPreis = this.netflixTarifRechnerService.calculatePreis(new Kunde(args[0], Integer.parseInt(args[1])));

			logger.info("Preis am Ende: {}", endPreis);
		} else {
			logger.info("Bitte geben Sie den Namen und das Alter des Kunden an.");
		}
	}

}
