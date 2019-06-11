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
        for(Autor autor : dostepniAutorzy) {
            System.out.println("Autor " + i + ": " + autor.getImie() + " " + autor.getNazwisko() +
                    " " + autor.getUmowy());
        }
    }

    public void przejrzyjDrukarnie() {
        int i = 1;
        for(Drukarnia drukarnia : drukarnie) {
            System.out.println("Drukarnia " + i + ": " + "drukarnia nie drukuje " +
                    drukarnia.getCzegoNieDrukuje());
        }
    }

    public void przjerzyjOferteSklepu() {
        System.out.println("Sklep " + sklep.getNazwa() + " ma w asortymencie: \t" +
                sklep.dostepnePozycje);
    }

    public boolean dodajAutora(Autor autor) {
        // trzeba zobaczyc, czy zawartosc listy umow wplywa na porownywanie
        if(!dostepniAutorzy.contains(autor)) {
            dostepniAutorzy.add(autor);
            return true;
        }

        return false;
    }

    public boolean usunAutora(Autor autor) {
        if(dostepniAutorzy.contains(autor)) {
            dostepniAutorzy.remove(autor);
            return true;
        }

        return false;
    }
}