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

    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        File hashed = new File("../general/src/hashed.dat");

        //Si un mdp global a été enregistré, on lance la fenêtre de Login au démarrage ; sinon fenêtre SignUp
        if(hashed.exists())
            new LoginWindow();
        else
            new SignUpWindow();
    }
}