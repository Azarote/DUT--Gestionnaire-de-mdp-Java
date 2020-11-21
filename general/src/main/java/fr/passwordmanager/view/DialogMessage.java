package fr.passwordmanager.view;

import javax.swing.*;
import java.awt.*;

public class DialogMessage {

    //Message d'erreur
    public static void messageDialog(String s) {
        //TODO Voir quelle couleur de fond mettre pour les pop-up
        //UIManager UI = new UIManager();
        //Color color = new Color(110, 110, 110);
        //UI.put("OptionPane.background", color);
        //UI.put("Panel.background", color);

        JOptionPane.showMessageDialog(null,s,"Erreur", JOptionPane.ERROR_MESSAGE);//Pop-up
    }

    //Message de confirmation
    public static int confirmDialog(String s, String titre) {
        //UIManager UI=new UIManager();
        //Color color = new Color(110, 110, 110);
        //UI.put("OptionPane.background", color);
        //UI.put("Panel.background", color);

        int result = JOptionPane.showConfirmDialog(null,s,titre, JOptionPane.YES_NO_OPTION);//Pop-up

        if(result == JOptionPane.YES_OPTION)
            return JOptionPane.YES_OPTION;
        else
            return 1;
    }
}
