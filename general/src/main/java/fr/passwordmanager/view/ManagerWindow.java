package fr.passwordmanager.view;

import fr.passwordmanager.controller.FileEncrypterDecrypter;
import fr.passwordmanager.controller.ManagePassword;
import fr.passwordmanager.controller.Singleton;
import fr.passwordmanager.model.ModeleTableObjet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * <p>Classe qui gère la fenêtre du Gestionnaire de mots de passe</p>
 *
 * @author Matteo DUFOUR
 * @author Matteo MUNOZ
 */
public class ManagerWindow extends JFrame {
    /**
     * Modèle pour le tableau
     */
    public static ModeleTableObjet modele;

    static {
        try {
            modele = new ModeleTableObjet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tableau pour stocker les mots de passe
     */
    public static JTable tableau;

    /**
     * Pop-up
     */
    final JPopupMenu popupMenu = new JPopupMenu();

    /**
     * <p>Constructeur de la classe ManagerWindow</p>>
     */
    public ManagerWindow() {
        JFrame frame = new JFrame();
        this.setTitle("Gestionnaire de mots de passe");
        this.setSize(650,500);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //Termine l'application à la fermeture de la fenêtre
        this.setLocationRelativeTo(null); //Centre la fenêtre
        this.setResizable(false); //Empêche le redimensionnement de la fenêtre

        ImageIcon icon = new ImageIcon("../general/images/cadenas.png");//Icône
        this.setIconImage(icon.getImage());

        JToolBar menu = new JToolBar();//Crée une barre d'outils pour mettre les boutons
        menu.setFloatable(false);//Empêche le possibilité de déplacer la barre d'outils
        menu.setBackground(new Color(186, 186, 186,255));//Colore le fond de la barre d'outils en gris

        //Bouton pour ajouter un mdp
        ImageIcon ajouterIcon = new ImageIcon("../general/images/icons/ajouter_icon.jpg");//Icône Ajouter un mot de passe
        JButton btnAjouter = new JButton(ajouterIcon);
        btnAjouter.setFocusPainted(false);//Empêche le bouton d'être sélectionné par défaut (rectangle gris)
        btnAjouter.setFocusable(false);//Empêche le bouton d'être sélectionné par défaut
        btnAjouter.setMargin(new Insets(0, 0, 0, 0));//Enlève les espaces autour de l'icône

            //Si l'utilisateur clique sur le bouton pour ajouter un mdp
            btnAjouter.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new AddPassword();
                }//Lance la vue pour créer un mot de passe

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

        //Bouton pour supprimer un mdp
        ImageIcon supprimerIcon = new ImageIcon("../general/images/icons/supprimer_icon.jpg");//Icône Supprimer un mot de passe
        JButton btnSupprimer = new JButton(supprimerIcon);
        btnSupprimer.setFocusPainted(false);//Empêche le bouton d'être sélectionné par défaut (rectangle gris)
        btnSupprimer.setFocusable(false);//Empêche le bouton d'être sélectionné par défaut
        btnSupprimer.setMargin(new Insets(0, 0, 0, 0));//Enlève les espaces autour de l'icône

        //TODO Faire la fonction Supprimer un mdp
        btnSupprimer.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //TODO confirmation oui / non
                ManagePassword.deletePassword();
            }

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

        //Bouton pour modifier un mdp
        ImageIcon modifierIcon = new ImageIcon("../general/images/icons/modifier_icon.jpg");//Icône Modifier un mot de passe
        JButton btnModifier = new JButton(modifierIcon);
        btnModifier.setFocusPainted(false);//Empêche le bouton d'être sélectionné par défaut (rectangle gris)
        btnModifier.setFocusable(false);//Empêche le bouton d'être sélectionné par défaut
        btnModifier.setMargin(new Insets(0, 0, 0, 0));//Enlève les espaces autour de l'icône

        //TODO Faire la fonction Modifier un mdp
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

        //Si l'utilisateur veut fermer la fenêtre
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = DialogMessage.confirmDialog("Êtes-vous sur de vouloir fermer le gestionnaire ?\nLes données seront sauvegardées.","Confirmation");
                if (result == JOptionPane.YES_OPTION) {
                    try {
                        ManagePassword.ListSaving();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    if (new File("../general/src/data.json").exists()){
                        String passwordHashed = Singleton.getInstance().getInfo();
                        FileEncrypterDecrypter.encryptFile(passwordHashed.substring(0, 16), "../general/src/data.json", "../general/src/data.json");//On chiffre le fichier
                    }
                    System.exit(0);//On ferme la fenêtre
                }
            }
        });

        btnModifier.setToolTipText("Modifier un mot de passe");//Ajoute un message au survol du bouton
        menu.add(btnModifier);
        menu.add(Box.createHorizontalGlue());//Ajoute un espacement à droite du dernier bouton pour centrer

        //Layout pour ajouter un tableau (stockage de mdp)
        this.add(menu, BorderLayout.NORTH);
        tableau = new JTable(modele);
        tableau.getTableHeader().setReorderingAllowed(false);//Empêche de bouger les colonnes
        tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JMenuItem deleteItem = new JMenuItem("Supprimer");
        JMenuItem editItem = new JMenuItem("Modifier");

        deleteItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ManagePassword.deletePassword();
            }
        });

        editItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        popupMenu.add(deleteItem);
        popupMenu.add(editItem);
        tableau.setComponentPopupMenu(popupMenu);

        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

        this.setVisible(true);
    }
}
