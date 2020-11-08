import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class SignUpWindow extends JFrame {


    private JPanel panel1;
    private JButton button1;

    public SignUpWindow(String a){
        super(a);
        setSize(600,370);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Termine l'application à la fermeture de la fenêtre
        setLocationRelativeTo(null); //Centre la fenêtre
        setResizable(false); //Empêche le redimensionnement de la fenêtre
        setLayout(null);

        //Label demandant d'entrer un nouveau mot de passe
        JLabel newPassword = new JLabel("Nouveau mot de passe");
        newPassword.setBounds(150,30,290,25);
        add(newPassword);

        //Champ de texte pour saisir le nouveau mot de passe
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150,50,290,25);
        add(passwordField);

        //Label demandant de confirmer le nouveau mot de passe
        JLabel newPasswordConfirmation = new JLabel("Confirmer le nouveau mot de passe");
        newPasswordConfirmation.setBounds(150,80,300,25);
        add(newPasswordConfirmation);

        //Champ de texte pour confirmer le nouveau mot de passe
        JPasswordField passwordFieldConfirmation = new JPasswordField();
        passwordFieldConfirmation.setBounds(150,100,290,25);
        add(passwordFieldConfirmation);

        //Bouton pour valider l'opération
        JButton validateButton = new JButton("Valider");
        validateButton.setBounds(150,140,150,25);
        add(validateButton);

        //Labels affichant les critères à respecter pour un mot de passe valide
        JLabel label1 = new JLabel("ATTENTION", SwingConstants.CENTER);
        label1.setFont(new Font("Helvetica", Font.PLAIN, 17));
        label1.setForeground(Color.RED);
        label1.setBounds(0,210,600,30);
        add(label1);

        JLabel label2 = new JLabel("Le mot de passe doit contenir 8 caractères minimum dont :", SwingConstants.CENTER);
        label2.setFont(new Font("Helvetica", Font.PLAIN, 14));
        label2.setForeground(Color.RED);
        label2.setBounds(0,230,600,30);
        add(label2);

        JLabel label3 = new JLabel("- au moins 6 lettres", SwingConstants.CENTER);
        label3.setFont(new Font("Helvetica", Font.PLAIN, 14));
        label3.setForeground(Color.RED);
        label3.setBounds(0,245,600,30);
        add(label3);

        JLabel label4 = new JLabel("- au moins 2 chiffres", SwingConstants.CENTER);
        label4.setFont(new Font("Helvetica", Font.PLAIN, 14));
        label4.setForeground(Color.RED);
        label4.setBounds(0,260,600,30);
        add(label4);

        setVisible(true);

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    File f = new File("general/src/password.dat");

                    if (f.createNewFile())
                        System.out.println("Fichier créé");
                    else
                        System.out.println("Fichier déjà existant");
                }
                catch(Exception ex)
                {
                    System.err.println(ex);
                }
            }
        });
    }
}
