package com.example.netflix.tarif;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NetflixTarifRechnerService {

    private static final Logger logger = LoggerFactory.getLogger(NetflixTarifRechnerService.class);

    private static final double PREIS_GESAMT = 100.00;

    public double calculatePreis(Kunde kunde) {
        logger.info("Berechne Preis für Kunde: " + kunde.getName() + " mit Alter: " + kunde.getAlter());

        double endPreis = PREIS_GESAMT - kunde.getRabatt();

        logger.info("Preis: " + endPreis);

        return endPreis;
    }

}
