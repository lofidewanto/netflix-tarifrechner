package com.example.netflix.tarif;

import java.util.logging.Logger;

public class NetflixTarifrechnerApplication {

    private static final Logger logger = Logger.getLogger(NetflixTarifrechnerApplication.class.getName());

    public static void main(String[] args) {
        logger.info("START: APPLICATION");

        // Beispiel
		// args[0] = "Max";
		// args[1] = "18";

		for (int i = 0; i < args.length; ++i) {
			logger.info("args: " + args[i]);
		}

        // TODO:Implementiere die Berechnung des Rabatts

        logger.info("STOP: APPLICATION");
    }
}
