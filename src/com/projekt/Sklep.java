package com.projekt;

import java.util.ArrayList;
import java.util.List;

public class Sklep {
    protected String nazwa;
    protected List<Zlecenie> dostepnePozycje;

    public Sklep(String nazwa) {
        this.nazwa = nazwa;
        this.dostepnePozycje = new ArrayList<>();
    }

    public String getNazwa() {
        return nazwa;
    }

    public List<Zlecenie> getDostepnePozycje() {
        return dostepnePozycje;
    }
}
