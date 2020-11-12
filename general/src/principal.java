import javax.swing.*;
import java.io.File;

public class principal {

    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        File data = new File("general/src/data.dat");

        if(data.exists())
            new LoginWindow();
        else
            new SignUpWindow();
    }
}