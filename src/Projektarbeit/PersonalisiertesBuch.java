package Projektarbeit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalisiertesBuch extends JFrame {

    private JPanel panelMain;

    private JTextField textFieldCh1Name;
    private JTextField textFieldCh2Name;
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
    private JLabel JLabelCh2Alter;
    private JLabel JLabelCh1Alter;
    private JLabel JLabelCh1Geschlecht;
    private JLabel JLabelStoryline;
    private JLabel JLabelFuer;
    private JComboBox comboBoxStoryline;
    private JButton buttonBestellen;
    private JLabel JLabelGeschenk;
    private JTextField JtextFieldFuer;
    private JTextField textFieldPreis;
    private JTextField textFieldWrenkorb;
    private JButton buttonPreis;
    private JButton buttonWarenkorb;
    private JRadioButton buttonCover;
    private JRadioButton ButtonCover2;
    private JLabel JLabelCh2Geschlecht;
    private JComboBox comboBoxGravur1;
    private JComboBox comboBoxGravur2;
    private JPanel frame;
    private JCheckBox checkBox1MK;
    private JCheckBox checkBox2MK;
    private JComboBox comboBox1;
    private JComboBox comboBox3;


    public PersonalisiertesBuch(){


        setTitle("Personalisiere dein Buch");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setContentPane(frame);
        setVisible(true);



        ButtonGroup coverGroup = new ButtonGroup();

        coverGroup.add(rBHard);
        coverGroup.add(rBSoft);


        buttonPreis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                berechnePreis();

            }
        });

        buttonBestellen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zeigeBestelluebersicht();
                buttonBestellen.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                    }
                });
            }
        });



        JLabelGeschenk.setVisible(false);

        buttonBestellen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabelGeschenk.setVisible(true);
            }
        });
    }
    private void berechnePreis(){
        double preis = 10.0;

        if (rBHard.isSelected()){
            preis += 5.0;
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
    private void zeigeBestelluebersicht() {
        JFrame bestelluebersichtFrame = new JFrame("Bestellübersicht");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        String nameFuer = JtextFieldFuer.getText();
        String gravur1 = (String) comboBoxGravur1.getSelectedItem();
        String gravur2 = (String) comboBoxGravur2.getSelectedItem();
        String covertyp = rBHard.isSelected() ? "Hard Cover" : "Soft Cover";
        String storyline = (String) comboBoxStoryline.getSelectedItem();
        String preis = textFieldPreis.getText();
        String magischeKraefte = "";
        if (checkBox1MK.isSelected()) {
            magischeKraefte += "Magische Kraft 1";
        }
        if (checkBox2MK.isSelected()) {
            if (!magischeKraefte.isEmpty()) {
                magischeKraefte += ", "; // Komma hinzufügen, wenn bereits eine Kraft vorhanden ist
            }
            magischeKraefte += "Magische Kraft 2";
        }

        // Wenn keine magischen Kräfte ausgewählt wurden 
        if (magischeKraefte.isEmpty()) {
            magischeKraefte = "Keine";
        }




        panel.add(new JLabel("Bestellübersicht"));
        panel.add(new JLabel("Gravur:" + gravur1 +  "." + gravur2));
        panel.add(new JLabel("Cover:" + covertyp));
        panel.add(new JLabel("Storyline:" + storyline));
        panel.add(new JLabel("Magische Kräfte: "+ magischeKraefte));
        panel.add(new JLabel("Preis:" + preis));

        JButton schliessenButton = new JButton("Schließen");
        schliessenButton.addActionListener(e -> bestelluebersichtFrame.dispose());
        panel.add(schliessenButton);

        bestelluebersichtFrame.add(panel);
        bestelluebersichtFrame.setSize(300,200);
        bestelluebersichtFrame.setLocationRelativeTo(null);
        bestelluebersichtFrame.setVisible(true);

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