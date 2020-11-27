package fr.passwordmanager.view;

import javax.swing.*;
import java.io.File;

/**
 * <p>Point d'entrée du Gestionnaire</p>
 *
 * @author Matteo DUFOUR
 * @author Matteo MUNOZ
 */
public class Principal {

    /**
     * <p>Classe main</p>
     *
     * @param args Les arguments
     */
    public static void main(String[] args){
        //Améliore le thème par défaut
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        /*
         * Si un mot de passe global a été enregistré,
         * on lance la fenêtre de Login au démarrage
         * sinon fenêtre SignUp
         */
        if(new File("hashed.dat").exists())
            new LoginWindow();
        else
            new SignUpWindow();
    }
}