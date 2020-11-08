import javax.swing.*;

public class LoginWindow extends JFrame {

    public LoginWindow(String s){
        super(s);
        setSize(500,220);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Termine l'application à la fermeture de la fenêtre
        setLocationRelativeTo(null); //Centre la fenêtre
        setResizable(false); //Empêche le redimensionnement de la fenêtre
        setLayout(null);

        //Label demandant d'entrer le mot de passe
        JLabel enterPassword = new JLabel("Saisir le mot de passe");
        enterPassword.setBounds(105,30,290,25);
        add(enterPassword);

        //Champ de texte pour saisir le mot de passe
        JPasswordField enterPasswordField = new JPasswordField();
        enterPasswordField.setBounds(105,50,290,25);
        add(enterPasswordField);

        //Bouton pour valider l'opération
        JButton validatePassword = new JButton("Valider");
        validatePassword.setBounds(105,90,150,25);
        add(validatePassword);

        setVisible(true);
    }

}
