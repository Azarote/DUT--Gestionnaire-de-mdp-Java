package fr.passwordmanager.view;

import fr.passwordmanager.controller.ManagePassword;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;

/**
 * <p>Classe qui gère la fenêtre pour ajouter un mot de passe dans le Gestionnaire</p>
 *
 * @author Matteo DUFOUR
 * @author Matteo MUNOZ
 */
public class AddPassword extends JDialog {
    /**
     * Icône pour ToolTipText
     */
    private ImageIcon info = new ImageIcon(getClass().getResource("/icons/info.png"));

    /**
     * Instance du contrôleur
     */
    private final ManagePassword passwordController = new ManagePassword();

    /**
     * Champ pour saisir le titre du mot de passe
     */
    private final JTextField fieldTitre;

    /**
     * Champ pour saisir le pseudo/adresse mail
     */
    private final JTextField fieldPseudo;

    /**
     * Champ pour saisir le mot de passe
     */
    private final JPasswordField fieldMDP;

    /**
     * Champ pour saisir l'URL
     */
    private final JTextField fieldURL;

    /**
     * <p>Constructeur de la classe AddPassword</p>
     */
    public AddPassword() {
        //Définition des propriétés de la fenêtre
        JFrame frame = new JFrame();
        this.setModal(true);
        this.setTitle("Ajouter un mot de passe");
        this.setSize(480,450);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);//Centre la fenêtre
        this.setResizable(false);//Empêche le redimensionnement de la fenêtre
        this.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/cadenas.png"));//Icône
        this.setIconImage(icon.getImage());

        UIManager.put("ToolTip.background", Color.white);//Rend le fond des bulles d'aide blanc

        //Label demandant d'entrer le titre
        JLabel labelTitre = new JLabel("");
        labelTitre.setText("<html>Titre : <span style=\"color:red;\">*</span></html>");
        labelTitre.setBounds(5,5,100,35);
        this.add(labelTitre);

            //Champ de texte pour saisir le titre
            fieldTitre = new JTextField();
            fieldTitre.setBounds(135,5,300,35);
            this.add(fieldTitre);

            //Icone astuce titre
            JLabel labelInfoTitre = new JLabel("",info,JLabel.CENTER);
            labelInfoTitre.setBounds(440,15,15,15);
            labelInfoTitre.setToolTipText("Peut être le nom du site (ex: Youtube)");
            this.add(labelInfoTitre);

            /*
             * Ajoute un KeyListener sur fieldTitre
             * Si l'utilisateur se trouve dans le champ fieldTitre et appuie sur ENTREE
             * alors l'utilisateur est déplacé au champ suivant : fieldPseudo
             */
            fieldTitre.addKeyListener(new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        fieldPseudo.requestFocusInWindow();//L'utilisateur est déplacé au champ suivant
                    }
                }

                @Override
                public void keyTyped(KeyEvent e) { }

                @Override
                public void keyReleased(KeyEvent e) { }
            });

        //Label demandant d'entrer le pseudo
        JLabel labelPseudo = new JLabel("");
        labelPseudo.setText("<html>Pseudo : <span style=\"color:red;\">*</span></html>");
        labelPseudo.setBounds(5,50,100,35);
        this.add(labelPseudo);

            //Champ de texte pour saisir le pseudo
            fieldPseudo = new JTextField();
            fieldPseudo.setBounds(135,50,300,35);
            this.add(fieldPseudo);

            //Icone astuce Pseudo
            JLabel labelInfoPseudo = new JLabel("",info,JLabel.CENTER);
            labelInfoPseudo.setBounds(440,60,15,15);
            labelInfoPseudo.setToolTipText("Peut également être une adresse mail");
            this.add(labelInfoPseudo);

            /*
             * Ajoute un KeyListener sur fieldPseudo
             * Si l'utilisateur se trouve dans le champ fieldPseudo et appuie sur ENTREE
             * alors l'utilisateur est déplacé au champ suivant : fieldMDP
             */
            fieldPseudo.addKeyListener(new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        fieldMDP.requestFocusInWindow();//L'utilisateur est déplacé au champ suivant
                    }
                }

                @Override
                public void keyTyped(KeyEvent e) { }

                @Override
                public void keyReleased(KeyEvent e) { }
            });

        //Label demandant d'entrer le mdp
        JLabel labelMDP = new JLabel("");
        labelMDP.setText("<html>Mot de passe : <span style=\"color:red;\">*</span></html>");
        labelMDP.setBounds(5,95,125,35);
        this.add(labelMDP);

            //Champ de texte pour saisir le mdp
            fieldMDP = new JPasswordField();
            fieldMDP.setBounds(135,95,300,35);
            this.add(fieldMDP);

            /*
             * Ajoute un KeyListener sur fieldMDP
             * Si l'utilisateur se trouve dans le champ fieldMDP et appuie sur ENTREE
             * alors l'utilisateur est déplacé au champ suivant : fieldURL
             */
            fieldMDP.addKeyListener(new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        fieldURL.requestFocusInWindow();//L'utilisateur est déplacé au champ suivant
                    }
                }

                @Override
                public void keyTyped(KeyEvent e) { }

                @Override
                public void keyReleased(KeyEvent e) { }
            });

        //Label demandant d'entrer l'URL
        JLabel labelURL = new JLabel("URL :");
        labelURL.setBounds(5,140,100,35);
        this.add(labelURL);

            //Champ de texte pour saisir l'URL
            fieldURL = new JTextField();
            fieldURL.setBounds(135,140,300,35);
            this.add(fieldURL);

            //Icone astuce URL
            JLabel labelInfoURL = new JLabel("",info,JLabel.CENTER);
            labelInfoURL.setBounds(440,150,15,15);
            labelInfoURL.setToolTipText("Le lien du site");
            this.add(labelInfoURL);

        //Label demandant d'entrer la date d'expiration
        JLabel labelDate = new JLabel("Date d'expiration : ");
        labelDate.setBounds(5,185,135,25);
        this.add(labelDate);

            //Champ de texte pour saisir la date d'expiration
            String datePattern = "dd-MM-yyyy";
            SimpleDateFormat dateformatter = new SimpleDateFormat(datePattern);

            UtilDateModel model = new UtilDateModel();
            JDatePanelImpl datePanel = new JDatePanelImpl(model);
            JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);

            datePicker.setBounds(135,185,300,40);
            this.add(datePicker);

        //Label demandant d'entrer la description
        JLabel labelDescription = new JLabel("Description : ");
        labelDescription.setBounds(5,225,100,25);
        this.add(labelDescription);

            //Champ de texte pour saisir la description
            JTextArea areaDescription = new JTextArea();
            JScrollPane paneDescription = new JScrollPane(areaDescription);//On met le TextArea dans le ScrollPane pour pouvoir scroller
            paneDescription.setBounds(135,225,300,100);
            this.add(paneDescription);

        //Label remarque
        JLabel labelRq = new JLabel("");
        labelRq.setText("<html><span style=\"color:red; text-align:center;\"><em>Les champs marqués d'une * sont obligatoires</em></span></html>");
        labelRq.setBounds(135,335,300,25);
        this.add(labelRq);

        //Bouton pour valider la saisie
        JButton validation = new JButton("Valider");
        validation.setBounds(230,365,100,25);
        this.add(validation);

            /*
             * Ajoute un MouseListener sur validation
             * Si l'utilisateur clique sur VALIDER
             * on vérifie que les champs obligatoires soient remplis
             * Si oui, on lance le processus d'ajout de mot de passe
             */
            validation.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    char[] pwdWritten = fieldMDP.getPassword();

                    if(fieldTitre.getText().isEmpty())
                    {
                        DialogMessage.messageDialog("Aucun titre n'a été saisi");//Champ titre vide
                        fieldTitre.requestFocusInWindow();
                    }
                    else if(fieldPseudo.getText().isEmpty())
                    {
                        DialogMessage.messageDialog("Aucun pseudo ou adresse mail n'a été saisi(e)");//Champ pseudo vide
                        fieldPseudo.requestFocusInWindow();
                    }
                    else if(pwdWritten.length<=0)
                    {
                        DialogMessage.messageDialog("Aucun mot de passe n'a été saisi");//Champ mdp vide
                        fieldMDP.requestFocusInWindow();
                    }
                    else if(datePicker.getModel().getValue() == null)
                    {
                        ManagePassword.AddPasswordProcessingIfDateEmpty(fieldTitre.getText(),fieldPseudo.getText(),fieldMDP.getPassword(),fieldURL.getText(),areaDescription.getText());
                        ManagePassword.ListSaving();
                        dispose();
                    }
                    else
                    {
                        ManagePassword.AddPasswordProcessing(fieldTitre.getText(),fieldPseudo.getText(),fieldMDP.getPassword(),fieldURL.getText(),areaDescription.getText(),datePicker.getModel().getYear(),datePicker.getModel().getMonth(),datePicker.getModel().getDay());
                        ManagePassword.ListSaving();
                        dispose();
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) { }

                @Override
                public void mouseReleased(MouseEvent e) { }

                @Override
                public void mouseEntered(MouseEvent e) { }

                @Override
                public void mouseExited(MouseEvent e) { }
            });

        //Bouton pour annuler la saisie
        JButton cancel = new JButton("Annuler");
        cancel.setBounds(340,365,100,25);
        this.add(cancel);

            //Si l'utilisateur clique sur Annuler
            cancel.addActionListener(e -> dispose());

        this.setVisible(true);
    }
}
