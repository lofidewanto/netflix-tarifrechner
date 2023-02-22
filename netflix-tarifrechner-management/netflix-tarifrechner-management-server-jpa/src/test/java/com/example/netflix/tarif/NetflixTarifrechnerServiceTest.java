package com.example.netflix.tarif;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NetflixTarifrechnerServiceTest {
    
    @Test
    void calculatePreis_Max_18JahreAlt() {
        Kunde kunde = new Kunde("Max", 18);

        NetflixTarifRechnerService netflixTarifRechnerService = new NetflixTarifRechnerService();
        double calculatePreis = netflixTarifRechnerService.calculatePreis(kunde);

        assertEquals(80.0, calculatePreis);
    }

    @Test
    void calculatePreis_Manuel_80JahreAlt() {
        Kunde kunde = new Kunde("Manuel", 80);

        NetflixTarifRechnerService netflixTarifRechnerService = new NetflixTarifRechnerService();
        double calculatePreis = netflixTarifRechnerService.calculatePreis(kunde);

        assertEquals(70.0, calculatePreis);
    }
}
