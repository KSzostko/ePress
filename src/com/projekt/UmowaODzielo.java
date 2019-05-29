package com.projekt;

public class UmowaODzielo extends Umowa {
    private PozycjaLiteracka dzielo;

    public UmowaODzielo(int wynagrodzenie, PozycjaLiteracka dzielo) {
        super(wynagrodzenie);
        this.dzielo = dzielo;
    }

    public String getDzielo() {
        return dzielo.getTytul();
    }
}
