package com.projekt;

public abstract class Umowa {
    private int wynagrodzenie;

    public Umowa(int wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }

    public int getWynagrodzenie() {
        return wynagrodzenie;
    }

    public void setWynagrodzenie(int wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }
}
