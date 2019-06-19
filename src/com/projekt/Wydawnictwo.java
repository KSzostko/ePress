package com.projekt;

import java.util.ArrayList;
import java.util.List;

public class Wydawnictwo {
    private String nazwaWydawnictwa;
    private List<Autor> dostepniAutorzy;
    private List<Drukarnia> drukarnie;
    private Sklep sklep;

    public Wydawnictwo(String nazwaWydawnictwa, Sklep sklep) {
        this.nazwaWydawnictwa = nazwaWydawnictwa;
        this.dostepniAutorzy = new ArrayList<>();
        this.drukarnie = new ArrayList<>();
        this.sklep = sklep;
    }

    public String getNazwaWydawnictwa() {
        return nazwaWydawnictwa;
    }

    public List<Autor> getDostepniAutorzy() {
        return dostepniAutorzy;
    }

    public List<Drukarnia> getDrukarnie() {
        return drukarnie;
    }

    public Sklep getSklep() {
        return sklep;
    }

    public void przejrzyjAutorow() {
        int i = 1;
        System.out.println("Wydawnictwo " + nazwaWydawnictwa + " zatrudnia nastepujacych autorow:");
        for(Autor autor : dostepniAutorzy) {
            System.out.println("\tAutor " + i++ + ": " + autor.getImie() + " " + autor.getNazwisko() +
                    " " );
            autor.przejrzyjUmowy();
        }
    }

    public void przejrzyjDrukarnie() {
        int i = 1;
        System.out.println("Wydawnictwo " + nazwaWydawnictwa + " wspolpracyje z drukarniami:");
        for(Drukarnia drukarnia : drukarnie) {
            System.out.println("\tDrukarnia " + i++ + ":  firma " + drukarnia.getNazwaFirmy()
                    + " a drukarnia nie drukuje " + drukarnia.getCzegoNieDrukuje());
        }
    }

    public void przjerzyjOferteSklepu() {
        System.out.println("Sklep " + sklep.getNazwa() + " ma w asortymencie");
        for(int i = 0; i < sklep.dostepnePozycje.size(); i++) {
            System.out.println("\tPozycja literacka " + sklep.dostepnePozycje.get(i).getZleconaPozycja().getTytul() +
                    "   autorstwa " + sklep.dostepnePozycje.get(i).getAutor().getImie() +
                    " " + sklep.dostepnePozycje.get(i).getAutor().getNazwisko() +
                    " w ilosci " + sklep.dostepnePozycje.get(i).getIloscEgzemplarzy() + " sztuk");
        }
    }

    public int znajdzAutora(Autor autor) {
        for(int i = 0; i < dostepniAutorzy.size(); i++) {
            if(dostepniAutorzy.get(i).equals(autor)) {
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

    private int znajdzDrukarnie(Drukarnia drukarnia) {
        for(int i = 0; i < drukarnie.size(); i++) {
            if(drukarnie.get(i).equals(drukarnia)) {
                return i;
            }
        }

        return -1;
    }

    public boolean dodajDrukarnie(Drukarnia drukarnia) {
        if(znajdzDrukarnie(drukarnia) == -1) {
            drukarnie.add(drukarnia);
            return true;
        }

        return false;
    }

    public boolean usunDrukarnie(Drukarnia drukarnia) {
        if(znajdzDrukarnie(drukarnia) >= 0) {
            drukarnie.remove(drukarnia);
            return true;
        }

        return false;
    }

    public boolean przekazDoSklepu(Zlecenie zlecenie, Drukarnia drukarnia) {
        int i = znajdzDrukarnie(drukarnia);

        if(i >= 0) {
            Drukarnia drukarniaZeZleceniami = drukarnie.get(i);

            if(drukarniaZeZleceniami.wyslijDoSklepu(zlecenie)) {
                sklep.dodajDoSklepu(zlecenie);
                return true;
            }
        }

        return false;
    }
}
