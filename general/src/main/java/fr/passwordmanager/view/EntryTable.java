package fr.passwordmanager.view;

import fr.passwordmanager.model.ModeleTableObjet;

import javax.swing.*;
import java.awt.*;

public class EntryTable extends JFrame {
    private ModeleTableObjet modele = new ModeleTableObjet();
    private JTable tableau;

        public EntryTable() {
            tableau = new JTable(modele);
            tableau.getTableHeader().setReorderingAllowed(false);
            getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
        }
    }
