import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.Principal;
import java.util.Arrays;

public class SignUpWindow extends JFrame {
    private JButton validateButton;
    private JLabel newPassword;
    private JLabel newPasswordConfirmation;
    private JLabel info;
    private JPasswordField passwordField;
    private JPasswordField passwordFieldConfirmation;
    private static LoginWindow login;
    private static ObjectOutputStream fWo;

    public SignUpWindow(String a){
        super(a);
        this.setSize(600,370);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Termine l'application à la fermeture de la fenêtre
        this.setLocationRelativeTo(null); //Centre la fenêtre
        this.setResizable(false); //Empêche le redimensionnement de la fenêtre
        this.setLayout(null);

        ImageIcon icon = new ImageIcon("general/src/cadenas.png");
        this.setIconImage(icon.getImage());

        //Label demandant d'entrer un nouveau mot de passe
        newPassword = new JLabel("Mot de passe global");
        newPassword.setBounds(getSize().width/4,30,290,25);
        this.add(newPassword);

        //Champ de texte pour saisir le nouveau mot de passe
        passwordField = new JPasswordField();
        passwordField.setBounds(150,50,290,25);
        this.add(passwordField);

            //Appelle la fonction qui traite les mdps si on appuye sur "Entrée"
            passwordField.addKeyListener(new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        passwordProcessing();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) { }

                @Override
                public void keyTyped(KeyEvent e) { }
            });

        //Label demandant de confirmer le nouveau mot de passe
        newPasswordConfirmation = new JLabel("Confirmer le mot de passe");
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
                        passwordProcessing();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) { }

                @Override
                public void keyTyped(KeyEvent e) { }
            });

        //Bouton pour valider la saisie des mdp
        validateButton = new JButton("Valider");
        validateButton.setBounds(150,140,150,25);
        this.add(validateButton);

            //Appelle la fonction qui traite les mdps si on clique sur "Valider"
            validateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    passwordProcessing();
                }
            });

        //Label affichant les critères à respecter pour un mot de passe valide
        info = new JLabel("", SwingConstants.CENTER);
        info.setText("<html><div style=\"text-align:center;\"><strong>ATTENTION</strong><br/>Le mot de passe doit contenir 8 caractères minimum dont :<br/>- au moins 6 lettres<br/>- au moins 2 chiffres</div></html>");
        info.setFont(new Font("Helvetica", Font.PLAIN, 17));
        info.setForeground(Color.RED);
        info.setBounds(-6,200,600,100);
        this.add(info);

        this.setVisible(true);
    }

    //Fonction qui traite les mots de passes saisis dans les champs
    private void passwordProcessing() {
        char[] pwd1 = passwordField.getPassword();//Récupère la saisie dans le premier champ
        char[] pwd2 = passwordFieldConfirmation.getPassword();//Récupère la saisie dans le deuxième champ

        int nbLettre = 0;
        int nbChiffre = 0;

        //Traite le nombre de chiffres et de lettres
        for (int i = 0; i < pwd1.length; i++) {
            if (Character.isLetter(pwd1[i])){
                nbLettre++;//Incrémente le nombre de lettres si le caractère à la position i est une lettre
            }
            if (Character.isDigit(pwd1[i])){
                nbChiffre++;//Incrémente le nombre de chiffres si le caractère à la position i est un chiffre
            }
        }

        if (!Arrays.equals(pwd1, pwd2)) { //Si les deux mots de passe ne correspondent pas
            JOptionPane.showMessageDialog(passwordField,"Les deux mots de passe ne correspondent pas","Erreur", JOptionPane.ERROR_MESSAGE);//Pop-up
            System.out.println("Les deux mots de passe ne correspondent pas");
        }
        else if(pwd1.length<8){ //Si le mot de passe fait moins de 8 caractères
            JOptionPane.showMessageDialog(passwordField,"Le mot de passe doit contenir 8 caractères minimum","Erreur", JOptionPane.ERROR_MESSAGE);//Pop-up
            System.out.println("Le mot de passe doit contenir 8 caractères minimum");
        }
        else if (nbLettre < 6 || nbChiffre < 2){ //Si le mot de passe contient moins de 6 lettres et/ou moins de 2 chiffres
            JOptionPane.showMessageDialog(passwordField,"Le mot de passe doit contenir 6 lettres et 2 chiffres minimum","Erreur", JOptionPane.ERROR_MESSAGE);//Pop-up
            System.out.println("Le mot de passe doit contenir 6 lettres et 2 chiffres minimum");

        }
        else { //Si les critères de validation de mdp sont vérifiés, on demande confirmation
            System.out.println("Le mot de passe choisi est valide");
            System.out.println("Les deux mots de passe correspondent");
            int reponse = JOptionPane.showConfirmDialog(passwordField,"Le mot de passe est valide\nVoulez-vous poursuivre ?","Validation", JOptionPane.YES_NO_OPTION);

            //Si l'utilisateur veut poursuivre, on crée le fichier
            if(reponse == JOptionPane.YES_OPTION)
            {
                try{
                    File f = new File("general/src/data.dat");

                    if (f.createNewFile())
                        System.out.println("Fichier créé");
                    else
                        System.out.println("Fichier déjà existant");

                    // f.deleteOnExit();//Sert à éviter de supprimer le fichier à chaque fois quand on compile, mais ligne à supprimer à la fin
                }
                catch(Exception ex)
                {
                    System.err.println(ex);
                }

                try {
                    fWo = new ObjectOutputStream(new FileOutputStream("general/src/data.dat"));
                    fWo.writeObject(pwd1); //On écrit le mdp dans le fichier
                    fWo.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                dispose();

                login = new LoginWindow("Authentification");
            }
        }
    }
}
