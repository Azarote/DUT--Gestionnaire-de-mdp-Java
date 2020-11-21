package fr.passwordmanager.controller;

import fr.passwordmanager.model.Password;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AddPasswordController {
   private static Vector<Password> passwordVector;
   public AddPasswordController(){
      passwordVector = new Vector<Password>() {
      };
   }
   public void AddPasswordProcessing(String titre, String username, char[] password, String URL, String description, String expiration_date){
      Password password1 = new Password(titre,username,String.valueOf(password),URL,description,expiration_date);
      System.out.println(titre + " " + username + " " + String.valueOf(password) + " " + URL + " " + description + " " + expiration_date);
      passwordVector.add(password1);
   }
}
