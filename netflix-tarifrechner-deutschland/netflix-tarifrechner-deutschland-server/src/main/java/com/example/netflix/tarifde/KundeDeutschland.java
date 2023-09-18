package com.example.netflix.tarifde;

public class KundeDeutschland {

    private String name;
    private int alter;

    public KundeDeutschland(String name, int alter) {
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
