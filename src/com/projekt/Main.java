package com.projekt;

public class Main {

    public static void main(String[] args) {
        System.out.println("Witaj w wydawnictwie ePress!");

        PozycjaLiteracka ksiazka1 = new Ksiazka("Wiedzmin", 24.99, "fantasy");
        Ksiazka ksiazka2 = new Ksiazka("Polska w obiektywie", 40.00, "album");
        PozycjaLiteracka czasopismo1 = new Czasopismo("CD-Action", 19.99, "miesiac");
        Czasopismo czasopismo2 = new Czasopismo("Świat wiedzy", 28.50, "kwartal");

        Autor autor1 = new Autor("Jan", "Kowalski");
        Autor autor2 = new Autor("Filip", "Sasinowski");
        Autor autor3 = new Autor("Jakub", "Szostko");
    }
}
