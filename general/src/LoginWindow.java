import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        //Champ de texte pour saisir le mot de passe
        enterPasswordField = new JPasswordField();
        enterPasswordField.setBounds(105,50,290,25);
        this.add(enterPasswordField);

        //Label demandant d'entrer le mot de passe
        enterPassword = new JLabel("Saisir le mot de passe");
        enterPassword.setBounds(105,30,290,25);
        this.add(enterPassword);

        //Bouton pour valider l'opération
        validatePassword = new JButton("Valider");
        validatePassword.setBounds(105,90,150,25);
        this.add(validatePassword);

        //Label1
        attention = new JLabel("Attention : par mesure de sécurité, vous serez automatiquement déconnecté", SwingConstants.CENTER);
        attention.setBounds(0,135,500,20);
        this.add(attention);

        //Label2
        attention2 = new JLabel("à la fermeture du gestionnaire.", SwingConstants.CENTER);
        attention2.setBounds(0,149,500,20);
        this.add(attention2);

        try{
            fRo = new ObjectInputStream(new FileInputStream("general/src/data.dat"));
            char[] pwdSaved = (char[]) fRo.readObject();
            fRo.close();
        }
        catch (IOException | ClassNotFoundException ioException){
            ioException.printStackTrace();
        }

        //Compare le mdp saisi avec celui enregistré
        validatePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] pwdSaved = new char[0];
                
                try{
                    fRo = new ObjectInputStream(new FileInputStream("general/src/data.dat"));
                    pwdSaved = (char[]) fRo.readObject();
                    fRo.close();
                }
                catch (IOException | ClassNotFoundException ioException){
                    ioException.printStackTrace();
                }

                char[] pwdWritten = enterPasswordField.getPassword();

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
        });

        this.setVisible(true);
    }
}
