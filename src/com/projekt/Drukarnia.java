package com.projekt;

import java.util.ArrayList;
import java.util.List;

public class Drukarnia {
    private List<ZlecenieDruku> zlecenia;
    private String typDrukarni;

    public Drukarnia(String typDrukarni) {
        this.typDrukarni = typDrukarni;
        this.zlecenia = new ArrayList<>();
    }

    public List<ZlecenieDruku> getZlecenia() {
        return zlecenia;
    }

    public String getTypDrukarni() {
        return typDrukarni;
    }
}
