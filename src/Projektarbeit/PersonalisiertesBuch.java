package Projektarbeit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalisiertesBuch {

    private JPanel panelMain;

    private JTextField textFieldCh1Name;
    private JTextField textFieldCh2Name;
    private JTextField textFieldCh1Alter;
    private JTextField textField6;
    private JComboBox comboBoxCh1Geschlecht;
    private JComboBox comboBox2;

    private JRadioButton rBHard;
    private JRadioButton rBSoft;
    private JLabel JlabelCover;
    private JLabel JLabelGravur;
    private JLabel JLabelCh1;
    private JLabel JLabelCh2;
    private JLabel JLabelCh1Name;
    private JLabel JLabelCh2Name;
    private JLabel JLabelCh1Alter;
    private JLabel JLabelCh2Alter;
    private JLabel JLabelCh1Geschlecht;
    private JLabel JLabelStoryline;
    private JComboBox comboBoxStoryline;
    private JButton buttonBestellen;
    private JLabel JLabelGeschenk;
    private JTextField textFieldLesezeichen;
    private JTextField JtextFieldFuer;
    private JTextField textFieldPreis;
    private JTextField textFieldWrenkorb;
    private JButton buttonPreis;
    private JButton buttonWarenkorb;
    private JRadioButton buttonCover;
    private JRadioButton ButtonCover2;
    private JLabel JLabelCh2Geschlecht;
    private JComboBox comboBox1;
    private JComboBox comboBox3;
    private JPanel frame;
    private JCheckBox checkBox1MK;
    private JCheckBox checkBox2MK;


    public PersonalisiertesBuch(){

        rBHard = new JRadioButton("Hard Cover");
        rBSoft = new JRadioButton(" Soft Cover");



        ButtonGroup coverGroup = new ButtonGroup();

        coverGroup.add(rBHard);
        coverGroup.add(rBSoft);

        checkBox1MK = new JCheckBox("Magische Kraft 1");
        checkBox2MK = new JCheckBox("Magische Kraft 2");


        for (char c = 'A'; c <= 'Z'; c++) {
            comboBox1.addItem(String.valueOf(c));
            comboBox3.addItem(String.valueOf(c));
        }

        comboBox1.setSelectedIndex(0);
        comboBox3.setSelectedIndex(0);



        buttonPreis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                berechnePreis();

            }
        });
        textFieldPreis.setEditable(false);

        buttonBestellen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zeigeBestellübersicht();
                buttonBestellen.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                    }
                });
            }
        });


    }
    private void berechnePreis(){
        double preis = 10.0;

        if (rBHard.isSelected()){
            preis += 5.0;
        }
        String gravur1 = (String) comboBox1.getSelectedItem();
        String gravur2 = (String) comboBox3.getSelectedItem();

        String gravur = gravur1 + "." + gravur2;

        if (!gravur1.isEmpty() || !gravur2.isEmpty()) {
            preis += 2.0;
        }
        String storyline = (String) comboBoxStoryline.getSelectedItem();
        if ("Comedy".equals(storyline)){
            preis += 4.0;
        }
        if (checkBox1MK.isSelected()) {
            preis += 3.0;
        }
        if (checkBox2MK.isSelected()) {
            preis += 3.0;
        }

        textFieldPreis.setText( preis + " €");

    }
    private void zeigeBestellübersicht() {
        JFrame bestellübersichtFrame = new JFrame("Bestellübersicht");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        String nameFür = JtextFieldFuer.getText();
        String gravur1 = (String) comboBox1.getSelectedItem();
        String gravur2 = (String) comboBox3.getSelectedItem();
        String covertyp = rBHard.isSelected() ? "Hard Cover" : "Soft Cover";
        String storyline = (String) comboBoxStoryline.getSelectedItem();
        String preis = textFieldPreis.getText();
        String magischeKräfte = "";
        if (checkBox1MK.isSelected()) {
            magischeKräfte += "Magische Kraft 1";
        }
        if (checkBox2MK.isSelected()) {
            if (!magischeKräfte.isEmpty()) {
                magischeKräfte += ", "; // Komma hinzufügen, wenn bereits eine Kraft vorhanden ist
            }
            magischeKräfte += "Magische Kraft 2";
        }

        // Wenn keine magischen Kräfte ausgewählt wurden
        if (magischeKräfte.isEmpty()) {
            magischeKräfte = "Keine";
        }






        panel.add(new JLabel("Bestellübersicht"));
        panel.add(new JLabel("Für:" + nameFür));
        panel.add(new JLabel("Gravur:" + gravur1 +  "." + gravur2));
        panel.add(new JLabel("Cover:" + covertyp));
        panel.add(new JLabel("Storyline:" + storyline));
        panel.add(new JLabel("Magische Kräfte: "+ magischeKräfte));
        panel.add(new JLabel("Preis:" + preis));

        JButton schließenButton = new JButton("Schließen");
        schließenButton.addActionListener(e -> bestellübersichtFrame.dispose());
        panel.add(schließenButton);

        bestellübersichtFrame.add(panel);
        bestellübersichtFrame.setSize(300,200);
        bestellübersichtFrame.setLocationRelativeTo(null);
        bestellübersichtFrame.setVisible(true);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> {

            JFrame frame = new JFrame("Personalisierte Buchpreisberechnung");
            PersonalisiertesBuch personalisiertesBuch = new PersonalisiertesBuch();

            frame.setContentPane(personalisiertesBuch.panelMain);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }


}