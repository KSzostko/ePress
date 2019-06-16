package com.projekt;

import java.util.ArrayList;
import java.util.List;

public class Drukarnia {
    private String nazwaFirmy;
    private List<Zlecenie> zlecenia;
    private String czegoNieDrukuje;

    public Drukarnia(String nazwaFirmy, String czegoNieDrukuje) {
        this.nazwaFirmy = nazwaFirmy;
        this.czegoNieDrukuje = czegoNieDrukuje;
        this.zlecenia = new ArrayList<>();
    }

    public String getNazwaFirmy() {
        return nazwaFirmy;
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

    // sprawdza czy wystepuje zlecenie na tą samą pozycję, ale z inną ilością egzemplarzy
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

    public boolean wydrukuj(Zlecenie zlecenie) {
        // najpierw sprawdzamy czy drukarnia umożliwia wydrukowanie tego rodzaju pozycji
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
        int numerUmowyAutora = zlecenie.numerUmowyAutora();
        Umowa umowa = zlecenie.getAutor().getUmowy().get(numerUmowyAutora);

        if(i >= 0) {
            zlecenia.get(i).iloscEgzemplarzy += zlecenie.getIloscEgzemplarzy();
        } else if(j >= 0) {
            zlecenia.get(j).iloscEgzemplarzy += zlecenie.getIloscEgzemplarzy();
        } else {
            zlecenia.add(zlecenie);
        }

        if(umowa instanceof UmowaODzielo) {
            zlecenie.autor.zakonczUmowe((UmowaODzielo) umowa);
        } else {
            zlecenie.autor.skrocOkresPracy((UmowaOPrace) umowa);

            // teraz sprawdzamy, czy w zaktualizowanej umowie o prace zostaly jescze jakies dni pracy
            umowa = zlecenie.getAutor().getUmowy().get(numerUmowyAutora);
            if(((UmowaOPrace) umowa).getOkresPracy() == 0) {
                zlecenie.autor.zakonczUmowe((UmowaOPrace) umowa);
            }
        }

        return true;
    }

    public boolean wyslijDoSklepu(Zlecenie zlecenie) {
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
