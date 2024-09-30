package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class WortTrainerTest {
    @Test
    public void wortPaarKlasseTest() {
        assertThrows(IllegalArgumentException.class, () -> new WortPaar("test", "invalidURL"));
        WortPaar wortPaar = new WortPaar("test", "http://example.com");
        assertEquals("test", wortPaar.getWortWert());
        assertEquals("http://example.com", wortPaar.getWortURL());
    }

    @Test
    public void wortListeKlasseTest() {
        WortListe wortListe = new WortListe("test", "http://example.com");
        assertEquals(1, wortListe.getWortListe().size());
        wortListe.addWortPaar(new WortPaar("test2", "http://example2.com"));
        assertEquals(2, wortListe.getWortListe().size());
    }

    @Test
    public void wortTrainerKlasseTest() {
        WortListe wortListe = new WortListe("test", "http://example.com");
        WortTrainer wortTrainer = new WortTrainer(wortListe);
        assertNotNull(wortTrainer.getRandomWort());
        assertTrue(wortTrainer.check("test"));
        assertFalse(wortTrainer.check("wrong"));
    }

    @Test
    public void wortTrainerStatistikTest() {
        WortTrainerStatistik statistik = new WortTrainerStatistik();
        statistik.addVersuch(true);
        statistik.addVersuch(false);
        assertEquals(50.0, statistik.getProzentRichtig());
    }

}
