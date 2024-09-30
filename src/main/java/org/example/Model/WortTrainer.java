package org.example.Model;

/**
 * Klasse für den WortTrainer
 * Der WortTrainer verwaltet die WortListe und die Statistik
 */

public class WortTrainer {
    private WortPaar currentWort;
    private WortListe wortListe;
    private WortTrainerStatistik statistik;

    public WortTrainer(WortListe wortListe) {
        this.wortListe = wortListe;
        this.currentWort = wortListe.getWortListe().get(0);
        this.statistik = new WortTrainerStatistik();
    }

    public WortPaar getRandomWort() {
        currentWort = this.wortListe.getWortListe().get((int) (Math.random() * this.wortListe.getWortListe().size()));
        return currentWort;
    }

    public boolean check(String userInput) {
        String wortWert = this.currentWort.getWortWert();
        if (userInput.equals(wortWert)) {
            this.statistik.addVersuch(true);
            return true;
        } else {
            this.statistik.addVersuch(false);
            return false;
        }
    }

    public WortPaar getCurrentWort() {
        return currentWort;
    }

    public WortTrainerStatistik getStatistik() {
        return statistik;
    }
}
