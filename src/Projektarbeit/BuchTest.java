package Projektarbeit;

//JUnit Test
import static org.junit.jupiter.api.Assertions.*;

class BuchTest {
    Buch b1 = new Buch("Tobias", "T.G", "Soft Cover", "Abenteuer", "Heinrich", 56,
            "männlich", true, "Hugo", 23, "männlich", true,"19€");

    @org.junit.jupiter.api.Test
    void ausgeben_test() {
        assertEquals(" Für: Tobias | Gravur: T.G | Cover: Soft Cover | Storyline: Abenteuer\n Charakter: Heinrich | Alter: 56.0 | Geschlecht: männlich | Verfügt über magische Kräfte: true\n Charakter 2: Hugo | Alter: 23.0 | Geschlecht: männlich | Verfügt über magische Kräfte: true | Preis: 19€\n --------", b1.ausgeben());

    }
}