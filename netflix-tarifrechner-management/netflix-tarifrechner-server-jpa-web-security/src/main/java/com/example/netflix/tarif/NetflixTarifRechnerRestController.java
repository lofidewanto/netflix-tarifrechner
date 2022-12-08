package com.example.netflix.tarif;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NetflixTarifRechnerRestController {

    private Logger logger = LoggerFactory.getLogger(NetflixTarifRechnerRestController.class);

    private final NetflixTarifRechnerService netflixTarifRechnerService;

    private final KundeService kundeService;

    public NetflixTarifRechnerRestController(NetflixTarifRechnerService netflixTarifRechnerService, KundeService kundeService) {
        this.netflixTarifRechnerService = netflixTarifRechnerService;
        this.kundeService = kundeService;
    }

    @GetMapping(NetflixTarifRechnerEndpoint.TARIFRECHNER + "/{name}/{alter}")
    public TarifDto getTarif(@PathVariable String name, @PathVariable int alter) {
        // Erzeuge Kunde
        Kunde createdKunde = kundeService.createKunde(new Kunde(name, alter));

        double endPreis = netflixTarifRechnerService.calculatePreis(createdKunde);
        
        logger.info("Preis am Ende: {}", endPreis);
        logger.info("Kunde: {}", createdKunde);

        TarifDto tarifDto = new TarifDto(endPreis, createdKunde.getName());

        return tarifDto;
    }
}
