package com.example.netflix.tarif;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@SpringBootTest
class NetflixTarifrechnerRestControllerWebClientTest {

    private static final Logger logger = LoggerFactory.getLogger(NetflixTarifrechnerRestControllerWebClientTest.class);

    private static final String URL_TO_TEST = "http://localhost:8080/netflix/";

    private static final String URI_TO_TEST = NetflixTarifRechnerEndpoint.TARIFRECHNER
            + "/Lofi/18";

    @Disabled("Test is disabled, because it is not possible to test a WebClient without a server running")
    @Test
    void webClientAufruf() {
        // Achtung: Die Spring Boot App muss vorher gestartet werden, damit der
        // WebClient funktioniert!
        WebClient webClient = WebClient.create(URL_TO_TEST);
        Mono<String> result = webClient.get().uri(URI_TO_TEST).retrieve().bodyToMono(String.class);
        String body = result.block();

        logger.info(body);

        String expectation = "{\"endPreis\":80.0,\"kundeName\":\"Lofi\"}";

        assertEquals(expectation, body);
    }

}
