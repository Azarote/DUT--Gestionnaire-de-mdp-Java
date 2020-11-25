package fr.passwordmanager.controller;

import com.google.common.hash.Hashing;
import fr.passwordmanager.view.DialogMessage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * <p>Classe qui traite les données de SignUpWindow</p>
 *
 * @author Matteo DUFOUR
 * @author Matteo MUNOZ
 */
public class LoginController {

    /**
     * <p>Méthode qui lance la procédure de réinitialisation de mot de passe</p>
     *
     * @return Un entier correspondant à l'achèvement de la procédure
     */
    public static int passwordReset() {
        int reponse = DialogMessage.confirmDialog("Si vous réinitialisez le mot de passe global, toutes les données seront perdues.\nVoulez-vous poursuivre ?", "Réinitialiser le mot de passe");

        if(reponse == 0)
        {
            try{
                File filePwd = new File("../general/src/hashed.dat");//Repère le fichier du mdp global
                File fileData = new File("../general/src/data.json");//Repère le fichier des données

                filePwd.delete();//Supprime le fichier
                fileData.delete();//Supprime le fichier
            }
            catch(Exception e)
            {
                System.err.println();
            }
            return 0;
        }
        else
            return 1;
    }

    /**
     * <p>Méthode qui compare le mot de passe enregistré avec le mot de passe saisi</p>
     *
     * @param pwdWritten Le mot de passe saisi pour se connecter
     * @return Un entier qui indique l'état de la comparaison
     */
    public static int passwordComparison(char[] pwdWritten) {
        String pwdSaved = null;

        //Lit le mot de passe enregistré
        try{
            Path file = Path.of("../general/src/hashed.dat");
            pwdSaved = Files.readString(file);

        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }

        final String pwdWrittenHashed = Hashing.sha256()
                .hashString((String.valueOf(pwdWritten)), StandardCharsets.UTF_8)
                .toString();
        Singleton.getInstance().setInfo(pwdWrittenHashed);

        //Compare le mot de passe saisi avec le mot de passe enregistré
        if(pwdWrittenHashed.equals(pwdSaved)){
            return 0;
        }
        else if(pwdWritten.length<=0){
            DialogMessage.messageDialog("Aucun mot de passe n'a été saisi");//Pop-up
            return 1;
        }
        else{
            DialogMessage.messageDialog("Mot de passe inconnu");//Pop-up
            return 1;
        }
    }
}
