package com.example.netflix.tarif;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KundeService {

    private final KundeRepository kundeRepository;

    public KundeService(KundeRepository kundeRepository) {
       this.kundeRepository = kundeRepository;
    }

    @Transactional
    public Kunde createKunde(Kunde kunde) {
        return kundeRepository.save(kunde);
    }
}
