package com.example.netflix.tarif;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KundeServiceTest {

    @Autowired
    KundeService kundeService;

    @Autowired
    KundeRepository kundeRepository;
    
    @Test
    void create_Kunde() {
        Kunde createKunde = kundeService.createKunde(new Kunde("Max", 18));

        assertEquals("Max", createKunde.getName());

        long count = kundeRepository.count();

        assertEquals(1, count);
    }
}
