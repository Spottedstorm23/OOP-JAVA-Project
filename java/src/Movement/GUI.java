package Movement;
import javax.swing.*;

public class GUI {
    public  GUI() {
        Variables.jf1 = new JFrame();
            Variables.jf1.addKeyListener(new KeyHandler()); //Für Tastaturzugriffe
    }
}

