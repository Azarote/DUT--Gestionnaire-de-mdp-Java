package fr.passwordmanager.controller;

import com.google.common.hash.Hashing;
import fr.passwordmanager.view.DialogMessage;


import javax.crypto.Cipher;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class HashingAndProcessing {

    public static void mainPasswordHashing(char[] mainPassword) {
        final String hashed = Hashing.sha256()
                .hashString(String.valueOf(String.valueOf(mainPassword)), StandardCharsets.UTF_8)
                .toString();
        File hashedFile = new File("../general/src/hashed.dat");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(hashedFile));
            writer.write(hashed);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Fonction qui traite les mots de passes saisis dans les champs
    public static int passwordProcessing(char[] pwd1, char[] pwd2) {

        int nbLettre = 0;
        int nbChiffre = 0;

        //Traite le nombre de chiffres et de lettres
        for (char c : pwd1) {
            if (Character.isLetter(c)) {
                nbLettre++;//Incrémente le nombre de lettres si le caractère à la position i est une lettre
            }
            if (Character.isDigit(c)) {
                nbChiffre++;//Incrémente le nombre de chiffres si le caractère à la position i est un chiffre
            }
        }

        if (!Arrays.equals(pwd1, pwd2)) { //Si les deux mots de passe ne correspondent pas
            DialogMessage.messageDialog("Les deux mots de passe ne correspondent pas");
            return 1;
        }
        else if(pwd1.length<8){ //Si le mot de passe fait moins de 8 caractères
            DialogMessage.messageDialog("Le mot de passe doit contenir 8 caractères minimum");//Pop-up
            return 1;
        }
        else if (nbLettre < 6 || nbChiffre < 2){ //Si le mot de passe contient moins de 6 lettres et/ou moins de 2 chiffres
            DialogMessage.messageDialog("Le mot de passe doit contenir 6 lettres et 2 chiffres minimum");//Pop-up
            return 1;
        }
        else { //Si les critères de validation de mdp sont vérifiés, on demande confirmation
            int reponse = DialogMessage.confirmDialog("Le mot de passe est valide\nVoulez-vous poursuivre ?","Validation");

            //Si l'utilisateur veut poursuivre, on crée le fichier
            if(reponse == 0)
            {
                mainPasswordHashing(pwd1);
            }
            return 0;
        }
    }
}
