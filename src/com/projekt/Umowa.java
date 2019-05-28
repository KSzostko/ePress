package com.projekt;

public abstract class Umowa {
    private int wynagrodzenie;
    private String termin;

    public Umowa(int wynagrodzenie, String termin) {
        this.wynagrodzenie = wynagrodzenie;
        this.termin = termin;
    }

    public int getWynagrodzenie() {
        return wynagrodzenie;
    }

    public String getTermin() {
        return termin;
    }

    public void setWynagrodzenie(int wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }

    public void setTermin(String termin) {
        this.termin = termin;
    }
}
