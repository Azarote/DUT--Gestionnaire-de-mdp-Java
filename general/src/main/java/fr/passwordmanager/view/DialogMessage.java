package fr.passwordmanager.view;

import javax.swing.*;
import java.awt.*;

public class DialogMessage {

    //Message d'erreur
    public static void messageDialog(String s) {
        JOptionPane.showMessageDialog(null,s,"Erreur", JOptionPane.ERROR_MESSAGE);//Pop-up
    }

    //Message de confirmation
    public static int confirmDialog(String s, String titre) {
        JOptionPane.showConfirmDialog(null,s,titre, JOptionPane.YES_NO_OPTION);

        return JOptionPane.YES_OPTION;
    }
}
