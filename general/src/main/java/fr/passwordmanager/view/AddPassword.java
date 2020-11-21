package fr.passwordmanager.view;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;

public class AddPassword extends JFrame {
    private ImageIcon info = new ImageIcon("../general/images/icons/info.png");

    public AddPassword() {
        JFrame frame = new JFrame();
        this.setTitle("Ajouter un mot de passe");
        this.setSize(500,450);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); //Centre la fenêtre
        this.setResizable(false); //Empêche le redimensionnement de la fenêtre
        this.setLayout(null);

        ImageIcon icon = new ImageIcon("../general/images/cadenas.png");//Icône
        this.setIconImage(icon.getImage());

        UIManager.put("ToolTip.background", Color.white);

        //Label demandant d'entrer le titre
        JLabel labelTitre = new JLabel("");
        labelTitre.setText("<html>Titre : <span style=\"color:red;\">*</span></html>");
        labelTitre.setBounds(5,5,100,25);
        this.add(labelTitre);

            //Champ de texte pour saisir le titre
            JTextField fieldTitre = new JTextField();
            fieldTitre.setBounds(100,5,300,25);
            this.add(fieldTitre);

            //Icone astuce titre
            JLabel labelInfo = new JLabel("",info,JLabel.CENTER);
            labelInfo.setBounds(405,10,15,15);
            labelInfo.setToolTipText("Peut être le nom du site (ex: Youtube)");
            this.add(labelInfo);

        //Label demandant d'entrer le pseudo
        JLabel labelPseudo = new JLabel("");
        labelPseudo.setText("<html>Pseudo : <span style=\"color:red;\">*</span></html>");
        labelPseudo.setBounds(5,35,100,25);
        this.add(labelPseudo);

            //Champ de texte pour saisir le pseudo
            JTextField fieldPseudo = new JTextField();
            fieldPseudo.setBounds(100,35,300,25);
            this.add(fieldPseudo);

            //Icone astuce Pseudo
            JLabel labelInfo3 = new JLabel("",info,JLabel.CENTER);
            labelInfo3.setBounds(405,40,15,15);
            labelInfo3.setToolTipText("Peut également être une adresse mail");
            this.add(labelInfo3);

        //Label demandant d'entrer le mdp
        JLabel labelMDP = new JLabel("");
        labelMDP.setText("<html>Mot de passe : <span style=\"color:red;\">*</span></html>");
        labelMDP.setBounds(5,65,100,25);
        this.add(labelMDP);

            //Champ de texte pour saisir le mdp
            JPasswordField fieldMDP = new JPasswordField();
            fieldMDP.setBounds(100,65,300,25);
            this.add(fieldMDP);

        //Label demandant d'entrer l'URL
        JLabel labelURL = new JLabel("URL :");
        labelURL.setBounds(5,95,100,25);
        this.add(labelURL);

            //Champ de texte pour saisir l'URL
            JTextField fieldURL = new JTextField();
            fieldURL.setBounds(100,95,300,25);
            this.add(fieldURL);

            //Icone astuce URL
            JLabel labelInfo2 = new JLabel("",info,JLabel.CENTER);
            labelInfo2.setBounds(405,100,15,15);
            labelInfo2.setToolTipText("Le lien du site");
            this.add(labelInfo2);

        //Label demandant d'entrer la date d'expiration
        JLabel labelDate = new JLabel("Date d'expiration : ");
        labelDate.setBounds(5,125,100,25);
        this.add(labelDate);

            //Champ de texte pour saisir la date d'expiration
            UtilDateModel model = new UtilDateModel();
            JDatePanelImpl datePanel = new JDatePanelImpl(model);
            JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
            datePicker.setBounds(100,130,300,25);
            this.add(datePicker);

        //Label demandant d'entrer la description
        JLabel labelDescription = new JLabel("Description : ");
        labelDescription.setBounds(5,155,100,25);
        this.add(labelDescription);

            //Champ de texte pour saisir la description
            JTextArea areaDescription = new JTextArea();
            JScrollPane paneDescription = new JScrollPane(areaDescription);
            paneDescription.setBounds(100,160,300,100);
            this.add(paneDescription);

        //Label remarque
        JLabel labelRq = new JLabel("");
        labelRq.setText("<html><span style=\"color:red; text-align:center;\"><em>Les champs marqués d'une * sont obligatoires</em></span></html>");
        labelRq.setBounds(5,265,300,25);
        this.add(labelRq);

        this.setVisible(true);
    }
}
