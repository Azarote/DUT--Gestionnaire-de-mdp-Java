package fr.passwordmanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.passwordmanager.model.Password;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class AddPasswordController implements Serializable {
   private static final ObjectMapper mapper = new ObjectMapper();

   public AddPasswordController(){
   }

   public static void AddPasswordProcessing(String titre, String username, char[] password, String URL, String description, String expiration_date){
      Singleton.getInstance().getPasswordList().add(new Password(titre,username,String.valueOf(password),URL,description,expiration_date));

   }
   public static void ListSaving() throws IOException {
      try(OutputStream fos = new FileOutputStream(new File("../general/src/data.json"))) {
         mapper.writeValue(fos, Singleton.getInstance().getPasswordList());
      }
   }
   public static void ListReading() throws IOException {
     List temp = mapper.readValue(new File("../general/src/data.json"), List.class);
     System.out.println(Arrays.asList(temp) );
     Singleton.getInstance().setPasswordList(temp);
   }

}
