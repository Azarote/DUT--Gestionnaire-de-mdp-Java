import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpWindow extends JFrame {


    private JPanel panel1;
    private JButton button1;

    public SignUpWindow(String a){
        super(a);
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Termine l'application à la fermeture de la fenêtre
        setLocationRelativeTo(null); //Centre la fenêtre
        setResizable(false); //Empêche le redimensionnement de la fenêtre

        JPanel mainPanel = new JPanel();
        mainPanel.add(button1);



        setContentPane(mainPanel);
        setVisible(true);
    }
}
