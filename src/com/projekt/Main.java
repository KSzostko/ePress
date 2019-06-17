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

        ePress.przejrzyjAutorow();
        ePress.przejrzyjDrukarnie();

        // zlecenia wydruku
        Zlecenie zlecenie1 = new Zlecenie(ksiazka1, autor1, 2000);
        Zlecenie zlecenie2 = new Zlecenie(ksiazka2, autor3, 1500);
        Zlecenie zlecenie3 = new Zlecenie(ksiazka3, autor2, 3000);
        Zlecenie zlecenie4 = new Zlecenie(czasopismo1, autor1, 800);
        Zlecenie zlecenie5 = new Zlecenie(czasopismo2, autor3, 500);

        drukarnia1.wydrukuj(zlecenie1);
        drukarnia1.wydrukuj(zlecenie2);
        // zlecenie 2 nie zostanie wykonane, poniewaz drukarnia1 nie drukuje albumów
        drukarnia1.przejrzyjZlecenia();

        drukarnia2.wydrukuj(zlecenie3);
        drukarnia2.wydrukuj(zlecenie4);
        drukarnia2.przejrzyjZlecenia();

        drukarnia3.wydrukuj(zlecenie1);
        // zlecenie1 nie zostanie wydrukowane, poniewaz drukarnia3 nie drukuje książek fantasy
        drukarnia3.wydrukuj(zlecenie5);
        drukarnia3.przejrzyjZlecenia();

        ePress.przejrzyjAutorow();
        // umowy o dzielo dobrze usuwa, potem trzeba jescze sprawdzić, czy to samo z umowami o prace

        // przekazywanie zasobow do sklepu, sprawdzamy, czy zmniejsza się ilość egzemplarzy w drukarni
        // i zmniejsza w sklepie lub też dodaje się całkowicie nowa poyzcja w sklepie
        drukarnia1.przejrzyjZlecenia();
        Zlecenie asortymentDoSklepu = new Zlecenie(ksiazka1, autor1, 550);
        ePress.przekazDoSklepu(asortymentDoSklepu, drukarnia1);
        ePress.przjerzyjOferteSklepu();
        drukarnia1.przejrzyjZlecenia();
    }
}
