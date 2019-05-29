package com.projekt;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String imie;
    private String nazwisko;
    private List<Umowa> umowy;

    public Autor(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.umowy = new ArrayList<>();
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public List<Umowa> getUmowy() {
        return umowy;
    }

    public void przejrzyjUmowy() {
        int i = 1;
        for(Umowa umowa : umowy) {
            System.out.println("Umowa nr " + i++ + ": ");
            if(umowa instanceof UmowaOPrace) {
                System.out.println("umowa o prace na okres " +
                        ((UmowaOPrace) umowa).getOkresPracy() + " dni");
            } else {
                System.out.println("umowa o dzielo " +
                        ((UmowaODzielo) umowa).getDzielo());
            }
        }
    }
}
