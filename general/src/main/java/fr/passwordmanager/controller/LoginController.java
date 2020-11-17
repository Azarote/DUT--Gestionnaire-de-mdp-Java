package fr.passwordmanager.controller;

import fr.passwordmanager.view.ManagerWindow;
import fr.passwordmanager.view.SignUpWindow;
import fr.passwordmanager.view.DialogMessage;

import javax.crypto.Cipher;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class LoginController {

    //Fonction qui lance la procédure de réinitialisation de mot de passe
    public static void passwordReset() {
        int reponse = DialogMessage.confirmDialog("Si vous réinitialisez le mot de passe global, toutes les données seront perdues. Voulez-vous poursuivre ?", "Réinitialiser le mot de passe");

        if(reponse == 0)
        {
            try{
                File f = new File("../general/src/data.dat");
                f.delete();
            }
            catch(Exception e)
            {
                System.err.println();
            }
        }
    }

    //Fonction qui compare le mot de passe enregistré avec le mot de passe saisi
    public static boolean passwordComparison(char[] pwdWritten) {
        char[] pwdSaved = new char[0];

        //Lit le mot de passe enregistré
        try{
            ObjectInputStream fRo = new ObjectInputStream(new FileInputStream("../general/src/data.dat"));
            pwdSaved = (char[]) fRo.readObject();
            fRo.close();
        }
        catch (IOException | ClassNotFoundException ioException){
            ioException.printStackTrace();
        }


        File f = new File("../general/src/data.dat");
        FileEncrypterDecrypter.encryptDecrypt(pwdWritten, Cipher.DECRYPT_MODE,f,f);

        //Compare le mot de passe saisi avec le mot de passe enregistré
        if(Arrays.equals(pwdWritten, pwdSaved)){
            return true;
        }
        else if(pwdWritten.length<=0){
            DialogMessage.messageDialog("Aucun mot de passe n'a été saisi");//Pop-up
            return false;
        }
        else{
            DialogMessage.messageDialog("Mot de passe inconnu");//Pop-up
            return false;
        }
    }
}
