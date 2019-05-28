package com.projekt;

public class Ksiazka extends PozycjaLiteracka {
    private String gatunekLiteracki;

    public Ksiazka(String tytul, double cena, String gatunekLiteracki) {
        super(tytul, cena);
        this.gatunekLiteracki = gatunekLiteracki;
    }

    public String getGatunekLiteracki() {
        return gatunekLiteracki;
    }
}
