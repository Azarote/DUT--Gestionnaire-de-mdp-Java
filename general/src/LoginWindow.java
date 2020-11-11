import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Arrays;

public class LoginWindow extends JFrame {

    private final JPasswordField enterPasswordField;

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
        validatePassword.setBounds(105,90,150,25);
        this.add(validatePassword);

            //Appelle la fonction qui compare le mdp saisi avec celui enregistré si on clique sur "Valider"
            validatePassword.addActionListener(e -> passwordComparison());

        //Label d'information
        JLabel info = new JLabel("", SwingConstants.CENTER);
        info.setText("<html><div style=\"text-align:center;\">Attention : par mesure de sécurité, vous serez automatiquement déconnecté<br/>à la fermeture du gestionnaire.</div></html>");
        info.setBounds(-6,135,500,30);
        this.add(info);

        this.setVisible(true);
    }

    //Fonction qui compare le mot de passe enregistré avec le mot de passe saisi
    private void passwordComparison() {
        char[] pwdSaved = new char[0];

        //Lit le mot de passe enregistré
        try{
            ObjectInputStream fRo = new ObjectInputStream(new FileInputStream("general/src/data.dat"));
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

            ManagerWindow manager = new ManagerWindow("Gestionnaire de mots de passe");
        }
        else{
            JOptionPane.showMessageDialog(enterPasswordField,"Mot de passe inconnu","Erreur", JOptionPane.ERROR_MESSAGE);//Pop-up
            System.out.println("Mot de passe inconnu");
        }
    }
}
