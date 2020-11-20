package fr.passwordmanager.view;

import javax.swing.*;
import java.awt.*;

public class AddPassword extends JFrame {
    public AddPassword() {
        JFrame frame = new JFrame();
        this.setTitle("Ajouter un mot de passe");
        this.setSize(500,450);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); //Centre la fenêtre
        this.setResizable(false); //Empêche le redimensionnement de la fenêtre
        this.setVisible(true);
    }
}
