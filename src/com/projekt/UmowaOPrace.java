package com.projekt;

public class UmowaOPrace extends Umowa {
    protected int okresPracy;

    public UmowaOPrace(int wynagrodzenie, int okresPracy) {
        super(wynagrodzenie);
        this.okresPracy = okresPracy;
    }

    public int getOkresPracy() {
        return okresPracy;
    }

    public void setOkresPracy(int okresPracy) {
        this.okresPracy = okresPracy;
    }
}
