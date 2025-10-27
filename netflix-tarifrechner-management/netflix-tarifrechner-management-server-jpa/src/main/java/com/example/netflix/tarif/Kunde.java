package com.example.netflix.tarif;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Kunde {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int alter;

    public Kunde() {
    }

    public Kunde(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

    public String getName() {
        return name;
    }

    public int getAlter() {
        return alter;
    }

    public int getRabatt() {
        if (alter < 18) {
            return 10;
        } else if (alter < 65) {
            return 20;
        } else {
            return 30;
        }
    }
}
