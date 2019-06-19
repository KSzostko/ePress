package com.projekt;

import org.junit.Test;

import static org.junit.Assert.*;

public class DrukarniaTest {

    // czy zlecenie się nie doda, gdy drukarnia nie będzie drukowała tego typu książek
    @Test
    public void wydrukuj_zleceniaDrukarni1() {
        PozycjaLiteracka ksiazka = new Ksiazka("Wiedzmin", 24.99, "fantasy");
        Autor autor = new Autor("Jan", "Kowalski");
        Umowa umowa = new UmowaODzielo(2500, ksiazka);
        Drukarnia drukarnia = new Drukarnia("Drukolor", "fantasy");

        autor.zawrzyjUmowe(umowa);

        Zlecenie zlecenie = new Zlecenie(ksiazka, autor, 2000);

        drukarnia.wydrukuj(zlecenie);

        assertEquals(drukarnia.getZlecenia().size(), 0);
    }

    // czy autorowi zostanie umowa, jeśli drukarnia nie drukuje takich książek
    // na jakie ma on umowy
    @Test
    public void wydrukuj_umowaODzieloAutora1() {
        PozycjaLiteracka ksiazka = new Ksiazka("Wiedzmin", 24.99, "fantasy");
        Autor autor = new Autor("Jan", "Kowalski");
        Umowa umowa = new UmowaODzielo(2500, ksiazka);
        Drukarnia drukarnia = new Drukarnia("Drukolor", "fantasy");

        autor.zawrzyjUmowe(umowa);

        Zlecenie zlecenie = new Zlecenie(ksiazka, autor, 2000);

        drukarnia.wydrukuj(zlecenie);

        assertEquals(autor.getUmowy().size(), 1);
    }

    // czy autorowi zostanie usunięta umowa o dzieło, jeśli drukarnia wydrukuje książkę
    @Test
    public void wydrukuj_umowaODzieloAutora2() {
        Ksiazka ksiazka = new Ksiazka("Historia informatyki", 50.25, "edukacyjna");
        Autor autor = new Autor("Jan", "Kowalski");
        Umowa umowa = new UmowaODzielo(2500, ksiazka);
        Drukarnia drukarnia = new Drukarnia("Drukolor", "fantasy");

        autor.zawrzyjUmowe(umowa);

        Zlecenie zlecenie = new Zlecenie(ksiazka, autor, 2000);

        drukarnia.wydrukuj(zlecenie);

        assertEquals(autor.getUmowy().size(), 0);
    }

    // czy autorowi zostanie usunięta umowa o dzieło, jeśli drukarnia wydrukuje książkę
    @Test
    public void wydrukuj_zleceniaDrukarni2() {
        Ksiazka ksiazka = new Ksiazka("Historia informatyki", 50.25, "edukacyjna");
        Autor autor = new Autor("Jan", "Kowalski");
        Umowa umowa = new UmowaODzielo(2500, ksiazka);
        Drukarnia drukarnia = new Drukarnia("Drukolor", "fantasy");

        autor.zawrzyjUmowe(umowa);

        Zlecenie zlecenie = new Zlecenie(ksiazka, autor, 2000);

        drukarnia.wydrukuj(zlecenie);

        assertEquals(drukarnia.getZlecenia().size(), 1);
    }

    // czy autorowi nie zostanie usunięta umowa o prace, jeśli drukarnia wydrukuje książkę
    // a jemu zostaną jescze dni pracy i ile
    @Test
    public void wydrukuj_umowaOPraceAutora1() {
        Ksiazka ksiazka = new Ksiazka("Historia informatyki", 50.25, "edukacyjna");
        Autor autor = new Autor("Jan", "Kowalski");
        Umowa umowa = new UmowaOPrace(2500, 12);

        Drukarnia drukarnia = new Drukarnia("Drukolor", "fantasy");

        autor.zawrzyjUmowe(umowa);

        Zlecenie zlecenie = new Zlecenie(ksiazka, autor, 2000);

        drukarnia.wydrukuj(zlecenie);

        int liczbaDni = ((UmowaOPrace) autor.getUmowy().get(0)).getOkresPracy();

        assertEquals(liczbaDni, 11);
    }

    // czy autorowi zostanie usunięta umowa o prace, jeśli drukarnia wydrukuje książkę
    // a jemu nie zostaną żadne dni pracy
    @Test
    public void wydrukuj_umowaOPraceAutora2() {
        Ksiazka ksiazka = new Ksiazka("Historia informatyki", 50.25, "edukacyjna");
        Autor autor = new Autor("Jan", "Kowalski");
        Umowa umowa = new UmowaOPrace(2500, 1);

        Drukarnia drukarnia = new Drukarnia("Drukolor", "fantasy");

        autor.zawrzyjUmowe(umowa);

        Zlecenie zlecenie = new Zlecenie(ksiazka, autor, 2000);

        drukarnia.wydrukuj(zlecenie);

        assertEquals(autor.getUmowy().size(), 0);
    }

    // czy jeśli wyślemy do sklepu mniejszą ilość egzemplarzy danej pozycji niż jest w drukarni
    // to czy zostanie dobra ilość
    @Test
    public void wyslijDoSklepu_iloscEgzemplarzy1() {
        Ksiazka ksiazka = new Ksiazka("Historia informatyki", 50.25, "edukacyjna");
        Autor autor = new Autor("Jan", "Kowalski");
        Umowa umowa = new UmowaOPrace(2500, 1);

        Drukarnia drukarnia = new Drukarnia("Drukolor", "fantasy");

        autor.zawrzyjUmowe(umowa);

        Zlecenie zlecenieDruku = new Zlecenie(ksiazka, autor, 2000);
        Zlecenie zlecenieDoSklepu = new Zlecenie(ksiazka, autor, 1999);

        drukarnia.wydrukuj(zlecenieDruku);
        drukarnia.wyslijDoSklepu(zlecenieDoSklepu);

        assertEquals(drukarnia.getZlecenia().get(0).getIloscEgzemplarzy(), 1);
    }

    // czy jeśli wyślemy do sklepu tyle samo egzemplarzy danej pozycji co jest w drukarni
    // to czy nie będzie już tych książek w drukarni
    @Test
    public void wyslijDoSklepu_iloscEgzemplarzy2() {
        Ksiazka ksiazka = new Ksiazka("Historia informatyki", 50.25, "edukacyjna");
        Autor autor = new Autor("Jan", "Kowalski");
        Umowa umowa = new UmowaOPrace(2500, 1);

        Drukarnia drukarnia = new Drukarnia("Drukolor", "fantasy");

        autor.zawrzyjUmowe(umowa);

        Zlecenie zlecenieDruku = new Zlecenie(ksiazka, autor, 2000);
        Zlecenie zlecenieDoSklepu = new Zlecenie(ksiazka, autor, 2000);

        drukarnia.wydrukuj(zlecenieDruku);
        drukarnia.wyslijDoSklepu(zlecenieDoSklepu);

        assertEquals(drukarnia.getZlecenia().size(), 0);
    }
}