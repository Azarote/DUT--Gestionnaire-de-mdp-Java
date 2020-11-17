package fr.passwordmanager.view;

import fr.passwordmanager.controller.FileEncrypterDecrypter;

import javax.crypto.Cipher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;

public class LoginWindow extends JFrame {

    private final JPasswordField enterPasswordField;

    public LoginWindow(){
        JFrame frame = new JFrame();
        this.setTitle("Authentification");
        this.setSize(500,265);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Termine l'application à la fermeture de la fenêtre
        this.setLocationRelativeTo(null); //Centre la fenêtre
        this.setResizable(false); //Empêche le redimensionnement de la fenêtre
        this.setLayout(null);

        ImageIcon icon = new ImageIcon("general/images/cadenas.png");
        this.setIconImage(icon.getImage());

        //Label demandant d'entrer le mot de passe
        JLabel enterPassword = new JLabel("Saisir le mot de passe");
        enterPassword.setBounds(105,30,290,25);
        this.add(enterPassword);

        //Champ de texte pour saisir le mot de passe
        enterPasswordField = new JPasswordField();
        enterPasswordField.setBounds(105,50,290,25);
        this.add(enterPasswordField);

            //Appelle la fonction qui compare le mdp saisi avec celui enregistré si on appuye sur "Entrée"
            enterPasswordField.addKeyListener(new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        passwordComparison();
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

            //Appelle la fonction qui compare le mdp saisi avec celui enregistré si on clique sur "Valider"
            validatePassword.addActionListener(e -> passwordComparison());

        //Label d'information
        JLabel info = new JLabel("", SwingConstants.CENTER);
        info.setText("<html><div style=\"text-align:center;\">Attention : par mesure de sécurité, vous serez automatiquement déconnecté<br/>à la fermeture du gestionnaire.</div></html>");
        info.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        info.setBounds(0,135,500,35);
        this.add(info);

        //Label pour réinitialiser le mot de passer (hypertexte)
        JLabel lostPassword = new JLabel("", SwingConstants.CENTER);
        lostPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lostPassword.setText("<html><span style=\"color:blue;\"><u>Mot de passe perdu ?</u></span></html>");
        lostPassword.setBounds(0,180,500,30);
        this.add(lostPassword);

            //Si on clique sur "Mot de passe perdu ?"
            lostPassword.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    passwordReset();
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

        this.setVisible(true);
    }

    //Fonction qui lance la procédure de réinitialisation de mot de passe
    private void passwordReset() {
        int reponse = JOptionPane.showConfirmDialog(this, "Si vous réinitialisez le mot de passe global, toutes les données seront perdues. Voulez-vous poursuivre ?", "Réinitialiser le mot de passe", JOptionPane.YES_NO_OPTION);

        if(reponse == JOptionPane.YES_OPTION)
        {
            try{
                File f = new File("../general/src/data.dat");
                f.delete();
            }
            catch(Exception e)
            {
                System.err.println();
            }

            dispose();

            new SignUpWindow();
        }
    }

    //Fonction qui compare le mot de passe enregistré avec le mot de passe saisi
    private void passwordComparison() {
        char[] pwdSaved = new char[0];

        //Lit le mot de passe enregistré
        try{
            ObjectInputStream fRo = new ObjectInputStream(new FileInputStream("../general/src/data.dat"));
            pwdSaved = (char[]) fRo.readObject();
            fRo.close();
        }
        catch (IOException | ClassNotFoundException ioException){
            ioException.printStackTrace();
        }

        char[] pwdWritten = enterPasswordField.getPassword();//Capte le mot de passe saisi dans le champ
        File f = new File("../general/src/data.dat");
        FileEncrypterDecrypter.encryptDecrypt(pwdWritten, Cipher.DECRYPT_MODE,f,f);

        //Compare le mot de passe saisi avec le mot de passe enregistré
        if(Arrays.equals(pwdWritten, pwdSaved)){
            dispose();

            new ManagerWindow();
        }
        else if(pwdWritten.length<=0){
            JOptionPane.showMessageDialog(enterPasswordField,"Aucun mot de passe n'a été saisi","Erreur", JOptionPane.ERROR_MESSAGE);//Pop-up
        }
        else{
            JOptionPane.showMessageDialog(enterPasswordField,"Mot de passe inconnu","Erreur", JOptionPane.ERROR_MESSAGE);//Pop-up
        }
    }
}
