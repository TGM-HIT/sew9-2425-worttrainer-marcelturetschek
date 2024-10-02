package org.example.Model;

import java.text.DecimalFormat;

/**
 * Klasse für die Statistik des WortTrainers
 */

public class WortTrainerStatistik {
    private int versuche;
    private int richtigeAntworten;

    public WortTrainerStatistik() {
        this.versuche = 0;
        this.richtigeAntworten = 0;
    }

    public void addVersuch(boolean richtig) {
        this.versuche++;
        if (richtig) {
            this.richtigeAntworten++;
        }
    }

    public int getVersuche() {
        return versuche;
    }

    public void setVersuche(int versuche) {
        this.versuche = versuche;
    }

    public void setRichtigeAntworten(int richtigeAntworten) {
        this.richtigeAntworten = richtigeAntworten;
    }

    public int getRichtigeAntworten() {
        return richtigeAntworten;
    }

    public String getProzentRichtig() {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        if (this.versuche == 0) {
            return "0.00";
        }
        return numberFormat.format((double) this.richtigeAntworten / this.versuche * 100);
    }
}
