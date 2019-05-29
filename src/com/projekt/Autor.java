package com.projekt;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String imie;
    private String nazwisko;
    private List<Umowa> umowy;

    public Autor(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.umowy = new ArrayList<>();
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }
}
