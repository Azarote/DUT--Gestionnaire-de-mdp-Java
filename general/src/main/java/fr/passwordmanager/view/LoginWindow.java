package fr.passwordmanager.view;

import fr.passwordmanager.controller.LoginController;
import fr.passwordmanager.controller.Singleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * <p>Classe qui gère la fenêtre pour se connecter au Gestionnaire</p>
 *
 * @author Matteo DUFOUR
 * @author Matteo MUNOZ
 */
public class LoginWindow extends JFrame {
    /**
     * Champ pour saisir le mot de passe global
     */
    private final JPasswordField enterPasswordField;

    /**
     * <p>Constructeur de la classe LoginWindow</p>
     */
    public LoginWindow(){
        //Définition des propriétés de la fenêtre
        JFrame frame = new JFrame();
        this.setTitle("Authentification");//Titre
        this.setSize(500,265);//Dimensions
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Termine l'application à la fermeture de la fenêtre
        this.setLocationRelativeTo(null); //Centre la fenêtre
        this.setResizable(false); //Empêche le redimensionnement de la fenêtre
        this.setLayout(null);

        ImageIcon icon = new ImageIcon("../general/images/cadenas.png");//Icône
        this.setIconImage(icon.getImage());

        //Label demandant d'entrer le mot de passe
        JLabel enterPassword = new JLabel("Saisir le mot de passe");
        enterPassword.setForeground(Color.WHITE);
        enterPassword.setBounds(105,30,290,25);
        this.add(enterPassword);

        //Champ de texte pour saisir le mot de passe
        enterPasswordField = new JPasswordField();
        enterPasswordField.setBounds(105,50,290,25);
        this.add(enterPasswordField);

            /*
             * Ajoute un KeyListener sur enterPasswordField
             * Si l'utilisateur appuie sur ENTREE
             * alors on appelle la fonction qui compare le mdp saisi avec celui enregistré
             */
            enterPasswordField.addKeyListener(new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        char[] pwdWritten = enterPasswordField.getPassword();//Capte le mot de passe saisi dans le champ
                        Singleton singleton = Singleton.getInstance();
                        singleton.setInfo(pwdWritten);
                        int result = LoginController.passwordComparison(pwdWritten);//Appelle la fonction de comparaison de mdp

                        if(result == 0) {
                            dispose();
                            try {
                                new ManagerWindow();
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        }
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) { }

                @Override
                public void keyTyped(KeyEvent e) { }
            });

        //Bouton pour valider la saisie du mot de passe
        JButton validatePassword = new JButton("Valider");
        validatePassword.setBounds(245,90,150,25);
        this.add(validatePassword);

            /*
             * Ajoute un ActionListener sur validatePassword
             * Si l'utilisateur clique sur VALIDER
             * alors on appelle la fonction qui compare le mdp saisi avec celui enregistré
             */
            validatePassword.addActionListener(e -> {
                try{
                    char[] pwdWritten = enterPasswordField.getPassword();//Capte le mot de passe saisi dans le champ
                    Singleton singleton = Singleton.getInstance();
                    singleton.setInfo(pwdWritten);
                    int result = LoginController.passwordComparison(pwdWritten);//Appelle la fonction de comparaison de mdp

                    if(result == 0) {
                        dispose();
                        new ManagerWindow();
                    }
                }
                catch(Exception ex)
                {
                    System.err.println(ex);
                }
            });

        //Label d'information
        JLabel info = new JLabel("", SwingConstants.CENTER);
        info.setText("<html><div style=\"text-align:center; color:white;\"><strong>Attention : par mesure de sécurité, vous serez automatiquement<br/>déconnecté à la fermeture du gestionnaire.</strong></div></html>");
        info.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        info.setBounds(0,135,500,50);
        this.add(info);

        //Label pour réinitialiser le mot de passe (hypertexte)
        JLabel lostPassword = new JLabel("", SwingConstants.CENTER);
        lostPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lostPassword.setText("<html><span style=\"color:red; font-size:10px;\"><u> Mot de passe perdu ? </u></span></html>");
        lostPassword.setBounds(0,180,500,30);
        this.add(lostPassword);

            /*
             * Ajoute un MouseListener sur lostPassword
             * Si on clique sur "Mot de passe perdu ?"
             * alors on appelle la fonction de réinitialisation de mdp
             */
            lostPassword.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int result = LoginController.passwordReset();

                    if(result == 0) {
                        dispose();
                        new SignUpWindow();
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

        //Image pour le fond de la fenêtre
        ImageIcon imgBackground = new ImageIcon("../general/images/background/backgroundLogin.png");
        JLabel background = new JLabel("",imgBackground,JLabel.CENTER);
        background.setBounds(0,0,500,265);
        this.add(background);

        this.setVisible(true);
    }
}
