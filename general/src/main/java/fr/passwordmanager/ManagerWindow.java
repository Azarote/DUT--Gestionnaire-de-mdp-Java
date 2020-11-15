package fr.passwordmanager;

import javax.swing.*;

public class ManagerWindow extends JFrame {
    public ManagerWindow(){
        JFrame frame = new JFrame();
        this.setTitle("Gestionnaire de mots de passe");
        this.setSize(650,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Termine l'application à la fermeture de la fenêtre
        this.setLocationRelativeTo(null); //Centre la fenêtre
        this.setResizable(false); //Empêche le redimensionnement de la fenêtre

        ImageIcon icon = new ImageIcon("general/src/cadenas.png");
        this.setIconImage(icon.getImage());

        this.setVisible(true);
    }
}
