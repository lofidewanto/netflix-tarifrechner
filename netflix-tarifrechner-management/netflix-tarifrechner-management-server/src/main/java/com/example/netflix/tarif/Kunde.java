package com.example.netflix.tarif;

public class Kunde {

    private String name;
    private int alter;

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
