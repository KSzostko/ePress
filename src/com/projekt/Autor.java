package com.projekt;

import java.util.ArrayList;
import java.util.List;
// commitTest
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

    public int znajdzUmoweODzielo(UmowaODzielo umowa) {
        for(int i = 0; i < umowy.size(); i++) {
            if(umowy.get(i) instanceof UmowaODzielo) {
                if(((UmowaODzielo) umowy.get(i)).getDzielo().equals(umowa.getDzielo())) {
                    return i;
                }
            }
        }

        return -1;
    }

    public int znajdzUmoweOPrace() {
        for(int i = 0; i < umowy.size(); i++) {
            if(umowy.get(i) instanceof UmowaOPrace) {
                return i;
            }
        }

        return -1;
    }

    public boolean zawrzyjUmowe(Umowa umowa) {
        if(!umowy.contains(umowa)) {
            umowy.add(umowa);
            return true;
        }

        return false;
    }

    public boolean zakonczUmowe(UmowaODzielo umowa) {
        if(umowy.contains(umowa)) {
            umowy.remove(umowa);
            return true;
        }

        return false;
    }

    public boolean zakonczUmowe(UmowaOPrace umowa) {
        if(umowy.contains(umowa) && umowa.getOkresPracy() == 0) {
            umowy.remove(umowa);
            return true;
        }

        return true;
    }

    public void skrocOkresPracy(UmowaOPrace umowa) {
        umowa.okresPracy--;
    }

    @Override
    public boolean equals(Object autor) {
        if(((Autor) autor).imie.equals(this.imie) && ((Autor) autor).nazwisko.equals(this.nazwisko)) {
            return true;
        }
        
        return false;
    }
}
