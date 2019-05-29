package com.projekt;

import java.util.ArrayList;
import java.util.List;

public class Drukarnia {
    private List<ZlecenieDruku> zlecenia;
    private String czegoNieDrukuje;

    public Drukarnia(String czegoNieDrukuje) {
        this.czegoNieDrukuje = czegoNieDrukuje;
        this.zlecenia = new ArrayList<>();
    }

    public List<ZlecenieDruku> getZlecenia() {
        return zlecenia;
    }

    public String getCzegoNieDrukuje() {
        return czegoNieDrukuje;
    }

    public void przejrzyjZlecenia() {
        int i = 1;
        for(ZlecenieDruku zlecenie : zlecenia) {
            System.out.println("Zlecenie nr " + i + ": " +
                    zlecenie.getAutor() + " autorstwa " + zlecenie.getAutor() +
                    " w ilosci " + zlecenie.getIloscEgzemplarzy());
        }
    }

    public boolean dodajZlecenie(ZlecenieDruku zlecenie) {
        PozycjaLiteracka pozycja = zlecenie.getZleconaPozycja();
        if(!zlecenia.contains(zlecenie) && ((Ksiazka) pozycja).getGatunekLiteracki() == czegoNieDrukuje ) {
            zlecenia.add(zlecenie);
            return true;
        }

        return false;
    }

    public boolean wykonajZlecenie(ZlecenieDruku zlecenie) {
        if(zlecenia.contains(zlecenie)) {
            zlecenia.remove(zlecenie);
            return true;
        }

        return false;
    }
}
