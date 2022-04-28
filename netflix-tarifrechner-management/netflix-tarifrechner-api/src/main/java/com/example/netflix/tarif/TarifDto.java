package com.example.netflix.tarif;

public class TarifDto {
    
    private final double endPreis;

    public TarifDto(double endPreis) {
        this.endPreis = endPreis;
    }

    public double getEndPreis() {
        return endPreis;
    }
}
