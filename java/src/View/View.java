package View;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class View {

    //Important
    int mouseX;
    int mouseY;
    int cheeseCount;
    String mouseDirection = "down";

    public void addCheeseCount() {
        cheeseCount = cheeseCount + 1;
    }

    public void reduceCheeseCount() {
        cheeseCount = cheeseCount - 1;
    }

    public int getCheeseCount() {
        return cheeseCount;
    }

    public void setMouseX(int x) {
        //sets Mouse Coordinate X
        this.mouseX = x;
    }

    public int getMouseX() {
        //returns Mouse Coordinate X
        return mouseX;
    }

    public void setmouseDirection(String state) {
        this.mouseDirection = state;
    }

    public void setMouseY(int y) {
        //sets Mouse Coordinate X
        this.mouseY = y;
    }

    public int getMouseY() {
        //returns Mouse Coordinate Y
        return mouseY;
    }

    public void drawLvl(Pane root, byte[][] map) {
        //Draws Level -> only Path and Wall
        //by Cora
        Group group = new Group();
        group.setId("level");
        this.cheeseCount = 0;

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
                    case 2:
                    case 3: {
                        addCheeseCount();
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

        ObservableList<Node> list = root.getChildren();
        if (list.size() > 0) {
            Object last = list.get(0);
            if (last.toString().equals("Group[id=cheese]")) {
                list.remove(last);
            }
        }
        root.getChildren().add(0, group);
    }

    public void updateCheese(Pane root, byte[][] map) {
        //Updates Cheespiles on the Map
        //by Cora
        Group groupCheese = new Group();
        groupCheese.setId("cheese");


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

        ObservableList<Node> list = root.getChildren();
        if (list.size() > 1) {
            Object last = list.get(1);
            if (last.toString().equals("Group[id=cheese]")) {
                list.remove(last);
            }
        }
        root.getChildren().add(1, groupCheese);
    }


    public void drawMouse(Pane root) {
        // Draws the Mouse on Current position
        //by Cora
        int mouseX = getMouseX();
        int mouseY = getMouseY();
        Group mouse = new Group();
        mouse.setId("mouse");

        ObservableList<Node> list = root.getChildren();
        Object last = list.get(list.size() - 1);
        if (last.toString().equals("Group[id=mouse]")) {
            list.remove(last);
        }

        Rectangle r_mouse = new Rectangle(mouseX, mouseY, 50, 50);
        Image mousepic;
        switch (mouseDirection) {
            case "left":
                mousepic = new Image("./View/images/Projekt_-_Maus.png");
                break;
            case "right":
                mousepic = new Image("./View/images/Projekt_-_MausR.png");
                break;
            case "up":
                mousepic = new Image("./View/images/Projekt_-_MausUp.png");
                break;
            case "down":
                mousepic = new Image("./View/images/Projekt_-_MausDown.png");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + mouseDirection);
        }
        r_mouse.setFill(new ImagePattern(mousepic));
        mouse.getChildren().add(r_mouse);
        list.add(mouse);
    }
}
