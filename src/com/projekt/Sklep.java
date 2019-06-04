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

    public void przejrzyjOferty() {
        int i = 1;
        for(Zlecenie zlecenie : dostepnePozycje) {
            System.out.println("Pozycja nr " + i + ": " + zlecenie.getZleconaPozycja().getTytul()
                    + " autorstwa " + zlecenie.getAutor());
        }
    }

    public void dodajDoSklepu(Zlecenie zlecenie) {
        if(dostepnePozycje.contains(zlecenie)) {
            int i = dostepnePozycje.indexOf(zlecenie);
            Zlecenie noweZlecenie = dostepnePozycje.get(i);
            noweZlecenie.iloscEgzemplarzy += zlecenie.getIloscEgzemplarzy();
        } else {
                dostepnePozycje.add(zlecenie);
        }
    }

    public boolean sprzedaj(Zlecenie zlecenie) {
        // to samo do zrobienia co w metodzie dodajZlecenie w Drukarni
        if(dostepnePozycje.contains(zlecenie)) {
            return true;
        }

        return false;
    }
}
