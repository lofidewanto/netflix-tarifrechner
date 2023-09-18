package com.example.netflix.tarifde;

public class TarifDeutschlandDto {

    private final double endPreis;

    private final String kundeName;

    public TarifDeutschlandDto() {
        endPreis = 0;
        kundeName = "";
    }

    public TarifDeutschlandDto(double endPreis, String kundeName) {
        this.endPreis = endPreis;
        this.kundeName = kundeName;
    }

    public double getEndPreis() {
        return endPreis;
    }

    public String getKundeName() {
        return kundeName;
    }
}
