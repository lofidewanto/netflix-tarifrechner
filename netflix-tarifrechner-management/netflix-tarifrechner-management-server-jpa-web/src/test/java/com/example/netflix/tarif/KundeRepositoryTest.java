package com.example.netflix.tarif;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class KundeRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(KundeRepositoryTest.class);

    @Autowired
    KundeRepository kundeRepository;

    @Test
    void createTestKunde() {
        Kunde save = kundeRepository.save(new Kunde("Lofi", 20));

        kundeRepository.findAll().forEach(kunde -> logger.info(kunde.getName()));
    }
}
