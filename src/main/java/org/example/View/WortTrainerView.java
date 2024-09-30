package org.example.View;

import org.example.Model.*;


import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class WortTrainerView {
    public static void main(String[] args) {
        WortTrainer wortTrainer = loadWortTrainer();

        while (true) {
            WortPaar currentWort = wortTrainer.getCurrentWort();
            String message = "Statistik: " + wortTrainer.getStatistik().getProzentRichtig() + "% - (" + wortTrainer.getStatistik().getRichtigeAntworten() + "/"+ wortTrainer.getStatistik().getVersuche() + ")\n";
            message += "Aktuelles Bild:\n";
            message += "Was siehst du?";

            try {
                URL url = new URL(currentWort.getWortURL());
                ImageIcon icon = new ImageIcon(url);

                Image image = icon.getImage();
                int width = 400;
                int height = (int) (image.getHeight(null) * (400.0 / image.getWidth(null)));
                Image resizedImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(resizedImage);

                JLabel label = new JLabel(icon);

                String userInput = (String) JOptionPane.showInputDialog(
                        null,
                        new Object[]{message, label},
                        "WortTrainer",
                        JOptionPane.PLAIN_MESSAGE
                );

                if (userInput == null || userInput.isEmpty()) {
                    break;
                }

                boolean isCorrect = wortTrainer.check(userInput);
                JOptionPane.showMessageDialog(null, isCorrect ? "Richtig!" : "Falsch!", "Ergebnis", JOptionPane.INFORMATION_MESSAGE);
                if (isCorrect) {
                    wortTrainer.getRandomWort();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        persistWortTrainer(wortTrainer);
        JOptionPane.getRootFrame().dispose();
    }

    private static WortTrainer loadWortTrainer() {
        WortListe wl = new WortListe("Hund", "https://as1.ftcdn.net/v2/jpg/02/58/18/06/1000_F_258180661_y40ddZDL7IxNK5LuPqXZTPOcbSv08t4x.jpg");
        wl.addWortPaar(new WortPaar("Katze", "https://as1.ftcdn.net/v2/jpg/01/19/18/08/1000_F_119180881_GtjSIX6CJLMCsoSqzdE6vFBXNVbQmfSs.jpg"));
        return new WortTrainer(wl);
    }

    private static void persistWortTrainer(WortTrainer wortTrainer) {
    }
}
