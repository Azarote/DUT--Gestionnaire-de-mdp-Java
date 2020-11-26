package fr.passwordmanager.model;

import fr.passwordmanager.controller.ManagePassword;
import fr.passwordmanager.controller.Singleton;

import javax.swing.table.AbstractTableModel;
import java.io.IOException;
import java.util.List;

/**
 * <p>Classe qui gère le modèle du tableau pour stocker les mots de passes</p>
 *
 * @author Matteo DUFOUR
 * @author Matteo MUNOZ
 */
public class ModeleTableObjet extends AbstractTableModel {
    /**
     * Liste pour stocker les mots de passe
     */
    private final List<Password> passwords ;

    /**
     * Titres des cellules du tableau
     */
    private final String[] titles = {"Titre","Pseudo/Email","Mot de Passe","URL","Description","Date d'expiration"};

    /**
     * <p>Constructeur de la classe ModeleTableObjet</p>
     * @throws IOException Les exceptions
     */
    public ModeleTableObjet() throws IOException {
        super();
        ManagePassword.ListReading();
        passwords = Singleton.getInstance().getPasswordList();
    }

    /**
     * Getter pour le nombre de lignes
     *
     * @return Un entier correspondant au nombre d'instances
     */
    @Override
    public int getRowCount() {
        return passwords.size();
    }

    /**
     * Getter pour le nombre de colonnes
     *
     * @return Un entier correspondant au nombre de colonnes
     */
    @Override
    public int getColumnCount() {
        return titles.length;
    }

    /**
     * Getter pour le titre de la colonne
     *
     * @param columnIndex Le numéroe de la colonne
     * @return Une chaîne de caractères correspondant au titre de la colonne
     */
    public String getColumnName(int columnIndex) {
        return titles[columnIndex];
    }

    /**
     * Getter pour la valeur dans une cellule
     *
     * @param i Le numéro de la cellule
     * @param i1 Le numéro de la ligne
     * @return Une chaîne de caractère correspondant à une propriété d'un mot de passe
     */
    @Override
    public Object getValueAt(int i, int i1) {
        switch (i1){
            case 0:
                return passwords.get(i).getTitle();
            case 1:
                return passwords.get(i).getUsername();
            case 2:
                return passwords.get(i).getPassword();
            case 3:
                return passwords.get(i).getURL();
            case 4:
                return passwords.get(i).getDescription();
            case 5:
                return passwords.get(i).getDay() + "/" +passwords.get(i).getMonth() + "/" + passwords.get(i).getYear();
            default:
                return null;
        }
    }
}
