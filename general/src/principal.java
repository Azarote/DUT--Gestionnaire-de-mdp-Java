import javax.swing.*;
import java.io.File;

public class principal {
    private static SignUpWindow signup;
    private static LoginWindow login;
    private static File data;

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        data = new File("general/src/data.dat");

        if(data.exists())
            login = new LoginWindow("Authentification");
        else
            signup = new SignUpWindow("Enregistrer un mot de passe global");
    }
}