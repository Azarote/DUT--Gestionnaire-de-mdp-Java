package fr.passwordmanager.view;

import fr.passwordmanager.controller.ProcessingAndHashing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * <p>Classe qui gère la fenêtre pour créer un mot de passe global</p>
 *
 * @author Matteo DUFOUR
 * @author Matteo MUNOZ
 */
public class SignUpWindow extends JFrame {
    /**
     * Champ pour saisir un mot de passe global
     */
    private final JPasswordField passwordField;

    /**
     * Champ pour confirmer le mot de passe
     */
    private final JPasswordField passwordFieldConfirmation;

    /**
     * <p>Constructeur de la classe SignUpWindow</p>
     */
    public SignUpWindow(){
        //Définition des propriétés de la fenêtre
        JFrame frame = new JFrame();
        this.setTitle("Enregistrer un mot de passe global");
        this.setSize(600,370);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Termine l'application à la fermeture de la fenêtre
        this.setLocationRelativeTo(null); //Centre la fenêtre
        this.setResizable(false); //Empêche le redimensionnement de la fenêtre
        this.setLayout(null);

        ImageIcon icon = new ImageIcon("../general/images/cadenas.png");//Icône
        this.setIconImage(icon.getImage());

        //Label demandant d'entrer un nouveau mot de passe
        JLabel newPassword = new JLabel("Mot de passe global");
        newPassword.setForeground(Color.WHITE);
        newPassword.setBounds(150,30,290,25);
        this.add(newPassword);

        //Champ de texte pour saisir le nouveau mot de passe
        passwordField = new JPasswordField();
        passwordField.setBounds(150,50,290,25);
        this.add(passwordField);

            /*
             * Ajoute un KeyListener sur passwordField
             * Si l'utilisateur se trouve dans le champ passwordField et appuie sur ENTREE
             * alors l'utilisateur est déplacé au champ suivant : passwordFieldConfirmation
             */
            passwordField.addKeyListener(new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        passwordFieldConfirmation.requestFocusInWindow();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) { }

                @Override
                public void keyTyped(KeyEvent e) { }
            });

        //Label demandant de confirmer le nouveau mot de passe
        JLabel newPasswordConfirmation = new JLabel("Confirmer le mot de passe");
        newPasswordConfirmation.setForeground(Color.WHITE);
        newPasswordConfirmation.setBounds(150,80,300,25);
        this.add(newPasswordConfirmation);

        //Champ de texte pour confirmer le nouveau mot de passe
        passwordFieldConfirmation = new JPasswordField();
        passwordFieldConfirmation.setBounds(150,100,290,25);
        this.add(passwordFieldConfirmation);

            /*
             * Ajoute un KeyListener sur passwordFieldConfirmation
             * Appelle la fonction qui traite les mots de passe si on appuie sur ENTREE
             */
            passwordFieldConfirmation.addKeyListener(new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        char[] pwd1 = passwordField.getPassword();//Récupère la saisie dans le premier champ
                        char[] pwd2 = passwordFieldConfirmation.getPassword();//Récupère la saisie dans le deuxième champ

                        int result = ProcessingAndHashing.passwordProcessing(pwd1,pwd2);//Appelle la fonction de traitement du mdp

                        if(result == 0) {
                            dispose();
                            new LoginWindow();
                        }
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) { }

                @Override
                public void keyTyped(KeyEvent e) { }
            });

        //Bouton VALIDER pour valider la saisie des mdp
        JButton validateButton = new JButton("Valider");
        validateButton.setBounds(290,140,150,25);
        this.add(validateButton);

            /*
             * Ajoute un ActionListener sur validateButton
             * Appelle la fonction qui traite les mots de passe si on clique sur VALIDER
             */
            validateButton.addActionListener(e -> {
                try{
                    char[] pwd1 = passwordField.getPassword();//Récupère la saisie dans le premier champ
                    char[] pwd2 = passwordFieldConfirmation.getPassword();//Récupère la saisie dans le deuxième champ

                    int result = ProcessingAndHashing.passwordProcessing(pwd1,pwd2);//Appelle la fonction de traitement du mdp

                    if(result == 0) {
                        dispose();
                        new LoginWindow();
                    }
                }
                catch(Exception ee)
                {
                    System.err.println();
                }
            });

        //Label affichant les critères à respecter pour un mot de passe valide
        JLabel info = new JLabel("", SwingConstants.CENTER);
        info.setText("<html><div style=\"text-align:center;\"><strong>ATTENTION</strong><br/>Le mot de passe doit contenir 8 caractères minimum dont :<br/>- au moins 6 lettres<br/>- au moins 2 chiffres</div></html>");
        info.setFont(new Font("Helvetica", Font.PLAIN, 17));
        info.setForeground(Color.RED);
        info.setBounds(-6,200,600,100);
        this.add(info);

        //Image pour le fond de la fenêtre
        ImageIcon imgBackground = new ImageIcon("../general/images/background/backgroundSignUp.png");
        JLabel background = new JLabel("",imgBackground,JLabel.CENTER);
        background.setBounds(0,0,600,370);
        this.add(background);

        this.setVisible(true);
    }
}
