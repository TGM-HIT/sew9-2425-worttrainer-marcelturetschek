package org.example;

import org.example.Model.WortListe;
import org.example.Model.WortPaar;
import org.example.Model.WortTrainer;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Klasse für die Persistenz des WortTrainers
 * Speichert und lädt den WortTrainer als JSON-Datei
 */

public class WortTrainerPersistenzJSON implements WortTrainerPersistenz {
    @Override
    public void saveWortTrainer(WortTrainer wortTrainer) {
        JSONObject jsonObject = new JSONObject();
        WortListe wo = wortTrainer.getWortListe();
        for (WortPaar wortPaar : wo.getWortListe()) {
            jsonObject.put(wortPaar.getWortWert(), wortPaar.getWortURL());
        }
        jsonObject.put("versuche", wortTrainer.getStatistik().getVersuche());
        jsonObject.put("richtigeAntworten", wortTrainer.getStatistik().getRichtigeAntworten());

        System.out.println("WortTrainer saved!" + jsonObject.toString());

        try {
            FileWriter file = new FileWriter("WortTrainer.json");
            file.write(jsonObject.toString());
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WortTrainer loadWortTrainer() {
        WortTrainer wortTrainer = null;
        try {
            FileReader reader = new FileReader("WortTrainer.json");
            JSONObject jsonObject = new JSONObject(new JSONTokener(reader));

            WortListe wortListe = null;
            for (String key : jsonObject.keySet()) {
                if (!key.equals("versuche") && !key.equals("richtigeAntworten")) {
                    WortPaar wortPaar = new WortPaar(key, jsonObject.getString(key));
                    if (wortListe == null) {
                        wortListe = new WortListe(wortPaar.getWortWert(), wortPaar.getWortURL());
                    } else {
                        wortListe.addWortPaar(wortPaar);
                    }
                }
            }

            int versuche = jsonObject.getInt("versuche");
            int richtigeAntworten = jsonObject.getInt("richtigeAntworten");

            wortTrainer = new WortTrainer(wortListe);
            wortTrainer.getStatistik().setVersuche(versuche);
            wortTrainer.getStatistik().setRichtigeAntworten(richtigeAntworten);

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return wortTrainer;
    }
}
