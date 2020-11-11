import javax.swing.*;
import java.io.File;

public class principal {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        File data = new File("general/src/data.dat");

        SignUpWindow signup;
        LoginWindow login;
        if(data.exists())
            login = new LoginWindow("Authentification");
        else
            signup = new SignUpWindow("Enregistrer un mot de passe global");
    }
}