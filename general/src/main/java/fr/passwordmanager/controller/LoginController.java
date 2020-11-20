package fr.passwordmanager.controller;

import com.google.common.hash.Hashing;
import fr.passwordmanager.view.DialogMessage;

import javax.crypto.Cipher;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class LoginController {

    //Fonction qui lance la procédure de réinitialisation de mot de passe
    public static int passwordReset() {
        int reponse = DialogMessage.confirmDialog("Si vous réinitialisez le mot de passe global, toutes les données seront perdues. Voulez-vous poursuivre ?", "Réinitialiser le mot de passe");

        System.out.println(reponse);

        if(reponse == 0)
        {
            try{
                File f = new File("../general/src/hashed.dat");//Repère le fichier
                f.delete();//Supprime le fichier
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

    //Fonction qui compare le mot de passe enregistré avec le mot de passe saisi
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
        //Compare le mot de passe saisi avec le mot de passe enregistré
        if(pwdWrittenHashed.equals(pwdSaved)){
            File data = new File("../general/src/data.dat");
            FileEncrypterDecrypter.encryptDecrypt(pwdWritten, Cipher.DECRYPT_MODE,data,data);
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
