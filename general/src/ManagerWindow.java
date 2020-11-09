import javax.swing.*;

public class ManagerWindow extends JFrame {
    public ManagerWindow(String s){
        super(s);
        setSize(1200,750);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Termine l'application à la fermeture de la fenêtre
        setLocationRelativeTo(null); //Centre la fenêtre
        setResizable(false); //Empêche le redimensionnement de la fenêtre

        setVisible(true);
    }
}
