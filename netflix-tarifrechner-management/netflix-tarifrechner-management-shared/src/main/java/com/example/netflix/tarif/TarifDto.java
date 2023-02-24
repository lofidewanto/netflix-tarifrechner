package com.example.netflix.tarif;

public class TarifDto {

	private final double endPreis;

	private final String kundeName;

	public TarifDto() {
		endPreis = 0;
		kundeName = "";
	}

	public TarifDto(double endPreis, String kundeName) {
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
