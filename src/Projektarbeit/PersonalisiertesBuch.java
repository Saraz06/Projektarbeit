package Projektarbeit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PersonalisiertesBuch extends JFrame  {
    private ArrayList<Buch> buecherListe;
    private double preis;
    private double gesamtPreis;
    private JTextArea ausgabefeld;

    private JPanel panelMain;

    private JTextField textFieldCh1Name;
    private JTextField textFieldCh2Name;
    private JTextField textField6;
    private JComboBox comboBoxCh1Geschlecht;
    private JComboBox comboBoxCh2Geschlecht;

    private JRadioButton rBHard;
    private JRadioButton rBSoft;
    private JLabel JlabelCover;
    private JLabel JLabelGravur;
    private JLabel JLabelCh1;
    private JLabel JLabelCh2;
    private JLabel JLabelCh1Name;
    private JLabel JLabelCh2Name;
    private JLabel JLabelCh2Alter;
    private JLabel JLabelCh1Alter;
    private JLabel JLabelCh1Geschlecht;
    private JLabel JLabelStoryline;
    private JLabel JLabelFuer;
    private JComboBox comboBoxStoryline;
    private JButton  buttonBestellen;
    private JLabel JLabelGeschenk;
    private JTextField JtextFieldFuer;
    private JTextField textFieldPreis;
    private JTextField textFieldWarenkorb;
    private JLabel JLabelCh2Geschlecht;
    private JComboBox comboBoxGravur1;
    private JComboBox comboBoxGravur2;
    private JPanel frame;
    private JCheckBox checkBox1MK;
    private JCheckBox checkBox2MK;
    private JTextField textFieldCh1Alter;
    private JTextField textFieldCh2Alter;
    private JButton buttonReset;
    private JLabel LabelPreis;

    //Konstruktor
    public PersonalisiertesBuch() {
        setTitle("Personalisiere dein Buch");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(620, 600);
        setContentPane(frame);
        setVisible(true);

        //Erstellen der ArrayList
        buecherListe = new ArrayList<>();

        JLabelGeschenk.setVisible(false);

        initObjekte();

        //Action Listener für Bestellen Button sodass die Warenkorb Methode beim Klicken des Buttons
        //ausgeführt wird
        buttonBestellen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zeigeWarenkorb();
            }
        });

        //Gruppierung der Button, sodass man nur einen auswählen kann
        ButtonGroup coverGroup = new ButtonGroup();

        coverGroup.add(rBHard);
        coverGroup.add(rBSoft);


        //Action Listener für Preis Button sodass die Methode beim klicken des Buttons ausgeführt wird
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
    }

    //Methode zur Erstellung der drei Objekte die in der Liste gespeichert sind
    public void initObjekte() {
        Buch b1 = new Buch("Tobias", "T.G", "Soft Cover", "Abenteuer", "Heinrich", 56, "männlich",
                true, "Hugo", 23, "männlich", true,"19€");
        buecherListe.add(b1);
        gesamtPreis = gesamtPreis + 19;
        Buch b2 = new Buch("Simon", "S.N", "Hard Cover", "Love Story", "Tom", 16, "männlich",
                false, "Lena", 17, "weiblich", false, "15€");
        buecherListe.add(b2);
        gesamtPreis = gesamtPreis + 15;
        Buch b3 = new Buch("Gustav", "G.G", "Soft Cover", "Comedy", "Franz", 43, "männlich",
                false, "Böse Hexe", 76, "weiblich", true, "20€");
        buecherListe.add(b3);

        gesamtPreis = gesamtPreis + 20;
        textFieldPreis.setText(gesamtPreis + "€");
    }



        //Anzahl an bestellten Büchern (Warenkorb)
        //die Warenanzahl erhöht sich pro bestelltes Buch um Eins
        int anzahl = 0;


        public void warenanzahl() {
            anzahl +=1;

            textFieldWarenkorb.setText (String.valueOf(anzahl));
        }

        //Methode zum Zurücksetzen des Eingetragenen sodass ein zweites Buch bestellt werden kann
        public void reset() {
            JtextFieldFuer.setText("");
            comboBoxGravur1.setSelectedIndex(0);
            comboBoxGravur2.setSelectedIndex(0);
            rBHard.setSelected(false);
            rBSoft.setSelected(false);
            textFieldCh1Name.setText("");
            textFieldCh2Name.setText("");
            textFieldCh1Alter.setText("");
            comboBoxStoryline.setSelectedIndex(0);
            comboBoxCh1Geschlecht.setSelectedIndex(0);
            textFieldCh2Alter.setText("");
            comboBoxCh2Geschlecht.setSelectedIndex(0);
            checkBox1MK.setSelected(false);
            checkBox2MK.setSelected(false);

        }






    // Methode zum berechnen des Preises
    public void berechnePreis() {
        preis = 10.0;

        if (rBHard.isSelected()) {
            preis += 5.0;
        }
        if (rBSoft.isSelected()) {
            preis += 3.0;
        }

        String storyline = (String) comboBoxStoryline.getSelectedItem();
        if ("Comedy".equals(storyline)) {
            preis += 4.0;
        }
        if (checkBox1MK.isSelected()) {
            preis += 3.0;
        }
        if (checkBox2MK.isSelected()) {
            preis += 3.0;
        }

        gesamtPreis = gesamtPreis + preis;
        textFieldPreis.setText(gesamtPreis + "€");

    }

    // Methode die einerseits die Bestellübersicht im Warenkorb ausgibt kombiniert mit der Ausgabe
    // von Fehlermeldungennbei ungültigen Eingaben
    public void zeigeWarenkorb() {
        JFrame bestelluebersichtFrame = new JFrame("Warenkorb");


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        String fuer = JtextFieldFuer.getText();
        String gravur = comboBoxGravur1.getSelectedItem().toString() + "." + comboBoxGravur2.getSelectedItem().toString();
        String cover = "";

        // Ausgeben einer Fehlermeldung falls kein Covertyp ausgewählt wurde
        if (rBHard.isSelected()) {
            cover = "Hard Cover";
        } else if (rBSoft.isSelected())
            cover = "Soft Cover";
        if (cover.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bitte einen Covertyp auswählen");
            return;
        }

        // Ausgeben einer Fehlermeldung falls nicht alles ausgewählt wurde oder Buchstaben beim Alter angegeben wurden
        String storyline = comboBoxStoryline.getSelectedItem().toString();
        String ch1name = textFieldCh1Name.getText();
        String ch2name = textFieldCh2Name.getText();
        double ch1alter;
        try {
            ch1alter = Double.parseDouble(textFieldCh1Alter.getText());
        } catch (NumberFormatException ex) {
            if(textFieldCh1Alter.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Bitte alles ausfüllen");
            }else{
            JOptionPane.showMessageDialog(null, "Bitte als Altersangabe nur Zahlen eingeben");}
            return;
        }
        double ch2alter;
        try {
            ch2alter = Double.parseDouble(textFieldCh2Alter.getText());
        } catch (NumberFormatException ex) {
            if(textFieldCh2Alter.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Bitte alles ausfüllen");
            }else{
            JOptionPane.showMessageDialog(null, "Bitte als Altersangabe nur Zahlen eingeben");}
            return;
        }

        String ch1geschlecht = comboBoxCh1Geschlecht.getSelectedItem().toString();
        String ch2geschlecht = comboBoxCh2Geschlecht.getSelectedItem().toString();
        boolean ch1magischeKraefte;
        if (checkBox1MK.isSelected()) {
            ch1magischeKraefte = true;
        } else {
            ch1magischeKraefte = false;
        }
        boolean ch2magischeKraefte;
        if (checkBox2MK.isSelected()) {
            ch2magischeKraefte = true;
        } else {
            ch2magischeKraefte = false;
        }


        if (fuer.isEmpty() || ch1name.isEmpty() || ch2name.isEmpty() ||
                ch1geschlecht.isEmpty() || ch2geschlecht.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bitte alles ausfüllen");
            return;
        }
        berechnePreis();

        //Erstellen eines Ojektes mit den manuellen Daten der GUI
        Buch buch = new Buch(fuer, gravur, cover, storyline, ch1name, ch1alter, ch1geschlecht,
                ch1magischeKraefte, ch2name, ch2alter, ch2geschlecht, ch2magischeKraefte, preis + "€");
        // Hinzufügen der Objekte zur ArrayList
        buecherListe.add(buch);

        panel.add(ausgabefeld);

        JButton schliessenButton = new JButton("Schließen");
        schliessenButton.addActionListener(e -> bestelluebersichtFrame.dispose());
        panel.add(schliessenButton);

        bestelluebersichtFrame.add(panel);
        bestelluebersichtFrame.setSize(700, 600);
        bestelluebersichtFrame.setLocationRelativeTo(null);
        bestelluebersichtFrame.setVisible(true);

        ausgabefeld.setText("");
        anzahl = 0;
        JLabelGeschenk.setVisible(true);

        for(Buch b: buecherListe){
            ausgabefeld.setText(ausgabefeld.getText() + "\n" + b.ausgeben());
    // wenn ein objekt hinzugefügt wird geht die anzahl im warenkorb hoch
            warenanzahl();}
        ausgabefeld.setText(ausgabefeld.getText() + "\n                                                                                                                                                                           Gesamtpreis: "+ gesamtPreis+"€");
    }




    // Main Methode
    public static void main(String[] args) {
        new PersonalisiertesBuch();
    }


}