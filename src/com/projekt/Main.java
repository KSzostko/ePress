package com.projekt;

public class Main {

    public static void main(String[] args) {
        System.out.println("Witaj w wydawnictwie ePress!");

        PozycjaLiteracka ksiazka1 = new Ksiazka("Wiedzmin", 24.99, "fantasy");
        Ksiazka ksiazka2 = new Ksiazka("Polska w obiektywie", 40.00, "album");
        Ksiazka ksiazka3 = new Ksiazka("Historia informatyki", 50.25, "edukacyjna");
        PozycjaLiteracka czasopismo1 = new Czasopismo("CD-Action", 19.99, "miesiac");
        Czasopismo czasopismo2 = new Czasopismo("Świat wiedzy", 28.50, "kwartal");

        Autor autor1 = new Autor("Jan", "Kowalski");
        Autor autor2 = new Autor("Filip", "Sasinowski");
        Autor autor3 = new Autor("Jakub", "Szostko");

        Umowa umowa1 = new UmowaODzielo(2500, ksiazka1);
        UmowaODzielo umowa2 = new UmowaODzielo(1800, ksiazka3);
        UmowaOPrace umowa3 = new UmowaOPrace(3300, 365);
        UmowaOPrace umowa4 = new UmowaOPrace(4000, 180);

        Sklep sklep = new Sklep("ePress shop");
        Drukarnia drukarnia1 = new Drukarnia("DrukPro", "album");
        Drukarnia drukarnia2 = new Drukarnia("DrukPol");
        Drukarnia drukarnia3 = new Drukarnia("Drukolor", "fantasy");

        Wydawnictwo ePress = new Wydawnictwo("ePress", sklep);
        ePress.dodajDrukarnie(drukarnia1);
        ePress.dodajDrukarnie(drukarnia2);
        ePress.dodajDrukarnie(drukarnia3);
        ePress.dodajAutora(autor1);
        ePress.dodajAutora(autor2);
        ePress.dodajAutora(autor3);

        autor1.zawrzyjUmowe(umowa1);
        autor1.zawrzyjUmowe(umowa4);
        autor1.przejrzyjUmowy();
        autor2.zawrzyjUmowe(umowa2);
        autor3.zawrzyjUmowe(umowa3);


    }
}
