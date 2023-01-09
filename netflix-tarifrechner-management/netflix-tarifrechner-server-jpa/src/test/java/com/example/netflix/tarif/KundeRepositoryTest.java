package com.example.netflix.tarif;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
public class KundeRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(KundeRepositoryTest.class);

    @Autowired
    KundeRepository kundeRepository;

    @Test
    @Transactional
    @Rollback
    void create_TestKunde() {
        Kunde save = kundeRepository.save(new Kunde("Lofi", 20));

        kundeRepository.findAll().forEach(kunde -> logger.info(kunde.getName()));
    }
}
