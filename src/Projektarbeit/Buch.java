package Projektarbeit;

public class Buch {
    private String fuer;
    private String gravur;
    private String cover;
    private String storyline;
    private String ch1name;
    private double ch1alter;
    private String ch1geschlecht;
    private boolean ch1magischeKraefte;
    private String ch2name;
    private double ch2alter;
    private String ch2geschlecht;
    private boolean ch2magischeKraefte;
    private String preis;

    public Buch(String fuer, String gravur, String cover, String storyline, String ch1name, double ch1alter, String ch1geschlecht,
                boolean ch1magischeKraefte, String ch2name, double ch2alter, String ch2geschlecht, boolean ch2magischeKraefte, String preis) {
        this.fuer = fuer;
        this.gravur = gravur;
        this.cover = cover;
        this.storyline = storyline;
        this.ch1name = ch1name;
        this.ch1alter = ch1alter;
        this.ch1geschlecht = ch1geschlecht;
        this.ch1magischeKraefte = ch1magischeKraefte;
        this.ch2name = ch2name;
        this.ch2alter = ch2alter;
        this.ch2geschlecht = ch2geschlecht;
        this.ch2magischeKraefte = ch2magischeKraefte;
        this.preis = preis;

    }

    public String ausgeben() {
        return " Für: " + fuer + " | Gravur: " + gravur + " | Cover: " + cover +
                " | Storyline: " + storyline + "\n Charakter: " + ch1name + " | Alter: " + ch1alter +
                " | Geschlecht: " + ch1geschlecht + " | Verfügt über magische Kräfte: " + ch1magischeKraefte + "\n Charakter 2: " +
                ch2name + " | Alter: " + ch2alter + " | Geschlecht: " + ch2geschlecht +
                " | Verfügt über magische Kräfte: " + ch2magischeKraefte + " | Preis: " + preis + "\n --------";

    }
}