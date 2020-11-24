package fr.passwordmanager.model;

import fr.passwordmanager.controller.AddPasswordController;
import fr.passwordmanager.controller.Singleton;

import javax.swing.table.AbstractTableModel;
import java.io.IOException;
import java.util.List;

public class ModeleTableObjet extends AbstractTableModel {
    private final List<Password> passwords ;

    private final String[] titles = {"Titre","Pseudo/Email","Mot de Passe","URL","Description","Date d'expiration"};
    public ModeleTableObjet() throws IOException {
        super();
        AddPasswordController.ListReading();
        passwords = Singleton.getInstance().getPasswordList();
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
