import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

public class LoginWindow extends JFrame {

    private ObjectInputStream fRo;

    public LoginWindow(String s){
        super(s);
        setSize(500,220);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Termine l'application à la fermeture de la fenêtre
        setLocationRelativeTo(null); //Centre la fenêtre
        setResizable(false); //Empêche le redimensionnement de la fenêtre
        setLayout(null);


        //Champ de texte pour saisir le mot de passe
        JPasswordField enterPasswordField = new JPasswordField();
        enterPasswordField.setBounds(105,50,290,25);
        add(enterPasswordField);

        //Label demandant d'entrer le mot de passe
        JLabel enterPassword = new JLabel("Saisir le mot de passe");
        enterPassword.setBounds(105,30,290,25);
        add(enterPassword);

        //Bouton pour valider l'opération
        JButton validatePassword = new JButton("Valider");
        validatePassword.setBounds(105,90,150,25);
        add(validatePassword);

        try{
            fRo = new ObjectInputStream(new FileInputStream("general/src/password.dat"));
            char[] pwdSaved = (char[]) fRo.readObject();
            fRo.close();
        }
        catch (IOException | ClassNotFoundException ioException){
            ioException.printStackTrace();
        }

        /* Lorsque l'on clique sur "Valider"
        on lance le traitement du mdp saisi pour comparer
        s'il est identique à celui enregistré dans le fichier
         */
        validatePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] pwdSaved = new char[0];
                
                try{
                    fRo = new ObjectInputStream(new FileInputStream("general/src/password.dat"));
                    pwdSaved = (char[]) fRo.readObject();
                    fRo.close();
                }
                catch (IOException | ClassNotFoundException ioException){
                    ioException.printStackTrace();
                }

                char[] pwdWritten = enterPasswordField.getPassword();

                if(Arrays.equals(pwdWritten, pwdSaved)){
                    System.out.println("Le mot de passe saisi est identique à celui enregistré");
                }
                else{
                    System.out.println("Le mot de passe saisi ne correspond pas à celui enregistré");
                }
            }
        });

        setVisible(true);
    }

}
