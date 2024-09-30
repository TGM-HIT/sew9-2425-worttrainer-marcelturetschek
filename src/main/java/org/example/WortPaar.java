package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WortPaar {
    private String wortWert;
    private String wortURL;

    public WortPaar(String wortWert, String wortURL) {
        this.wortWert = wortWert;
        checkURL();
        this.wortURL = wortURL;
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
