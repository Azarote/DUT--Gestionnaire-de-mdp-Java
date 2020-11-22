package fr.passwordmanager.view;

import fr.passwordmanager.controller.HashingAndProcessing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpWindow extends JFrame {
    private final JPasswordField passwordField;
    private final JPasswordField passwordFieldConfirmation;

    public SignUpWindow(){
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

            //Si l'utilisateur se trouve dans le champ passwordField et appuye sur ENTREE
            passwordField.addKeyListener(new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        passwordFieldConfirmation.requestFocusInWindow();//L'utilisateur est déplacé au champ suivant
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

            //Appelle la fonction qui traite les mdps si on appuye sur "Entrée"
            passwordFieldConfirmation.addKeyListener(new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        char[] pwd1 = passwordField.getPassword();//Récupère la saisie dans le premier champ
                        char[] pwd2 = passwordFieldConfirmation.getPassword();//Récupère la saisie dans le deuxième champ

                        int result = HashingAndProcessing.passwordProcessing(pwd1,pwd2);//Appelle la fonction de traitement du mdp

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

        //Bouton pour valider la saisie des mdp
        JButton validateButton = new JButton("Valider");
        validateButton.setBounds(290,140,150,25);
        this.add(validateButton);

            //Appelle la fonction qui traite les mdps si on clique sur "Valider"
            validateButton.addActionListener(e -> {
                try{
                    char[] pwd1 = passwordField.getPassword();//Récupère la saisie dans le premier champ
                    char[] pwd2 = passwordFieldConfirmation.getPassword();//Récupère la saisie dans le deuxième champ

                    int result = HashingAndProcessing.passwordProcessing(pwd1,pwd2);//Appelle la fonction de traitement du mdp

                    if(result == 0) {
                        dispose();
                        new LoginWindow();
                    }
                }
                catch(Exception ex)
                {
                    System.err.println(ex);
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
