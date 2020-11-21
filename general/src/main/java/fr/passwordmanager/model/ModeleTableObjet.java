package fr.passwordmanager.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeleTableObjet extends AbstractTableModel {
    private final List<Password> passwords = new ArrayList<Password>();

    private final String[] titles = {"Titre","Pseudo/Email","Mot de Passe","URL","Description","Date d'expiration"};
    public ModeleTableObjet(){
        super();
        //passwords.add(new Password("Test","Celestin","123456","youtube.com","Test desc", "28-05-2020"));
    }
    @Override
    public int getRowCount() {
        return passwords.size();
    }

    @Override
    public int getColumnCount() {
        return titles.length;
    }

    public String getColumnName(int columnIndex) {
        return titles[columnIndex];
    }

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
                return passwords.get(i).getExpiration_date();
            default:
                return null;
        }
    }
}
