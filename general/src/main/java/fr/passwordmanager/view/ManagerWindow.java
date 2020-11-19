package fr.passwordmanager.view;

import fr.passwordmanager.model.ModeleTableObjet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ManagerWindow extends JFrame {
    private ModeleTableObjet modele = new ModeleTableObjet();
    private JTable tableau;
    public ManagerWindow(){
        JFrame frame = new JFrame();
        this.setTitle("Gestionnaire de mots de passe");
        this.setSize(650,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Termine l'application à la fermeture de la fenêtre
        this.setLocationRelativeTo(null); //Centre la fenêtre
        this.setResizable(false); //Empêche le redimensionnement de la fenêtre

        ImageIcon icon = new ImageIcon("../general/images/cadenas.png");
        this.setIconImage(icon.getImage());

        JToolBar menu = new JToolBar();
        menu.setFloatable(false);
        menu.setBackground(new Color(255, 255, 255,255));

        JButton btnAjouter = new JButton(new ImageIcon("../general/images/ajouter_icon_large.png"));
        btnAjouter.setFocusPainted(false);//Empêche le bouton d'être sélectionné par défaut
        btnAjouter.setFocusable(false);//Empêche le bouton d'être sélectionné par défaut
        btnAjouter.setBackground(new Color(46, 209, 60, 128));
        btnAjouter.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //btnAjouter.setBackground(new Color(112,224,159, 153));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //btnAjouter.setBackground(UIManager.getColor("control"));
            }
        });

        btnAjouter.setToolTipText("Ajouter un nouveau mot de passe");
        menu.add(Box.createHorizontalGlue());//Ajoute un espacement à gauche du premier bouton
        menu.add(btnAjouter);

        JButton btnSupprimer = new JButton(new ImageIcon("../general/images/supprimer_icon_large.png"));
        btnSupprimer.setFocusPainted(false);//Empêche le bouton d'être sélectionné par défaut
        btnSupprimer.setFocusable(false);//Empêche le bouton d'être sélectionné par défaut
        btnSupprimer.setBackground(new Color(255, 0, 0, 128));
        btnSupprimer.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //btnSupprimer.setBackground(new Color(255,0,0, 100));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //btnSupprimer.setBackground(UIManager.getColor("control"));
            }
        });

        btnSupprimer.setToolTipText("Supprimer un mot de passe");
        menu.addSeparator();
        menu.add(btnSupprimer);
        menu.addSeparator();

        JButton btnModifier = new JButton(new ImageIcon("../general/images/modifier_icon_large.png"));
        btnModifier.setFocusPainted(false);//Empêche le bouton d'être sélectionné par défaut
        btnModifier.setFocusable(false);//Empêche le bouton d'être sélectionné par défaut
        btnModifier.setBackground(new Color(255, 127, 54, 128));
        btnModifier.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //btnModifier.setBackground(new Color(255,255,255, 153));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //btnModifier.setBackground(UIManager.getColor("control"));
            }
        });

        btnModifier.setToolTipText("Modifier un mot de passe");
        menu.add(btnModifier);
        menu.add(Box.createHorizontalGlue());//Ajoute un espacement à droite du dernier bouton

        this.add(menu, BorderLayout.NORTH);
        tableau = new JTable(modele);
        tableau.getTableHeader().setReorderingAllowed(false);
        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
        this.setVisible(true);
    }
}
