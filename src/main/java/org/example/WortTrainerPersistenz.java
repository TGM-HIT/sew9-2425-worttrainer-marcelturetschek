package org.example;

import org.example.Model.WortListe;
import org.example.Model.WortTrainer;

/**
 * Interface für die Persistenz des WortTrainers
 */

public interface WortTrainerPersistenz {
    public void saveWortTrainer(WortTrainer wortTrainer);
    public WortTrainer loadWortTrainer();
}
