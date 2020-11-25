package fr.passwordmanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import fr.passwordmanager.model.Password;
import fr.passwordmanager.view.ManagerWindow;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddPasswordController implements Serializable {
   private static final ObjectMapper mapper = new ObjectMapper();

   public AddPasswordController(){
   }

   private static void refreshTable(){
      ManagerWindow.modele.fireTableDataChanged();
   }

   public static void AddPasswordProcessing(String titre, String username, char[] password, String URL, String description, String expiration_date){
      Singleton.getInstance().getPasswordList().add(new Password(titre,username,String.valueOf(password),URL,description,expiration_date));
      refreshTable();
   }
   public static void ListSaving() throws IOException {
      try(OutputStream fos = new FileOutputStream(new File("../general/src/data.json"))) {
         mapper.writeValue(fos, Singleton.getInstance().getPasswordList());
      }
   }
   public static void ListReading() throws IOException {
      File data = new File("../general/src/data.json");
      if (data.exists()) {
         CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Password.class);
         List temp = mapper.readValue(data, listType);
         Singleton.getInstance().setPasswordList(temp);
      }else {
         List<Password> empty = new ArrayList<>();
         Singleton.getInstance().setPasswordList(empty);
      }
   }

   public static void deletePassword(){
      Singleton.getInstance().getPasswordList().remove(ManagerWindow.tableau.getSelectedRow());
      refreshTable();
   }

}
