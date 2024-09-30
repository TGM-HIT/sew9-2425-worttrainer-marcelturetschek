package org.example;

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

    public int getRichtigeAntworten() {
        return richtigeAntworten;
    }

    public double getProzentRichtig() {
        return (double) this.richtigeAntworten / this.versuche * 100;
    }
}
