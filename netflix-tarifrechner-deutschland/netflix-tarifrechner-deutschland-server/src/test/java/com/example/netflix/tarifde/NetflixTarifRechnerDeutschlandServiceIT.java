package com.example.netflix.tarifde;

import com.example.netflix.tarif.TarifDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class NetflixTarifRechnerDeutschlandServiceIT {

    static MockWebServer mockBackEnd;

    @Autowired
    NetflixTarifRechnerDeutschlandService netflixTarifRechnerDeutschlandService;

    @BeforeAll
    static void setUp() throws IOException {
        mockBackEnd = new MockWebServer();
        mockBackEnd.start();
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }

    @BeforeEach
    void initialize() {
        String baseUrl = String.format("http://localhost:%s", mockBackEnd.getPort());
    }

    @Test
    void calculatePreis() {
        double calculatePreis = netflixTarifRechnerDeutschlandService.calculatePreis(
                new KundeDeutschland("Lofi", 30));

        assertEquals(88, calculatePreis);
    }

    @Test
    void test_mapper_create_json() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TarifDto tarifDto = new TarifDto(80, "lofi");
        objectMapper.writeValue(new File("target/tarif.json"), tarifDto);
    }

    @Test
    void test_2() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TarifDto tarif = objectMapper.readValue(
                new URL("file:target/tarif.json"), TarifDto.class);

        System.out.println(tarif.getKundeName());
    }
}