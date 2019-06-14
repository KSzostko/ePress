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

    // czyli czy wystepuje zlecenie na tą samą pozycję, ale z inną ilością egzemplarzy
    private int roznicaIlosci(Zlecenie zlecenie) {
        for(int i = 0; i < zlecenia.size(); i++) {
            if(zlecenia.get(i).getZleconaPozycja() == zlecenie.getZleconaPozycja() &&
                    zlecenia.get(i).getAutor() == zlecenie.getAutor() &&
                    zlecenia.get(i).getIloscEgzemplarzy() != zlecenie.getIloscEgzemplarzy()) {
                return i;
            }
        }

        return -1;
    }

    public boolean dodajZlecenie(Zlecenie zlecenie) {
        PozycjaLiteracka pozycja = zlecenie.getZleconaPozycja();
        if(((Ksiazka) pozycja).getGatunekLiteracki().equals(czegoNieDrukuje)) {
            return false;
        }
        int i = znajdzZlecenie(zlecenie);
        int j = roznicaIlosci(zlecenie);

        if(i >= 0) {
            zlecenia.get(i).iloscEgzemplarzy += zlecenie.getIloscEgzemplarzy();
        } else if(j >= 0) {
            zlecenia.get(j).iloscEgzemplarzy += zlecenie.getIloscEgzemplarzy();
        } else {
            zlecenia.add(zlecenie);
        }

        return true;
    }

    public boolean wykonajZlecenie(Zlecenie zlecenie) {
        if(znajdzZlecenie(zlecenie) >= 0) {
            zlecenia.remove(zlecenie);
            return true;
        }

        return false;
    }
}
