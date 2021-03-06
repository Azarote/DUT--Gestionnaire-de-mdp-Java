package fr.passwordmanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import fr.passwordmanager.model.Password;
import fr.passwordmanager.view.DialogMessage;
import fr.passwordmanager.view.ManagerWindow;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

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
    * @param year L'année
    * @param month Le mois
    * @param day La jour
    */
   public static void AddPasswordProcessing(String titre, String username, char[] password, String URL, String description, int year,int month,int day){
      Singleton.getInstance().getPasswordList().add(new Password(titre,username,String.valueOf(password),URL,description,year,month+1,day));
      refreshTable();
   }


   /**
    * <p>Méthode qui ajoute un mot de passe au tableau sans la date</p>
    *
    * @param titre Le titre du mot de passe
    * @param username Le nom d'utilisateur
    * @param password Le mot de passe
    * @param URL Le lien du site
    * @param description La description
    */
   public static void AddPasswordProcessingIfDateEmpty(String titre, String username, char[] password, String URL, String description){
      Singleton.getInstance().getPasswordList().add(new Password(titre,username,String.valueOf(password),URL,description,0,0,0));
      refreshTable();
   }

   /**
    * <p>Méthode qui sauvegarde les mots de passe ajouté dans le fichier JSON</p>
    *
    */
   public static void ListSaving() {
      try(OutputStream fos = new FileOutputStream(new File("data.json"))) {
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
      File data = new File("data.json");
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


   /**
    * <p>Méthode qui récupère les mots de passe dont la date expire bientôt (5 jours)</p>
    *
    * @throws ParseException Exception analyse syntaxique
    */
   public static void isDateExpire() throws ParseException {
      LocalDate datenow = java.time.LocalDate.now();
      List<Password> expiresoon= new ArrayList<>();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");

         for (int i = 0; i < Singleton.getInstance().getPasswordList().size(); i++) {
            if(Singleton.getInstance().getPasswordList().get(i).getYear()!=0) {
               String date1 = Singleton.getInstance().getPasswordList().get(i).getYear() + "-" + Singleton.getInstance().getPasswordList().get(i).getMonth() + "-" + Singleton.getInstance().getPasswordList().get(i).getDay();
               LocalDate datepassword = LocalDate.parse(date1, formatter);
               long difference = ChronoUnit.DAYS.between(datenow, datepassword);

               if (difference <= 5) {
                  expiresoon.add(Singleton.getInstance().getPasswordList().get(i));
               }
            }
         }
      DialogMessage.warningDialog(expiresoon);
   }
}
