package View;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class View {

    //Important
    int mouseX;
    int mouseY;


    public int setMouseX(int x) {
        //sets Mouse Coordinate X
        this.mouseX = x;
        return mouseX;
    }

    public int getMouseX() {
        //returns Mouse Coordinate X
        return mouseX;
    }


    public int setMouseY(int y) {
        //sets Mouse Coordinate X
        this.mouseY = y;
        return mouseY;
    }

    public int getMouseY() {
        //returns Mouse Coordinate Y
        return mouseY;
    }

    public void drawLvl(Pane root, byte[][] map) {
        //Draws Level -> only Path and Wall
        //by Cora
        Group group = new Group();
        int y = 0;
        for (y = 0; y < 13; y++) {
            int x = 0;
            for (x = 0; x < 19; x++) {
                int cord_y = y * 50;
                int cord_x = x * 50;
                Rectangle r = new Rectangle(cord_x, cord_y, 50, 50);

                switch (map[y][x]) {
                    case 0: {
                        // Case for Wallcolor
                        r.setFill(Color.color(20 / 255.0F, 47 / 255.0F, 82 / 255.0F));
                        break;
                    }
                    case 4: {
                        // sets first Mouse Coordinates
                        r.setFill(Color.color(221 / 255.0F, 227 / 255.0F, 236 / 255.0F));
                        setMouseX(cord_x);
                        setMouseY(cord_y);
                        break;
                    }
                    default: {
                        // Case for Pathcolor
                        r.setFill(Color.color(221 / 255.0F, 227 / 255.0F, 236 / 255.0F));
                        break;
                    }
                }
                group.getChildren().add(r);

            }
            System.out.println("");
        }
        root.getChildren().add(group);
    }

    public void updateCheese(Pane root, byte[][] map) {
        //Updates Cheespiles on the Map
        //by Cora
        Group groupCheese = new Group();
        int y = 0;
        for (y = 0; y < 13; y++) {
            int x = 0;
            for (x = 0; x < 19; x++) {
                int cord_y = y * 50;
                int cord_x = x * 50;

                switch (map[y][x]) {
                    case 2: {
                        Rectangle r_cheese = new Rectangle(cord_x, cord_y, 50, 50);
                        Image cheese = new Image("./View/images/Projekt_-_Kaese.png");
                        r_cheese.setFill(new ImagePattern(cheese));
                        groupCheese.getChildren().add(r_cheese);
                        break;
                    }
                    case 3: {
                        Rectangle r_cheese = new Rectangle(cord_x, cord_y, 50, 50);
                        Image cheesepile = new Image("./View/images/Projekt_-_Kaesehaufen.png");
                        r_cheese.setFill(new ImagePattern(cheesepile));
                        groupCheese.getChildren().add(r_cheese);
                        break;
                    }
                }
            }
            System.out.println("");
        }
        root.getChildren().add(groupCheese);
    }


    public void drawMouse(Pane root) {
        // Draws the Mouse on Current position
        //by Cora
        int mouseX = getMouseX();
        int mouseY = getMouseY();
        Rectangle r_mouse = new Rectangle(mouseX, mouseY, 50, 50);
        Image mousepic = new Image("./View/images/Projekt_-_Maus.png");
        r_mouse.setFill(new ImagePattern(mousepic));
        root.getChildren().add(r_mouse);
    }
}
