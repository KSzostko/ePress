package com.projekt;

public abstract class PozycjaLiteracka {
    private String tytul;
    private double cena;

    public PozycjaLiteracka(String tytul, double cena) {
        this.tytul = tytul;
        this.cena = cena;
    }

    public String getTytul() {
        return tytul;
    }

    public double getCena() {
        return cena;
    }
}
