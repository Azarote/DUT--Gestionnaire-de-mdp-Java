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
        this.setSize(480,390);
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
            fieldTitre.setBounds(135,5,300,25);
            this.add(fieldTitre);

            //Icone astuce titre
            JLabel labelInfo = new JLabel("",info,JLabel.CENTER);
            labelInfo.setBounds(440,10,15,15);
            labelInfo.setToolTipText("Peut être le nom du site (ex: Youtube)");
            this.add(labelInfo);

        //Label demandant d'entrer le pseudo
        JLabel labelPseudo = new JLabel("");
        labelPseudo.setText("<html>Pseudo : <span style=\"color:red;\">*</span></html>");
        labelPseudo.setBounds(5,35,100,25);
        this.add(labelPseudo);

            //Champ de texte pour saisir le pseudo
            JTextField fieldPseudo = new JTextField();
            fieldPseudo.setBounds(135,35,300,25);
            this.add(fieldPseudo);

            //Icone astuce Pseudo
            JLabel labelInfo3 = new JLabel("",info,JLabel.CENTER);
            labelInfo3.setBounds(440,40,15,15);
            labelInfo3.setToolTipText("Peut également être une adresse mail");
            this.add(labelInfo3);

        //Label demandant d'entrer le mdp
        JLabel labelMDP = new JLabel("");
        labelMDP.setText("<html>Mot de passe : <span style=\"color:red;\">*</span></html>");
        labelMDP.setBounds(5,65,125,25);
        this.add(labelMDP);

            //Champ de texte pour saisir le mdp
            JPasswordField fieldMDP = new JPasswordField();
            fieldMDP.setBounds(135,65,300,25);
            this.add(fieldMDP);

        //Label demandant d'entrer l'URL
        JLabel labelURL = new JLabel("URL :");
        labelURL.setBounds(5,95,100,25);
        this.add(labelURL);

            //Champ de texte pour saisir l'URL
            JTextField fieldURL = new JTextField();
            fieldURL.setBounds(135,95,300,25);
            this.add(fieldURL);

            //Icone astuce URL
            JLabel labelInfo2 = new JLabel("",info,JLabel.CENTER);
            labelInfo2.setBounds(440,100,15,15);
            labelInfo2.setToolTipText("Le lien du site");
            this.add(labelInfo2);

        //Label demandant d'entrer la date d'expiration
        JLabel labelDate = new JLabel("Date d'expiration : ");
        labelDate.setBounds(5,130,135,25);
        this.add(labelDate);

            //Champ de texte pour saisir la date d'expiration
            UtilDateModel model = new UtilDateModel();
            JDatePanelImpl datePanel = new JDatePanelImpl(model);
            JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
            datePicker.setBounds(135,130,300,25);
            this.add(datePicker);

        //Label demandant d'entrer la description
        JLabel labelDescription = new JLabel("Description : ");
        labelDescription.setBounds(5,175,100,25);
        this.add(labelDescription);

            //Champ de texte pour saisir la description
            JTextArea areaDescription = new JTextArea();
            JScrollPane paneDescription = new JScrollPane(areaDescription);//On met le TextArea dans le ScrollPane pour pouvoir scroller
            paneDescription.setBounds(135,175,300,100);
            this.add(paneDescription);

        //Label remarque
        JLabel labelRq = new JLabel("");
        labelRq.setText("<html><span style=\"color:red; text-align:center;\"><em>Les champs marqués d'une * sont obligatoires</em></span></html>");
        labelRq.setBounds(135,285,300,25);
        this.add(labelRq);

        //Bouton pour valider la saisie
        JButton validation = new JButton("Valider");
        validation.setBounds(230,315,100,25);
        this.add(validation);

        //Bouton pour annuler la saisie
        JButton cancel = new JButton("Annuler");
        cancel.setBounds(340,315,100,25);
        this.add(cancel);

        this.setVisible(true);
    }
}
