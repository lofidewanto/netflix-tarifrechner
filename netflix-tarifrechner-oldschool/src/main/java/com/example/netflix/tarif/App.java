package com.example.netflix.tarif;

import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        logger.info("START: APPLICATION");

        Kunde kunde = new Kunde(args[0], Integer.parseInt(args[1]));
        NetflixTarifRechnerService netflixTarifRechnerService = new NetflixTarifRechnerService();
        double calculatePreis = netflixTarifRechnerService.calculatePreis(kunde);

        logger.info("STOP: APPLICATION");
    }
}
