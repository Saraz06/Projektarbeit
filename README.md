In diesem Projekt haben wir ein Programm geschrieben, das es dem Nutzer ermöglicht, ein personalisiertes Buch zu bestellen.

**Video**: https://drive.google.com/file/d/14vgrgAxZXqtTS9mvT0R_RCs5WHnBhLz3/view?usp=sharing

**Anwendung**
Starten Sie die Anwendung.

Geben Sie die Details für das Buch ein:

    Für wen soll das Buch sein, und welche Gravur soll es enthalten?
    Wählen Sie zwischen Softcover und Hardcover.
    Geben Sie die Charaktereigenschaften an:
        Name, Alter und Geschlecht der Charaktere.
    Sollen die Charaktere magische Fähigkeiten besitzen?
    Welche Storyline soll das Buch haben?

Klicken Sie auf Bestellen, um das Buch dem Warenkorb hinzuzufügen.

Um ein weiteres Buch zu bestellen, drücken Sie auf den Reset-Button.


**Funktionen und Methoden**

initObjekte()

    Erstellt drei Standardbücher, die der internen buecherListe hinzugefügt werden.
    Aktualisiert den Gesamtpreis basierend auf den Standardbüchern.

berechnePreis()

    Berechnet den Preis des aktuellen Buches basierend auf den ausgewählten Optionen.

    reset()

    Setzt alle Eingabefelder und Auswahlelemente zurück, um eine neue Bestellung zu beginnen.

    warenanzahl()

    Zählt die Anzahl der im Warenkorb befindlichen Bücher und aktualisiert die Anzeige.

![image](https://github.com/user-attachments/assets/8382ddae-2c65-4f36-997a-83919ebf81ce)

    zeigeWarenkorb()

    Zeigt die Bestellübersicht (Warenkorb) in einem neuen Fenster.
    Überprüft, ob alle erforderlichen Eingaben korrekt sind:
        Fehlermeldungen, falls Felder leer sind oder falsche Eingaben (z. B. nicht-numerisches Alter) gemacht werden.
    Fügt das aktuelle Buch zur buecherListe hinzu.
    Aktualisiert die Warenkorbanzeige.
