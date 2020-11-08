import javax.swing.*;
import java.io.File;

public class principal {
    public static SignUpWindow signup;
    public static LoginWindow login;

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        File fichierPWD = new File("general/src/password.dat");

        //Question : faut il stocker le mot de passe dans un fichier différent de celui contenant tous les mdp ?
        if(fichierPWD.exists())
            login = new LoginWindow("Authentification");
        else
            signup = new SignUpWindow("Enregistrer un mot de passe global");
    }
}