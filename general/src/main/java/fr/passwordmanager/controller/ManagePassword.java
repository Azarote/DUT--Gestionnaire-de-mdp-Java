package fr.passwordmanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import fr.passwordmanager.model.Password;
import fr.passwordmanager.view.DialogMessage;
import fr.passwordmanager.view.ManagerWindow;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Classe qui traite les mots de passe</p>
 *
 * @author Matteo DUFOUR
 * @author Matteo MUNOZ
 */
public class ManagePassword implements Serializable {
   /**
    * Mapper pour le fichier JSON
    */
   private static final ObjectMapper mapper = new ObjectMapper();

   /**
    * <p>Constructeur de la classe ManagePassword</p>
    */
   public ManagePassword(){
   }

   /**
    * <p>Méthode qui rafraîchit les données du tableau</p>
    */
   private static void refreshTable(){
      ManagerWindow.modele.fireTableDataChanged();
   }


   /**
    * <p>Méthode qui ajoute un mot de passe au tableau</p>
    *
    * @param titre Le titre du mot de passe
    * @param username Le nom d'utilisateur
    * @param password Le mot de passe
    * @param URL Le lien du site
    * @param description La description
    * @param expiration_date La date d'expiration
    */
   public static void AddPasswordProcessing(String titre, String username, char[] password, String URL, String description, String expiration_date){
      Singleton.getInstance().getPasswordList().add(new Password(titre,username,String.valueOf(password),URL,description,expiration_date));
      refreshTable();
   }

   /**
    * <p>Méthode qui sauvegarde les mots de passe ajouté dans le fichier JSON</p>
    *
    */
   public static void ListSaving() {
      try(OutputStream fos = new FileOutputStream(new File("../general/src/data.json"))) {
         mapper.writeValue(fos, Singleton.getInstance().getPasswordList());
      }
      catch(IOException e)
      {
         e.printStackTrace();
      }
   }

   /**
    * <p>Méthode qui lit les données du fichier JSON</p>
    * @throws IOException Les exceptions
    */
   public static void ListReading() throws IOException {
      File data = new File("../general/src/data.json");
      if (data.exists()) {
         CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Password.class);
         List temp = mapper.readValue(data, listType);
         Singleton.getInstance().setPasswordList(temp);
      }
      else {
         List<Password> empty = new ArrayList<>();
         Singleton.getInstance().setPasswordList(empty);
      }
   }

   /**
    * <p>Méthode qui supprime un mot de passe</p>
    */
   public static void deletePassword(){
      int row = ManagerWindow.tableau.getSelectedRow();

      if(row == -1)
      {
         DialogMessage.messageDialog("Aucun mot de passe n'a été sélectionné");//Pop-up
      }
      else {
         int reponse = DialogMessage.confirmDialog("Le mot de passe sera supprimé. Voulez-vous poursuivre ?", "Supprimer le mot de passe");

         if (reponse == 0) {
            try {
               Singleton.getInstance().getPasswordList().remove(ManagerWindow.tableau.getSelectedRow());
               refreshTable();
            } catch (Exception e) {
               System.err.println();
            }
         }
      }
   }
}
