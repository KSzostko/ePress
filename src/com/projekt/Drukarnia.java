package com.projekt;

import java.util.ArrayList;
import java.util.List;

public class Drukarnia {
    private String nazwaFirmy;
    private List<Zlecenie> zlecenia;
    private List<Autor> dostepniAutorzy;
    private String czegoNieDrukuje;

    public Drukarnia(String nazwaFirmy, String czegoNieDrukuje) {
        this.nazwaFirmy = nazwaFirmy;
        this.czegoNieDrukuje = czegoNieDrukuje;
        this.zlecenia = new ArrayList<>();
        this.dostepniAutorzy = new ArrayList<>();
    }

    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public List<Zlecenie> getZlecenia() {
        return zlecenia;
    }

    public List<Autor> getDostepniAutorzy() {
        return dostepniAutorzy;
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

    public void przejrzyjAutorow() {
        int i = 1;
        for(Autor autor : dostepniAutorzy) {
            System.out.println("Autor " + i + ": " + autor.getImie() + " " + autor.getNazwisko() +
                    " " + autor.getUmowy());
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

    private int znajdzAutora(Autor autor) {
        for(int i = 0; i < dostepniAutorzy.size(); i++) {
            if(dostepniAutorzy.get(i).equals(autor)) {
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

    public boolean dodajAutora(Autor autor) {
        if(znajdzAutora(autor) == -1) {
            dostepniAutorzy.add(autor);
            return true;
        }

        return false;
    }

    public boolean usunAutora(Autor autor) {
        if(znajdzAutora(autor) >= 0) {
            dostepniAutorzy.remove(autor);
            return true;
        }

        return false;
    }

    // w sumie mozna pomyslec tez nad od razu rozwiazaniem umowy z autorem o dzielo tutaj
    // i skrócenie okresu pracy autora
    public boolean dodajZlecenie(Zlecenie zlecenie) {
        PozycjaLiteracka pozycja = zlecenie.getZleconaPozycja();
        if(((Ksiazka) pozycja).getGatunekLiteracki().equals(czegoNieDrukuje)) {
            return false;
        }
        // jesli nie ma zlecenia na daną pozycję, to dodajemy nowe
        // jeśli już jest zlecenie na pozycję, to zwiększamy ilość egzemplarzy
        int i = znajdzZlecenie(zlecenie);
        int j = roznicaIlosci(zlecenie);

        // sprawdzamy najpierw czy autor ma umowe o dzielo na ten konkrenty tytuł
        // jesli nie to traktujemy to jako czesc umowy o prace
        String tytul = zlecenie.getZleconaPozycja().getTytul();
        int autor = znajdzAutora(zlecenie.getAutor());
        int czyUmowaODzielo = zlecenie.getAutor().znajdzUmoweODzielo(tytul);
        int czyUmowaOPrace = zlecenie.getAutor().znajdzUmoweOPrace();

        if(i >= 0) {
            zlecenia.get(i).iloscEgzemplarzy += zlecenie.getIloscEgzemplarzy();

            if(czyUmowaODzielo >= 0) {

            }
        } else if(j >= 0) {
            zlecenia.get(j).iloscEgzemplarzy += zlecenie.getIloscEgzemplarzy();
        } else {
            zlecenia.add(zlecenie);
        }

        return true;
    }

    public boolean wykonajZlecenie(Zlecenie zlecenie) {
        int i = znajdzZlecenie(zlecenie);
        int j = znajdzZlecenie(zlecenie);

        if(i >= 0) {
            zlecenia.remove(zlecenie);
            return true;
        } else if(j >= 0 && zlecenia.get(j).getIloscEgzemplarzy() >= zlecenie.getIloscEgzemplarzy()) {
            zlecenia.get(j).iloscEgzemplarzy -= zlecenie.getIloscEgzemplarzy();
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object drukarnia) {
        if(((Drukarnia) drukarnia).getNazwaFirmy().equals(this.getNazwaFirmy()) &&
                ((Drukarnia) drukarnia).getCzegoNieDrukuje().equals(this.getCzegoNieDrukuje())) {
            return true;
        }

        return false;
    }
}
