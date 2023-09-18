package com.example.netflix.tarifde;

import com.example.netflix.tarif.NetflixTarifRechnerEndpoint;
import com.example.netflix.tarif.TarifDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NetflixTarifRechnerDeutschlandService {

    private static final Logger logger = LoggerFactory.getLogger(NetflixTarifRechnerDeutschlandService.class);

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Value("${netflixtarifrechner.endpoint}")
    private String netflixTarifRechnerEndpoint;

    public double calculatePreis(KundeDeutschland kunde) {
        logger.info("Berechne Preis für Kunde: " + kunde.getName() + " mit Alter: " + kunde.getAlter());

        // Call NetflixTarifrechner REST API

        // REST Template
        // TarifDto tarifDto = getTarifDtoWithRestTemplate(kunde);

        // WebClient
        TarifDto tarifDto = getTarifDtoWithWebClient(kunde);
        logger.info("Preis: " + tarifDto.getEndPreis());

        // 10% mehr
        double endPreisCalc = (0.1 * tarifDto.getEndPreis()) + tarifDto.getEndPreis();
        logger.info("Preis mit 10%: " + endPreisCalc);

        return endPreisCalc;
    }

    private TarifDto getTarifDtoWithWebClient(KundeDeutschland kunde) {
        WebClient webClient = webClientBuilder.baseUrl(netflixTarifRechnerEndpoint).build();
        TarifDto tarifDto = webClient.get().uri(NetflixTarifRechnerEndpoint.TARIFRECHNER + "/"
                + kunde.getName() + "/"
                + kunde.getAlter()).retrieve().bodyToMono(TarifDto.class).block();
        return tarifDto;
    }

    private TarifDto getTarifDtoWithRestTemplate(KundeDeutschland kunde) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = netflixTarifRechnerEndpoint;
        TarifDto tarifDto = restTemplate.getForObject(
                fooResourceUrl + NetflixTarifRechnerEndpoint.TARIFRECHNER + "/"
                        + kunde.getName() + "/"
                        + kunde.getAlter(), TarifDto.class);
        return tarifDto;
    }

}
