package com.example.netflix.tarif;

import java.util.logging.Logger;

public class NetflixTarifRechnerService {

    private static final Logger logger = Logger.getLogger(NetflixTarifRechnerService.class.getName());

    private static final double PREIS_GESAMT = 100.00;

    public double calculatePreis(Kunde kunde) {
        logger.info("Berechne Preis für Kunde: " + kunde.getName() + " mit Alter: " + kunde.getAlter());

        double endPreis = PREIS_GESAMT - kunde.getRabatt();

        logger.info("Preis: " + endPreis);

        return endPreis;
    }

}
