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

    private int znajdzZlecenie(Zlecenie zlecenie) {
        for(int i = 0; i < zlecenia.size(); i++) {
            if(zlecenia.get(i).equals(zlecenie)) {
                return i;
            }
        }

        return -1;
    }

    // trzeba dodac funkcje co sprawdza funkcje z roznymi ilosciami egzemplarzy

    public boolean dodajZlecenie(Zlecenie zlecenie) {
        PozycjaLiteracka pozycja = zlecenie.getZleconaPozycja();
        if(((Ksiazka) pozycja).getGatunekLiteracki().equals(czegoNieDrukuje)) {
            return false;
        } else {
            int i = znajdzZlecenie(zlecenie);
            if(i >= 0) {
                zlecenia.get(i).iloscEgzemplarzy += zlecenie.getIloscEgzemplarzy();
                return true;
            } else {
                zlecenia.add(zlecenie);
                return true;
            }
        }
    }

    public boolean wykonajZlecenie(Zlecenie zlecenie) {
        if(znajdzZlecenie(zlecenie) >= 0) {
            zlecenia.remove(zlecenie);
            return true;
        }

        return false;
    }
}
