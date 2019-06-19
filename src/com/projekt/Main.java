package com.projekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//
//        System.out.println("Witaj w wydawnictwie ePress!");
//
//        PozycjaLiteracka ksiazka1 = new Ksiazka("Wiedzmin", 24.99, "fantasy");
//        Ksiazka ksiazka2 = new Ksiazka("Polska w obiektywie", 40.00, "album");
//        Ksiazka ksiazka3 = new Ksiazka("Historia informatyki", 50.25, "edukacyjna");
//        PozycjaLiteracka czasopismo1 = new Czasopismo("CD-Action", 19.99, "miesiac");
//        Czasopismo czasopismo2 = new Czasopismo("Świat wiedzy", 28.50, "kwartal");
//
//        Autor autor1 = new Autor("Jan", "Kowalski");
//        Autor autor2 = new Autor("Filip", "Sasinowski");
//        Autor autor3 = new Autor("Jakub", "Szostko");
//
//        Umowa umowa1 = new UmowaODzielo(2500, ksiazka1);
//        UmowaODzielo umowa2 = new UmowaODzielo(1800, ksiazka3);
//        UmowaOPrace umowa3 = new UmowaOPrace(3300, 365);
//        UmowaOPrace umowa4 = new UmowaOPrace(4000, 180);
//
          Sklep sklep = new Sklep("ePress shop");
//        Drukarnia drukarnia1 = new Drukarnia("DrukPro", "album");
//        Drukarnia drukarnia2 = new Drukarnia("DrukPol");
//        Drukarnia drukarnia3 = new Drukarnia("Drukolor", "fantasy");
//
          Wydawnictwo ePress = new Wydawnictwo("ePress", sklep);
//        ePress.dodajDrukarnie(drukarnia1);
//        ePress.dodajDrukarnie(drukarnia2);
//        ePress.dodajDrukarnie(drukarnia3);
//        ePress.dodajAutora(autor1);
//        ePress.dodajAutora(autor2);
//        ePress.dodajAutora(autor3);
//
//        autor1.zawrzyjUmowe(umowa1);
//        autor1.zawrzyjUmowe(umowa4);
//        autor1.przejrzyjUmowy();
//        autor2.zawrzyjUmowe(umowa2);
//        autor3.zawrzyjUmowe(umowa3);
//
//        ePress.przejrzyjAutorow();
//        ePress.przejrzyjDrukarnie();
//
//        // zlecenia wydruku
//        Zlecenie zlecenie1 = new Zlecenie(ksiazka1, autor1, 2000);
//        Zlecenie zlecenie2 = new Zlecenie(ksiazka2, autor3, 1500);
//        Zlecenie zlecenie3 = new Zlecenie(ksiazka3, autor2, 3000);
//        Zlecenie zlecenie4 = new Zlecenie(czasopismo1, autor1, 800);
//        Zlecenie zlecenie5 = new Zlecenie(czasopismo2, autor3, 500);
//
//        drukarnia1.wydrukuj(zlecenie1);
//        drukarnia1.wydrukuj(zlecenie2);
//        // zlecenie 2 nie zostanie wykonane, poniewaz drukarnia1 nie drukuje albumów
//        drukarnia1.przejrzyjZlecenia();
//
//        drukarnia2.wydrukuj(zlecenie3);
//        drukarnia2.wydrukuj(zlecenie4);
//        drukarnia2.przejrzyjZlecenia();
//
//        drukarnia3.wydrukuj(zlecenie1);
//        // zlecenie1 nie zostanie wydrukowane, poniewaz drukarnia3 nie drukuje książek fantasy
//        drukarnia3.wydrukuj(zlecenie5);
//        drukarnia3.przejrzyjZlecenia();
//
//        ePress.przejrzyjAutorow();
//        // umowy o dzielo dobrze usuwa, potem trzeba jescze sprawdzić, czy to samo z umowami o prace
//
//        // przekazywanie zasobow do sklepu, sprawdzamy, czy zmniejsza się ilość egzemplarzy w drukarni
//        // i zmniejsza w sklepie lub też dodaje się całkowicie nowa poyzcja w sklepie
//        drukarnia1.przejrzyjZlecenia();
//        Zlecenie asortymentDoSklepu = new Zlecenie(ksiazka1, autor1, 550);
//        ePress.przekazDoSklepu(asortymentDoSklepu, drukarnia1);
//        sklep.przejrzyjOferty();
//        drukarnia1.przejrzyjZlecenia();
//
//        // sprzedajemy książkę i sprawdzamy, czy zmienia to ilość egzemplarzy w sklepie
//        Zlecenie zamownienie = new Zlecenie(ksiazka1, autor1, 20);
//        sklep.sprzedaj(zamownienie);
//        sklep.przejrzyjOferty();


        // twój kod
        List<PozycjaLiteracka> pozycje = new ArrayList<>();
        List<Umowa> umowy = new ArrayList<>();
        List<Autor> autorzy = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        String userInput1;
        String userInput2;
        String userInput3;
        String userInput5;
        int userInput4;
        Boolean mainRunning = true;
        Boolean wydawnictwoRunning = true;
        Boolean zarzad1Running = true;
        Boolean zarzad2Running = true;
        Boolean zarzad3Running = true;
        Boolean zarzad4Running = true;
        Boolean drukarniaLoop = true;
        Boolean sklepLoop = true;
        Boolean miniLoop = true;
        String eater;
        double tripleDouble;

        while(mainRunning){
            System.out.println("Witaj w ePress");
            System.out.println("1.Wydawnictwo");
            System.out.println("2.Drukarnia");
            System.out.println("3.Sklep");
            System.out.println("4.Wyjdz");
            int userChoice = keyboard.nextInt();
            switch(userChoice){
                case 1:
                    wydawnictwoRunning = true;
                    while(wydawnictwoRunning) {
                        System.out.println("1.Zarządzanie autorami");
                        System.out.println("2.Zarządzanie umowami");
                        System.out.println("3.Zarzadzanie drukarniami");
                        System.out.println("4.Zarzadzanie pozycjami literackimi");
                        System.out.println("5.Wroc");

                        userChoice = keyboard.nextInt();
                        eater = keyboard.nextLine();
                        switch (userChoice){
                            case 1:
                                zarzad1Running = true;
                                while(zarzad1Running) {
                                    System.out.println("1.Dodaj autora");
                                    System.out.println("2.Usun autora");
                                    System.out.println("3.Przeglad autorow");
                                    System.out.println("4.Wroc");
                                    userChoice = keyboard.nextInt();
                                    eater = keyboard.nextLine();
                                    switch(userChoice){
                                        case 1:
                                            System.out.println("Podaj imie:");
                                            userInput1 = keyboard.nextLine();
                                            System.out.println("Podaj nazwisko:");
                                            userInput2 = keyboard.nextLine();
                                            Autor autor1 = new Autor(userInput1, userInput2);
                                            ePress.dodajAutora(autor1);
                                            autorzy.add(autor1);
                                            break;
                                        case 2:
                                            System.out.println("Podaj imie:");
                                            userInput1 = keyboard.nextLine();
                                            System.out.println("Podaj nazwisko:");
                                            userInput2 = keyboard.nextLine();
                                            ePress.usunAutora(new Autor(userInput1,userInput2));
                                            Autor autor2 = new Autor(userInput1, userInput2);
                                            autorzy.remove(autor2);
                                            break;
                                        case 3:
                                            ePress.przejrzyjAutorow();
                                            break;
                                        case 4:
                                            zarzad1Running = false;
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                zarzad2Running = true;
                                while(zarzad2Running) {
                                    System.out.println("1.Dodaj umowe");
                                    System.out.println("2.Przeglad umow");
                                    System.out.println("4.Wroc");
                                    userChoice = keyboard.nextInt();
                                    eater = keyboard.nextLine();
                                    switch (userChoice) {
                                        case 1:
                                            System.out.println("1.Dzieło");
                                            System.out.println("2.Prace");
                                            userChoice = keyboard.nextInt();
                                            eater = keyboard.nextLine();
                                            switch (userChoice){
                                                case 1:
                                                    System.out.println("Podaj imie autora");
                                                    userInput1 = keyboard.nextLine();
                                                    System.out.println("Podaj nazwisko autora");
                                                    userInput2 = keyboard.nextLine();

                                                    int i = ePress.znajdzAutora(new Autor(userInput1, userInput2));
                                                    Autor autor = ePress.getDostepniAutorzy().get(i);

                                                    System.out.println("Podaj wynagrodzenie");
                                                    userInput4 = keyboard.nextInt();
                                                    eater = keyboard.nextLine();
                                                    System.out.println("Podaj tytul pozycji na która zawierana jest umowa:");
                                                    userInput3 = keyboard.nextLine();
                                                    System.out.println("Podaj cene tej pozycji");
                                                    tripleDouble = keyboard.nextDouble();
                                                    eater = keyboard.nextLine();
                                                    System.out.println("Podaj rodzaj pozycji");
                                                    userInput5 = keyboard.nextLine();
                                                    Ksiazka ksiazka = new Ksiazka(userInput3,tripleDouble,userInput5);
                                                    i = pozycje.indexOf(ksiazka);
                                                    Umowa umowa1 = new UmowaODzielo(userInput4, ksiazka);
                                                    umowy.add(umowa1);
                                                    autor.zawrzyjUmowe(umowa1);
                                                    pozycje.remove(i);
                                                    break;
                                                case 2:
                                                    System.out.println("Podaj imie autora");
                                                    userInput1 = keyboard.nextLine();
                                                    System.out.println("Podaj nazwisko autora");
                                                    userInput2 = keyboard.nextLine();

                                                    i = ePress.znajdzAutora(new Autor(userInput1, userInput2));
                                                    autor = ePress.getDostepniAutorzy().get(i);

                                                    System.out.println("Podaj wynagrodzenie");
                                                    userInput4 = keyboard.nextInt();
                                                    eater = keyboard.nextLine();
                                                    System.out.println("Czas trwania umowy");
                                                    userChoice = keyboard.nextInt();
                                                    eater = keyboard.nextLine();
                                                    UmowaOPrace umowa3 = new UmowaOPrace(userInput4, userChoice);
                                                    umowy.add(umowa3);
                                                    autor.zawrzyjUmowe(umowa3);
                                                    break;
                                                default:
                                                    break;
                                            }
                                            break;
                                        case 2:
                                            ePress.przejrzyjAutorow();
                                            break;
                                        case 3:
                                            zarzad2Running = false;
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                break;
                            case 3:
                            zarzad3Running = true;
                            while(zarzad3Running){
                                System.out.println("1.Dodaj drukarnie");
                                System.out.println("2.Usun drukarnie");
                                System.out.println("3.Przeglad drukarni");
                                System.out.println("4.Wroc");
                                userChoice = keyboard.nextInt();
                                eater = keyboard.nextLine();
                                switch (userChoice){
                                    case 1:
                                        System.out.println("Podaj nazwe drukarni");
                                        userInput1 = keyboard.nextLine();
                                        System.out.println("Podaj czego drukarnia nie moze wydrukowac(zostaw puste jesli moze wszystko)");
                                        userInput2 = keyboard.nextLine();
                                        Drukarnia drukarnia3 = new Drukarnia(userInput1, userInput2);
                                        ePress.dodajDrukarnie(drukarnia3);
                                        break;
                                    case 2:
                                        System.out.println("Podaj nazwe drukarni");
                                        userInput1 = keyboard.nextLine();
                                        System.out.println("Podaj czego drukarnia nie moze wydrukowac(zostaw puste jesli moze wszystko)");
                                        userInput2 = keyboard.nextLine();
                                        ePress.usunDrukarnie(new Drukarnia(userInput1,userInput2));
                                        break;
                                    case 3:
                                        ePress.przejrzyjDrukarnie();
                                        break;
                                    case 4:
                                        zarzad3Running = false;
                                        break;
                                    default:
                                        break;
                                }
                            }
                                break;
                            case 4:
                                zarzad4Running = true;
                                while(zarzad4Running){
                                    System.out.println("1.Dodaj pozycje");
                                    System.out.println("2.Usun pozycje");
                                    System.out.println("3.Przeglad pozycji");
                                    System.out.println("4.Wroc");
                                    userChoice = keyboard.nextInt();
                                    eater = keyboard.nextLine();
                                    switch (userChoice){
                                        case 1:
                                            System.out.println("1.Ksiazka");
                                            System.out.println("2.Czasopismo");
                                            userChoice = keyboard.nextInt();
                                            eater = keyboard.nextLine();
                                            switch (userChoice){
                                                case 1:
                                                    System.out.println("Podaj tytul");
                                                    userInput1 = keyboard.nextLine();
                                                    System.out.println("Podaj cene");
                                                    tripleDouble = keyboard.nextDouble();
                                                    eater = keyboard.nextLine();
                                                    System.out.println("Podaj gatunek literacki");
                                                    userInput1 = keyboard.nextLine();
                                                    Ksiazka ksiazka1 = new Ksiazka(userInput1, tripleDouble, userInput1);
                                                    break;
                                                case 2:
                                                    System.out.println("Podaj tytul");
                                                    userInput1 = keyboard.nextLine();
                                                    System.out.println("Podaj cene");
                                                    tripleDouble = keyboard.nextDouble();
                                                    eater = keyboard.nextLine();
                                                    System.out.println("Podaj okres wydawania");
                                                    userInput1 = keyboard.nextLine();
                                                    Czasopismo czasopismo1 = new Czasopismo(userInput1, tripleDouble, userInput1);
                                                    break;
                                                default:
                                                    break;
                                            }
                                            break;
                                        case 2:
                                            //usun ksiazke
                                            break;
                                        case 3:
                                            //przeglad ksiazek
                                            break;
                                        case 4:
                                            zarzad4Running = false;
                                            break;
                                        default:
                                            break;
                                    }

                                }
                                break;
                            case 5:
                                wydawnictwoRunning = false;
                                break;
                            default:

                                break;
                        }
                    }
                    break;
                case 2:
                    drukarniaLoop = true;
                    while(drukarniaLoop){
                        System.out.println("1.Wydrukuj");
                        System.out.println("2.Przeglad wydrukowanych");
                        System.out.println("3.Wroc");
                        userChoice = keyboard.nextInt();
                        eater = keyboard.nextLine();
                        switch (userChoice){
                            case 1:
                                System.out.println("1.Czasopismo");
                                System.out.println("2.Ksiazke");
                                userChoice = keyboard.nextInt();
                                eater = keyboard.nextLine();
                                switch (userChoice){
                                    case 1:
                                        System.out.println("Podaj imie autora");
                                        userInput1 = keyboard.nextLine();
                                        System.out.println("Podaj nazwisko autora");
                                        userInput2 = keyboard.nextLine();
                                        System.out.println("Podaj tytul pozycji literackiej");
                                        userInput3 = keyboard.nextLine();
                                        System.out.println("Podaj cene pozycji literackiej");
                                        tripleDouble = keyboard.nextDouble();
                                        eater = keyboard.nextLine();
                                        System.out.println("Podaj czas wydania");
                                        userInput5 = keyboard.nextLine();
                                        System.out.println("Podaj ilosc egzemplarzy do wydruku");
                                        userChoice = keyboard.nextInt();
                                        eater = keyboard.nextLine();
                                        Zlecenie zlecenie1 = new Zlecenie(new Czasopismo(userInput3,tripleDouble,userInput5),new Autor(userInput2,userInput1),userChoice);
                                        System.out.println("Podaj nazwe drukarni");
                                        userInput1 = keyboard.nextLine();
                                        System.out.println("Podaj czego drukarnia nie moze wydrukowac(zostaw puste jesli moze wszystko)");
                                        userInput2 = keyboard.nextLine();
                                        Drukarnia drukarnia1 = new Drukarnia(userInput1,userInput2);
                                        drukarnia1.wydrukuj(zlecenie1);
                                        break;
                                    case 2:
                                        System.out.println("Podaj imie autora");
                                        userInput1 = keyboard.nextLine();
                                        System.out.println("Podaj nazwisko autora");
                                        userInput2 = keyboard.nextLine();
                                        System.out.println("Podaj tytul pozycji literackiej");
                                        userInput3 = keyboard.nextLine();
                                        System.out.println("Podaj cene pozycji literackiej");
                                        tripleDouble = keyboard.nextDouble();
                                        eater = keyboard.nextLine();
                                        System.out.println("Podaj rodzaj ksiazki");
                                        userInput5 = keyboard.nextLine();
                                        System.out.println("Podaj ilosc egzemplarzy do wydruku");
                                        userChoice = keyboard.nextInt();
                                        eater = keyboard.nextLine();
                                        zlecenie1 = new Zlecenie(new Ksiazka(userInput3,tripleDouble,userInput5),new Autor(userInput2,userInput1),userChoice);
                                        System.out.println("Podaj nazwe drukarni");
                                        userInput1 = keyboard.nextLine();
                                        System.out.println("Podaj czego drukarnia nie moze wydrukowac(zostaw puste jesli moze wszystko)");
                                        userInput2 = keyboard.nextLine();
                                        drukarnia1 = new Drukarnia(userInput1,userInput2);
                                        drukarnia1.wydrukuj(zlecenie1);
                                        break;
                                        default:
                                            break;
                                }

                                break;
                            case 2:
                            //przeglad wydrukowanych materialow
                                break;
                            case 3:
                                drukarniaLoop = false;
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 3:
                    sklepLoop = true;
                    while(sklepLoop){
                        System.out.println("1.Przejrzyj asortyment");
                        System.out.println("2.Sprzedaj");
                        System.out.println("3.Zarządz dostawe towaru do sklepu");
                        System.out.println("4.Wroc");
                        userChoice = keyboard.nextInt();
                        eater = keyboard.nextLine();
                        switch (userChoice){
                            case 1:
                                sklep.przejrzyjOferty();
                                break;
                            case 2:

                                System.out.println("1.Czasopismo");
                                System.out.println("2.Ksiazke");
                                userChoice = keyboard.nextInt();
                                eater = keyboard.nextLine();
                                switch (userChoice){
                                    case 1:
                                        System.out.println("Podaj imie autora");
                                        userInput1 = keyboard.nextLine();
                                        System.out.println("Podaj nazwisko autora");
                                        userInput2 = keyboard.nextLine();
                                        System.out.println("Podaj tytul pozycji literackiej");
                                        userInput3 = keyboard.nextLine();
                                        System.out.println("Podaj cene pozycji literackiej");
                                        tripleDouble = keyboard.nextDouble();
                                        eater = keyboard.nextLine();
                                        System.out.println("Podaj czas wydania");
                                        userInput5 = keyboard.nextLine();
                                        System.out.println("Podaj ilosc egzemplarzy do wydruku");
                                        userChoice = keyboard.nextInt();
                                        eater = keyboard.nextLine();
                                        Zlecenie zamowienie = new Zlecenie(new Czasopismo(userInput3,tripleDouble,userInput5),new Autor(userInput2,userInput1),userChoice);
                                        sklep.sprzedaj(zamowienie);
                                        break;
                                    case 2:
                                        System.out.println("Podaj imie autora");
                                        userInput1 = keyboard.nextLine();
                                        System.out.println("Podaj nazwisko autora");
                                        userInput2 = keyboard.nextLine();
                                        System.out.println("Podaj tytul pozycji literackiej");
                                        userInput3 = keyboard.nextLine();
                                        System.out.println("Podaj cene pozycji literackiej");
                                        tripleDouble = keyboard.nextDouble();
                                        eater = keyboard.nextLine();
                                        System.out.println("Podaj rodzaj ksiazki");
                                        userInput5 = keyboard.nextLine();
                                        System.out.println("Podaj ilosc egzemplarzy do wydruku");
                                        userChoice = keyboard.nextInt();
                                        eater = keyboard.nextLine();
                                        zamowienie = new Zlecenie(new Ksiazka(userInput3,tripleDouble,userInput5),new Autor(userInput2,userInput1),userChoice);
                                        sklep.sprzedaj(zamowienie);
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            case 3:
                                    System.out.println("1.Czasopismo");
                                    System.out.println("2.Ksiazke");
                                    userChoice = keyboard.nextInt();
                                    eater = keyboard.nextLine();
                                    switch (userChoice){
                                        case 1:
                                            System.out.println("Podaj imie autora");
                                            userInput1 = keyboard.nextLine();
                                            System.out.println("Podaj nazwisko autora");
                                            userInput2 = keyboard.nextLine();
                                            System.out.println("Podaj tytul pozycji literackiej");
                                            userInput3 = keyboard.nextLine();
                                            System.out.println("Podaj cene pozycji literackiej");
                                            tripleDouble = keyboard.nextDouble();
                                            eater = keyboard.nextLine();
                                            System.out.println("Podaj czas wydania");
                                            userInput5 = keyboard.nextLine();
                                            System.out.println("Podaj ilosc egzemplarzy do wydruku");
                                            userChoice = keyboard.nextInt();
                                            eater = keyboard.nextLine();
                                            Zlecenie asortymentDoSklepu = new Zlecenie(new Czasopismo(userInput3,tripleDouble,userInput5),new Autor(userInput2,userInput1),userChoice);
                                            System.out.println("Podaj nazwe drukarni");
                                            userInput1 = keyboard.nextLine();
                                            System.out.println("Podaj czego drukarnia nie moze wydrukowac(zostaw puste jesli moze wszystko)");
                                            userInput2 = keyboard.nextLine();
                                            Drukarnia drukarnia1 = new Drukarnia(userInput1,userInput2);
                                            ePress.przekazDoSklepu(asortymentDoSklepu, drukarnia1);
                                            break;
                                        case 2:
                                            System.out.println("Podaj imie autora");
                                            userInput1 = keyboard.nextLine();
                                            System.out.println("Podaj nazwisko autora");
                                            userInput2 = keyboard.nextLine();
                                            System.out.println("Podaj tytul pozycji literackiej");
                                            userInput3 = keyboard.nextLine();
                                            System.out.println("Podaj cene pozycji literackiej");
                                            tripleDouble = keyboard.nextDouble();
                                            eater = keyboard.nextLine();
                                            System.out.println("Podaj rodzaj ksiazki");
                                            userInput5 = keyboard.nextLine();
                                            System.out.println("Podaj ilosc egzemplarzy do wydruku");
                                            userChoice = keyboard.nextInt();
                                            eater = keyboard.nextLine();
                                            asortymentDoSklepu = new Zlecenie(new Ksiazka(userInput3,tripleDouble,userInput5),new Autor(userInput2,userInput1),userChoice);
                                            System.out.println("Podaj nazwe drukarni");
                                            userInput1 = keyboard.nextLine();
                                            System.out.println("Podaj czego drukarnia nie moze wydrukowac(zostaw puste jesli moze wszystko)");
                                            userInput2 = keyboard.nextLine();
                                            drukarnia1 = new Drukarnia(userInput1,userInput2);
                                            ePress.przekazDoSklepu(asortymentDoSklepu, drukarnia1);
                                            break;
                                        default:
                                            break;
                                }

                                break;
                            case 4:
                                sklepLoop = false;
                                break;
                                default:
                                    break;
                        }
                    }

                    break;
                case 4:
                    mainRunning = false;
                    break;
                default:

                    break;
            }
        }
        System.out.println("koniec programu");
    }
}
// przekazywanie zasobow do sklepu, sprawdzamy, czy zmniejsza się ilość egzemplarzy w drukarni
//        // i zmniejsza w sklepie lub też dodaje się całkowicie nowa poyzcja w sklepie
//        drukarnia1.przejrzyjZlecenia();
//        Zlecenie asortymentDoSklepu = new Zlecenie(ksiazka1, autor1, 550);
//        ePress.przekazDoSklepu(asortymentDoSklepu, drukarnia1);
//        sklep.przejrzyjOferty();
//        drukarnia1.przejrzyjZlecenia();
//
//        // sprzedajemy książkę i sprawdzamy, czy zmienia to ilość egzemplarzy w sklepie
//        Zlecenie zamownienie = new Zlecenie(ksiazka1, autor1, 20);
//        sklep.sprzedaj(zamownienie);
//        sklep.przejrzyjOferty();