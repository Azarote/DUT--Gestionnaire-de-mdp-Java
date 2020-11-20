package fr.passwordmanager.view;

import fr.passwordmanager.model.ModeleTableObjet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ManagerWindow extends JFrame {
    private ModeleTableObjet modele = new ModeleTableObjet();
    private JTable tableau;

    private ImageIcon ajouterIcon = new ImageIcon("../general/images/icons/ajouter_icon_large.jpg");
    private ImageIcon supprimerIcon = new ImageIcon("../general/images/icons/supprimer_icon_large.jpg");
    private ImageIcon modifierIcon = new ImageIcon("../general/images/icons/modifier_icon_large.jpg");

    public ManagerWindow(){
        JFrame frame = new JFrame();
        this.setTitle("Gestionnaire de mots de passe");
        this.setSize(650,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Termine l'application à la fermeture de la fenêtre
        this.setLocationRelativeTo(null); //Centre la fenêtre
        this.setResizable(false); //Empêche le redimensionnement de la fenêtre

        ImageIcon icon = new ImageIcon("../general/images/cadenas.png");
        this.setIconImage(icon.getImage());

        JToolBar menu = new JToolBar();//Crée une barre d'outils pour mettre les boutons
        menu.setFloatable(false);//Empêche le possibilité de déplacer la barre d'outils
        menu.setBackground(new Color(255, 255, 255,255));//Colore le fond de la barre d'outils en blanc

        JButton btnAjouter = new JButton(ajouterIcon);
        btnAjouter.setFocusPainted(false);//Empêche le bouton d'être sélectionné par défaut (rectangle gris)
        btnAjouter.setFocusable(false);//Empêche le bouton d'être sélectionné par défaut
        btnAjouter.setMargin(new Insets(0, 0, 0, 0));//Enlève les espaces autour de l'icône

        btnAjouter.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new AddPassword();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        btnAjouter.setToolTipText("Ajouter un nouveau mot de passe");//Ajoute un message au survol du bouton
        menu.add(Box.createHorizontalGlue());//Ajoute un espacement à gauche du premier bouton pour centrer
        menu.add(btnAjouter);

        JButton btnSupprimer = new JButton(supprimerIcon);
        btnSupprimer.setFocusPainted(false);//Empêche le bouton d'être sélectionné par défaut (rectangle gris)
        btnSupprimer.setFocusable(false);//Empêche le bouton d'être sélectionné par défaut
        btnAjouter.setMargin(new Insets(0, 0, 0, 0));//Enlève les espaces autour de l'icône

        btnSupprimer.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) { }

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        btnSupprimer.setToolTipText("Supprimer un mot de passe");//Ajoute un message au survol du bouton
        menu.addSeparator();//Ajoute une séparation à gauche du bouton "Supprimer un mdp"
        menu.add(btnSupprimer);
        menu.addSeparator();//Ajoute une séparation à droite du bouton "Supprimer un mdp"

        JButton btnModifier = new JButton(modifierIcon);
        btnModifier.setFocusPainted(false);//Empêche le bouton d'être sélectionné par défaut (rectangle gris)
        btnModifier.setFocusable(false);//Empêche le bouton d'être sélectionné par défaut
        btnAjouter.setMargin(new Insets(0, 0, 0, 0));//Enlève les espaces autour de l'icône

        btnModifier.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        btnModifier.setToolTipText("Modifier un mot de passe");//Ajoute un message au survol du bouton
        menu.add(btnModifier);
        menu.add(Box.createHorizontalGlue());//Ajoute un espacement à droite du dernier bouton pour centrer

        this.add(menu, BorderLayout.NORTH);
        tableau = new JTable(modele);
        tableau.getTableHeader().setReorderingAllowed(false);
        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
        this.setVisible(true);
    }
}
