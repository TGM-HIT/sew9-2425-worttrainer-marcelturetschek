package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Klasse für ein WortPaar
 * Ein WortPaar besteht aus einem Wort und einer URL
 */

public class WortPaar {
    private String wortWert;
    private String wortURL;

    public WortPaar(String wortWert, String wortURL) {
        this.wortWert = wortWert;
        this.wortURL = wortURL;
        checkURL();
    }

    public String getWortWert() {
        return wortWert;
    }

    public void setWortWert(String wortWert) {
        this.wortWert = wortWert;
    }

    public String getWortURL() {
        return wortURL;
    }

    public void setWortURL(String wortURL) {
        checkURL();
        this.wortURL = wortURL;
    }

    /**
     * Überprüft ob die URL korrekt ist
     * @throws IllegalArgumentException wenn die URL null ist oder das Format nicht stimmt
     */
    public void checkURL() {
        if (this.wortURL == null) {
            throw new IllegalArgumentException("URL hat Wert null");
        }
        try {
            Pattern regex = Pattern.compile("^(https?://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]+\\.[-a-zA-Z0-9+&@#/%=~_|]+)");
            Matcher matcher = regex.matcher(this.wortURL);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("URL hat falsches Format");
            }
        }catch (RuntimeException e) {
            throw new IllegalArgumentException("URL hat falsches Format");
        }
    }
}
