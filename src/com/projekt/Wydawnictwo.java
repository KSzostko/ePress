package com.projekt;

import java.util.ArrayList;
import java.util.List;

public class Wydawnictwo {
    private String nazwaWydawnictwa;
    private List<Autor> dostepniAutorzy;
    private List<Drukarnia> drukarnie;
    private Sklep sklep;

    public Wydawnictwo(String nazwaWydawnictwa, Sklep sklep) {
        this.nazwaWydawnictwa = nazwaWydawnictwa;
        this.dostepniAutorzy = new ArrayList<>();
        this.drukarnie = new ArrayList<>();
        this.sklep = sklep;
    }

    public String getNazwaWydawnictwa() {
        return nazwaWydawnictwa;
    }

    public List<Autor> getDostepniAutorzy() {
        return dostepniAutorzy;
    }

    public List<Drukarnia> getDrukarnie() {
        return drukarnie;
    }

    public Sklep getSklep() {
        return sklep;
    }
}
