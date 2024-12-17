package Projektarbeit;

import javax.swing.*;



public class PersonalisiertesBuch {

    private JTextField textFieldFür;
    private JTextField textFieldGravur;

    private JRadioButton rBHard;
    private JRadioButton rBSoft;


    public PersonalisiertesBuch(){

        rBHard = new JRadioButton("Hard Cover");
        rBSoft = new JRadioButton(" Soft Cover");


        ButtonGroup coverGroup = new ButtonGroup();

        coverGroup.add(rBHard);
        coverGroup.add(rBSoft);

    }

    private JTextField textFieldCh1Name;
    private JTextField textFieldCh2Name;
    private JTextField textFieldCh1Alter;
    private JTextField textField6;
    private JComboBox comboBoxCh1Geschlecht;
    private JComboBox comboBox2;

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
    private JComboBox comboBoxStoryline;
    private JButton buttonBestellen;
    private JLabel JLabelGeschenk;
    private JTextField textFieldLesezeichen;
    private JTextField textFieldPreis;
    private JTextField textFieldWrenkorb;
    private JButton buttonPreis;
    private JButton buttonWarenkorb;
    private JRadioButton buttonCover;
    private JRadioButton ButtonCover2;


}
