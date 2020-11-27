package fr.passwordmanager.view;

import fr.passwordmanager.model.Password;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Classe permettant de réutiliser des fenêtres de dialogue</p>
 *
 * @author Matteo DUFOUR
 * @author Matteo MUNOZ
 */
public class DialogMessage {

    /**
     * <p>Message d'erreur</p>
     *
     * @param s Le message affiché dans la fenêtre
     */
    public static void messageDialog(String s) {
        JOptionPane.showMessageDialog(null,s,"Erreur", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * <p>Message de confirmation retournant un entier</p>
     *
     * @param s Le message affiché dans la fenêtre
     * @param titre Le titre de la fenêtre
     * @return Un entier correspondant au choix de l'utilisateur
     */
    public static int confirmDialog(String s, String titre) {
        int result = JOptionPane.showConfirmDialog(null,s,titre, JOptionPane.YES_NO_OPTION);

        if(result == JOptionPane.YES_OPTION)
            return JOptionPane.YES_OPTION;//Si l'utilisateur veut poursuivre
        else
            return 1;//Si l'utilisateur ne veut pas poursuivre
    }

    /**
     * <p>Alerte pour mots de passe expirant bientôt</p>
     *
     * @param liste La liste des mots de passe expirant bientôt
     */
    public static void warningDialog(List<Password> liste) {
        List<String> temp = new ArrayList<>();

        for (Password password : liste) {
            temp.add(String.valueOf(password.getTitle()));
        }

        if(!temp.isEmpty())
            JOptionPane.showMessageDialog(null,temp,"Mot(s) de passe expirant prochainement (moins de 5 jours)", JOptionPane.WARNING_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"Aucun mot de passe n'expire prochainement","Erreur", JOptionPane.ERROR_MESSAGE);
    }
}
