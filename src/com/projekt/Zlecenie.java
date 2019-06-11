package com.projekt;

public class Zlecenie {
    protected PozycjaLiteracka zleconaPozycja;
    protected Autor autor;
    protected int iloscEgzemplarzy;

    public Zlecenie(PozycjaLiteracka zleconaPozycja, Autor autor, int iloscEgzemplarzy) {
        this.zleconaPozycja = zleconaPozycja;
        this.autor = autor;
        this.iloscEgzemplarzy = iloscEgzemplarzy;
    }

    public PozycjaLiteracka getZleconaPozycja() {
        return zleconaPozycja;
    }

    public Autor getAutor() {
        return autor;
    }

    public int getIloscEgzemplarzy() {
        return iloscEgzemplarzy;
    }

    public void setIloscEgzemplarzy(int iloscEgzemplarzy) {
        this.iloscEgzemplarzy = iloscEgzemplarzy;
    }

    @Override
    public boolean equals(Object zlecenie) {
        if(((Zlecenie) zlecenie).zleconaPozycja == this.zleconaPozycja &&
                ((Zlecenie) zlecenie).autor == this.autor) {
            return true;
        }

        return false;
    }
}
