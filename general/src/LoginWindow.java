import javax.swing.*;

public class LoginWindow extends JFrame {

    public LoginWindow(String s){
        super(s);
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Termine l'application à la fermeture de la fenêtre
        setLocationRelativeTo(null); //Centre la fenêtre
        setResizable(false); //Empêche le redimensionnement de la fenêtre

        setVisible(true);
    }

}
