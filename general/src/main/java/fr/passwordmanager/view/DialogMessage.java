package fr.passwordmanager.view;

import javax.swing.*;

public class DialogMessage {

    //Message d'erreur
    public static void messageDialog(String s) {
        JOptionPane.showMessageDialog(null,s,"Erreur", JOptionPane.ERROR_MESSAGE);//Pop-up
    }

    //Message de confirmation
    public static int confirmDialog(String s, String titre) {
        int result = JOptionPane.showConfirmDialog(null,s,titre, JOptionPane.YES_NO_OPTION);//Pop-up

        if(result == JOptionPane.YES_OPTION)
            return JOptionPane.YES_OPTION;
        else
            return 1;
    }
}
