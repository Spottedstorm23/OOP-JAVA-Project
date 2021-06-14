package Movement;
import javax.swing.*;
public class Variables {


    static JFrame jf1; //JFrame erzeugen
    static int screenwidth = 800, screenheight = 600;

    static int x = 20, y = 185; //Spieler 1
    static int gegnerx = 755, gegnery = 185; //Gegner (Spieler 2)
    static int ball_x = 200, ball_y =200; //Spielball

    static boolean moveUp = false, moveDown = false, moveLeft = false, moveRight = false;

    static int playerPoints = 0, gegnerPoints = 0;

    public Variables() {

    }

}
