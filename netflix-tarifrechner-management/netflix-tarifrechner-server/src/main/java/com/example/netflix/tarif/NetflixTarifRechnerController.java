package com.example.netflix.tarif;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NetflixTarifRechnerController {

    private Logger logger = LoggerFactory.getLogger(NetflixTarifRechnerController.class);

    private final NetflixTarifRechnerService netflixTarifRechnerService;

    public NetflixTarifRechnerController(NetflixTarifRechnerService netflixTarifRechnerService) {
        this.netflixTarifRechnerService = netflixTarifRechnerService;
    }

    @GetMapping(NetflixTarifRechnerEndpoint.TARIFRECHNER + "/{name}/{alter}")
    public String getTarif(@PathVariable String name, @PathVariable int alter) {
        double endPreis = netflixTarifRechnerService.calculatePreis(new Kunde(name, alter));
        
        logger.info("Preis am Ende: {}", endPreis);

        return "Preis am Ende " + endPreis;
    }
}
