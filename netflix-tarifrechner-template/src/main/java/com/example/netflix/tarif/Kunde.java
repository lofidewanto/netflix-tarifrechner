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
        // TODO: Rabatt ist vom Alter abhängig
        // < 18 --  0
        // < 65 --  10
        // > 65 --  20

        return 0;
    }
}
