import javax.swing.*;

public class principal {
    public static SignUpWindow signup;
    public static LoginWindow login;

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        signup = new SignUpWindow("Enregistrer un nouveau mot de passe");
        login = new LoginWindow("Authentification");
    }
}