package com.example.netflix.tarifde;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NetflixTarifRechnerDeutschlandController {

    private Logger logger = LoggerFactory.getLogger(NetflixTarifRechnerDeutschlandController.class);

    private final NetflixTarifRechnerDeutschlandService netflixTarifRechnerDeutschlandService;

    public NetflixTarifRechnerDeutschlandController(NetflixTarifRechnerDeutschlandService netflixTarifRechnerDeutschlandService) {
        this.netflixTarifRechnerDeutschlandService = netflixTarifRechnerDeutschlandService;
    }

    @GetMapping(NetflixTarifRechnerDeutschlandEndpoint.TARIFRECHNER + "/{name}/{alter}")
    public TarifDeutschlandDto getTarif(@PathVariable String name, @PathVariable int alter) {
        double endPreis = netflixTarifRechnerDeutschlandService.calculatePreis(new KundeDeutschland(name, alter));
        
        logger.info("Preis am Ende: {}", endPreis);

        TarifDeutschlandDto tarifDto = new TarifDeutschlandDto(endPreis, name);

        return tarifDto;
    }
}
