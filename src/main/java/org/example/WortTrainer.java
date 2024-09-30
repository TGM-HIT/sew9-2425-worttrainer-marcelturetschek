package org.example;

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
        return this.wortListe.getWortListe().get((int) (Math.random() * this.wortListe.getWortListe().size()));
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
}
