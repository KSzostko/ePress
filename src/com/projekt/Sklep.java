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

    private int szukajProduktu(Zlecenie zlecenie) {
        for(int i = 0; i < dostepnePozycje.size(); i++) {
            if(dostepnePozycje.get(i).equals(zlecenie)) {
                return i;
            }
        }

        return -1;
    }

    private int roznicaIlosci(Zlecenie zlecenie) {
        for(int i = 0; i < dostepnePozycje.size(); i++) {
            if(dostepnePozycje.get(i).getZleconaPozycja() == zlecenie.getZleconaPozycja() &&
            dostepnePozycje.get(i).getAutor() == zlecenie.getAutor() &&
             dostepnePozycje.get(i).getIloscEgzemplarzy() != zlecenie.getIloscEgzemplarzy()) {
                return i;
            }
        }

        return -1;
    }

    public void dodajDoSklepu(Zlecenie zlecenie) {
        int i = szukajProduktu(zlecenie);
        int j = roznicaIlosci(zlecenie);
        if(i >= 0) {
            dostepnePozycje.get(i).iloscEgzemplarzy += zlecenie.getIloscEgzemplarzy();
        } else if(j >= 0) {
            dostepnePozycje.get(j).iloscEgzemplarzy += zlecenie.getIloscEgzemplarzy();
        } else {
            dostepnePozycje.add(zlecenie);
        }
    }

//    public boolean sprzedaj(Zlecenie zlecenie) {
//    }
}
