package fr.passwordmanager.controller;

import fr.passwordmanager.model.Password;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AddPasswordController implements Serializable {
   private static Vector<Password> passwordVector;
   public AddPasswordController(){
      passwordVector = new Vector<Password>() {
      };
   }
   public void AddPasswordProcessing(String titre, String username, char[] password, String URL, String description, String expiration_date){
      passwordVector.add(new Password(titre,username,String.valueOf(password),URL,description,expiration_date));
   }
   public static void VectorSaving() throws IOException {
      BufferedWriter bw;
      FileWriter fw;
      fw = new FileWriter("../general/src/data.dat",true);
      bw = new BufferedWriter(fw);
      bw.write(passwordVector.toString());
      bw.newLine();
      bw.flush();
      bw.close();
   }
}
