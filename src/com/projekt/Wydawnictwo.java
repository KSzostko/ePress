package com.projekt;

import java.util.ArrayList;
import java.util.List;

public class Wydawnictwo {
    private String nazwaWydawnictwa;
    private List<Drukarnia> drukarnie;
    private Sklep sklep;

    public Wydawnictwo(String nazwaWydawnictwa, Sklep sklep) {
        this.nazwaWydawnictwa = nazwaWydawnictwa;
        this.drukarnie = new ArrayList<>();
        this.sklep = sklep;
    }

    public String getNazwaWydawnictwa() {
        return nazwaWydawnictwa;
    }

    public List<Drukarnia> getDrukarnie() {
        return drukarnie;
    }

    public Sklep getSklep() {
        return sklep;
    }

    public void przejrzyjDrukarnie() {
        int i = 1;
        for(Drukarnia drukarnia : drukarnie) {
            System.out.println("Drukarnia " + i + ":  firma " + drukarnia.getNazwaFirmy()
                    + " a drukarnia nie drukuje " + drukarnia.getCzegoNieDrukuje());
        }
    }

    public void przjerzyjOferteSklepu() {
        System.out.println("Sklep " + sklep.getNazwa() + " ma w asortymencie: \t" +
                sklep.dostepnePozycje);
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
        if(znajdzDrukarnie(drukarnia) >= 0) {
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

            if(drukarniaZeZleceniami.wykonajZlecenie(zlecenie)) {
                sklep.dodajDoSklepu(zlecenie);
                return true;
            }
        }

        return false;
    }
}
