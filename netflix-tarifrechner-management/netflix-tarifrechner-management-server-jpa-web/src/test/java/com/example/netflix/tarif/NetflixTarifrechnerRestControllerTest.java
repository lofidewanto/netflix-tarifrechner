package com.example.netflix.tarif;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class NetflixTarifrechnerRestControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(NetflixTarifrechnerRestControllerTest.class);

	private static final String HOST_TO_TEST = "http://localhost:";

	private static final String URL_TO_TEST = "/netflix/";

	private static final String URI_TO_TEST = NetflixTarifRechnerEndpoint.TARIFRECHNER
			+ "/Lofi/18";

	@LocalServerPort
	int port;

	@Autowired
	WebClient.Builder webClientBuilder;

	@Test
	void webClientAufruf() {
		WebClient webClient = webClientBuilder.baseUrl(HOST_TO_TEST + port + URL_TO_TEST).build();
		String body = webClient.get().uri(URI_TO_TEST).retrieve().bodyToMono(String.class).block();

		logger.info(body);

		String expectation = "{\"endPreis\":80.0,\"kundeName\":\"Lofi\"}";

		assertEquals(expectation, body);
	}
}
