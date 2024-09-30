package org.example;

import java.util.ArrayList;

/**
 * Klasse für eine Liste von WortPaaren
 */

public class WortListe {
    private ArrayList<WortPaar> wortListe = new ArrayList<>();

    public WortListe(String wortWert, String wortURL) {
        this.wortListe.add(new WortPaar(wortWert, wortURL));
    }

    public void addWortPaar(WortPaar wortPaar) {
        this.wortListe.add(wortPaar);
    }

    public ArrayList<WortPaar> getWortListe() {
        return wortListe;
    }
}
