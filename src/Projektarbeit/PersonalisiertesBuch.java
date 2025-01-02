package Projektarbeit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PersonalisiertesBuch {

    private JPanel panelMain;

    private JTextField textFieldFür;
    private JTextField textFieldGravur;
    private JRadioButton rBHard;
    private JRadioButton rBSoft;
    private JTextField textFieldCh1Name;
    private JTextField textFieldCh2Name;
    private JTextField textFieldCh1Alter;
    private JTextField textField6;
    private JComboBox comboBoxCh1Geschlecht;
    private JComboBox comboBox2;
    private JTextField TextFieldGravur;
    private JComboBox<String>comboBoxStoryline;
    private JLabel labelPreis;
    private JRadioButton RBM1;
    private JRadioButton RBM2;
    private JLabel JLabelName;
    private JLabel JlabelCover;
    private JLabel JLabelFür;
    private JLabel JLabelGravur;
    private JLabel JLabelCh1;
    private JLabel JLabelCh2;
    private JLabel JLabelCh1Name;
    private JLabel JLabelCh2Name;
    private JLabel JLabelCh1Alter;
    private JLabel JLabelCh2Alter;
    private JLabel JLabelCh1Geschlecht;
    private JLabel JLabelStoryline;
    private JButton buttonBestellen;
    private JLabel JLabelGeschenk;
    private JTextField textFieldLesezeichen;
    private JButton buttonPreis;
    private JButton buttonWarenkorb;
    private JTextField textFieldWrenkorb;
    private JRadioButton buttonCover;
    private JRadioButton ButtonCover2;
    private JTextField textFieldPreis;




    public PersonalisiertesBuch(){

        rBHard = new JRadioButton("Hard Cover");
        rBSoft = new JRadioButton(" Soft Cover");



        ButtonGroup coverGroup = new ButtonGroup();

        coverGroup.add(rBHard);
        coverGroup.add(rBSoft);



        buttonPreis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                berechnePreis();

            }
        });
textFieldPreis.setEditable(false);
    }
 private void berechnePreis(){
        double preis = 10.0;

        if (rBHard.isSelected()){
            preis += 5.0;
        }
        String gravur = textFieldGravur.getText();
        if (!gravur.isEmpty()){
            preis += 2.0;
        }
        String storyline = (String) comboBoxStoryline.getSelectedItem();
        if ("Comedy".equals(storyline)){
            preis += 4.0;
        }
        textFieldPreis.setText( preis + " €");

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












