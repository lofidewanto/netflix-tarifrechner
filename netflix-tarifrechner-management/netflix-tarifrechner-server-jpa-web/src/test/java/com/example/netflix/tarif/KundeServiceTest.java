package com.example.netflix.tarif;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
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
    @Disabled
    void create_Kunde() {
        Kunde createKunde1 = kundeService.createKunde(new Kunde("Max", 18));
        Kunde createKunde2 = kundeService.createKunde(new Kunde("Muster", 30));

        assertEquals("Max", createKunde1.getName());
        assertEquals("Muster", createKunde2.getName());

        long count = kundeRepository.count();

        assertEquals(2, count);
    }
}
