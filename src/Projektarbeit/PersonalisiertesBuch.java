package Projektarbeit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PersonalisiertesBuch extends JFrame  {
    private ArrayList<Buch> buecherListe;
    private double preis;
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
    private JButton buttonPreis;
    private JButton buttonWarenkorb;
    private JLabel JLabelCh2Geschlecht;
    private JComboBox comboBoxGravur1;
    private JComboBox comboBoxGravur2;
    private JPanel frame;
    private JCheckBox checkBox1MK;
    private JCheckBox checkBox2MK;
    private JTextField textFieldCh1Alter;
    private JTextField textFieldCh2Alter;
    private JButton buttonReset;

    //Konstruktor
    public PersonalisiertesBuch() {
        setTitle("Personalisiere dein Buch");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setContentPane(frame);
        setVisible(true);

        buecherListe = new ArrayList<>();

        JLabelGeschenk.setVisible(false);

        initObjekte();

        //Action Listener für Bestellen Button sodass der Warenkorb ausgegeben wirdsonst push
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


        buttonPreis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                berechnePreis();

            }
        });
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
    }

    public void initObjekte() {
        Buch b1 = new Buch("Tobias", "T.G", "Soft Cover", "Abenteuer", "Heinrich", 56, "Männlich", true, "Hugo", 23, "Weiblich", true,"19€");
        buecherListe.add(b1);
        Buch b2 = new Buch("Simon", "S.N", "Hard Cover", "Love Story", "Tom", 16, "Männlich", false, "Lena", 17, "Männlich", false, "15€");
        buecherListe.add(b2);
        Buch b3 = new Buch("Gustav", "G.G", "Soft Cover", "Comedy", "Franz", 43, "Männlich", false, "Böse Hexe", 76, "Weiblich", true, "20€");
        buecherListe.add(b3);
    }







        //Anzahl an bestellten Bücher (Warenkorb)
        int anzahl = 0;


        public void warenanzahl() {
            anzahl +=1;

            textFieldWarenkorb.setText (String.valueOf(anzahl));
        }

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







    public void berechnePreis() {
        double preis = 10.0;

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

        textFieldPreis.setText(preis + " €");

    }


    public void zeigeWarenkorb() {
        JFrame bestelluebersichtFrame = new JFrame("Warenkorb");


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JScrollPane scrollpane = new JScrollPane();
        panel.add(scrollpane);
        String fuer = JtextFieldFuer.getText();
        String gravur = comboBoxGravur1.getSelectedItem().toString() + "." + comboBoxGravur2.getSelectedItem().toString();
        String cover = "";
        String preis = textFieldPreis.getText();


        if (rBHard.isSelected()) {
            cover = "Hard Cover";
        } else if (rBSoft.isSelected())
            cover = "Soft Cover";
        if (cover.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bitte einen Covertyp auswählen");
            return;
        }

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

        Buch buch = new Buch(fuer, gravur, cover, storyline, ch1name, ch1alter, ch1geschlecht,
                ch1magischeKraefte, ch2name, ch2alter, ch2geschlecht, ch2magischeKraefte, preis);
        buecherListe.add(buch);

        /*String magischeKraefte = "";
        if (checkBox1MK.isSelected()) {
            magischeKraefte += "1";
        }
        if (checkBox2MK.isSelected()) {
            if (!magischeKraefte.isEmpty()) {
                magischeKraefte += ", "; // Komma hinzufügen, wenn bereits eine Kraft vorhanden ist
            }
            magischeKraefte += "2";
        }

        // Wenn keine magischen Kräfte ausgewählt wurden 
        if (magischeKraefte.isEmpty()) {
            magischeKraefte = "Keine";
        }


        panel.add(new JLabel("Bestellübersicht"));
        panel.add(new JLabel("Für:" + fuer));
        panel.add(new JLabel("Gravur:" + gravur));
        panel.add(new JLabel("Cover:" + cover));
        panel.add(new JLabel("Storyline:" + storyline));
        panel.add(new JLabel("Magische Kräfte: " + magischeKraefte));
        panel.add(new JLabel("Preis:" + preis));*/
        scrollpane.add(ausgabefeld);
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

    }





    public static void main(String[] args) {
       /* SwingUtilities.invokeLater(()-> {

            JFrame frame = new JFrame("Personalisierte Buchpreisberechnung");
            PersonalisiertesBuch personalisiertesBuch = new PersonalisiertesBuch();

            frame.setContentPane(personalisiertesBuch.panelMain);

            frame.pack();
            frame.setVisible(true);
        });*/
        new PersonalisiertesBuch();
    }


}