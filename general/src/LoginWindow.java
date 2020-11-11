import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Arrays;

public class LoginWindow extends JFrame {

    private JButton validatePassword;

    private JLabel enterPassword;
    private JLabel attention, attention2;

    private JPasswordField enterPasswordField;

    private static ManagerWindow manager;
    private static ObjectInputStream fRo;

    public LoginWindow(String s){
        super(s);
        this.setSize(500,220);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Termine l'application à la fermeture de la fenêtre
        this.setLocationRelativeTo(null); //Centre la fenêtre
        this.setResizable(false); //Empêche le redimensionnement de la fenêtre
        this.setLayout(null);

        ImageIcon icon = new ImageIcon("general/src/cadenas.png");
        this.setIconImage(icon.getImage());

        //Label demandant d'entrer le mot de passe
        enterPassword = new JLabel("Saisir le mot de passe");
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
        validatePassword = new JButton("Valider");
        validatePassword.setBounds(105,90,150,25);
        this.add(validatePassword);

            //Appelle la fonction qui compare le mdp saisi avec celui enregistré si on clique sur "Valider"
            validatePassword.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    passwordComparison();
                }
            });

        //Label1
        attention = new JLabel("Attention : par mesure de sécurité, vous serez automatiquement déconnecté", SwingConstants.CENTER);
        attention.setBounds(0,135,500,20);
        this.add(attention);

        //Label2
        attention2 = new JLabel("à la fermeture du gestionnaire.", SwingConstants.CENTER);
        attention2.setBounds(0,149,500,20);
        this.add(attention2);

        this.setVisible(true);
    }

    //Fonction qui compare le mot de passe enregistré avec le mot de passe saisi
    private void passwordComparison() {
        char[] pwdSaved = new char[0];

        //Lit le mot de passe enregistré
        try{
            fRo = new ObjectInputStream(new FileInputStream("general/src/data.dat"));
            pwdSaved = (char[]) fRo.readObject();
            fRo.close();
        }
        catch (IOException | ClassNotFoundException ioException){
            ioException.printStackTrace();
        }

        char[] pwdWritten = enterPasswordField.getPassword();//Capte le mot de passe saisi dans le champ

        //Compare le mot de passe saisi avec le mot de passe enregistré
        if(Arrays.equals(pwdWritten, pwdSaved)){
            System.out.println("Le mot de passe saisi est identique à celui enregistré");
            dispose();

            manager = new ManagerWindow("Gestionnaire de mots de passe");
        }
        else{
            JOptionPane.showMessageDialog(enterPasswordField,"Mot de passe inconnu","Erreur", JOptionPane.ERROR_MESSAGE);//Pop-up
            System.out.println("Mot de passe inconnu");
        }
    }
}
