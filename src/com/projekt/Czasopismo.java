package com.projekt;

public class Czasopismo extends PozycjaLiteracka {
    private String okresWydania;

    public Czasopismo(String tytul, double cena, String okresWydania) {
        super(tytul, cena);
        this.okresWydania = okresWydania;
    }

    public String getOkresWydania() {
        return okresWydania;
    }
}
