package com.projekt;

import java.util.ArrayList;
import java.util.List;

public class Drukarnia {
    private List<Zlecenie> zlecenia;
    private String czegoNieDrukuje;

    public Drukarnia(String czegoNieDrukuje) {
        this.czegoNieDrukuje = czegoNieDrukuje;
        this.zlecenia = new ArrayList<>();
    }

    public List<Zlecenie> getZlecenia() {
        return zlecenia;
    }

    public String getCzegoNieDrukuje() {
        return czegoNieDrukuje;
    }

    public void przejrzyjZlecenia() {
        int i = 1;
        for(Zlecenie zlecenie : zlecenia) {
            System.out.println("Zlecenie nr " + i + ": " +
                    zlecenie.getZleconaPozycja().getTytul() + " autorstwa " + zlecenie.getAutor() +
                    " w ilosci " + zlecenie.getIloscEgzemplarzy());
        }
    }

    public boolean dodajZlecenie(Zlecenie zlecenie) {
        PozycjaLiteracka pozycja = zlecenie.getZleconaPozycja();
        if(((Ksiazka) pozycja).getGatunekLiteracki() == czegoNieDrukuje ) {
            return false;
        } else {
            if(zlecenia.contains(zlecenie)) {
                int i = zlecenia.indexOf(zlecenie);
                Zlecenie noweZlecenie = zlecenia.get(i);
                noweZlecenie.iloscEgzemplarzy += zlecenie.getIloscEgzemplarzy();
                zlecenia.set(i, noweZlecenie);

                return true;
            } else {
                zlecenia.add(zlecenie);
                return true;
            }
        }
    }

    public boolean wykonajZlecenie(Zlecenie zlecenie) {
        if(zlecenia.contains(zlecenie)) {
            zlecenia.remove(zlecenie);
            return true;
        }

        return false;
    }
}
