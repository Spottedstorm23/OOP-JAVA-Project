package View;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class View {

    //Important
    int mouseX;
    int mouseY;
    int cat1_X;
    int cat1_Y;
    int cat2_X;
    int cat2_Y;
    int cat3_X;
    int cat3_Y;
    int curentCheeseCount;
    int cheeseCount;
    String mouseDirection = "down";
    String cat1_direction = "down";
    String cat2_direction = "down";
    String cat3_direction = "down";
    int[][] cheeseArray = new int[20][2];


    public void addCheeseCount() {
        //by Cora
        //increases number of cheese
        curentCheeseCount = curentCheeseCount + 1;
    }

    public void reduceCheeseCount() {
        //by Cora
        //decreases number of cheese
        curentCheeseCount = curentCheeseCount - 1;
    }

    public int getCurentCheeseCount() {
        //by Cora
        //returns current number of cheese
        return curentCheeseCount;
    }

    public void setMouseX(int x) {
        //by Cora
        //sets Mouse Coordinate X
        this.mouseX = x;
    }

    public int getMouseX() {
        //by Cora
        //returns Mouse Coordinate X
        return mouseX;
    }

    public void setMouseY(int y) {
        //by Cora
        //sets Mouse Coordinate X
        this.mouseY = y;
    }

    public int getMouseY() {
        //by Cora
        //returns Mouse Coordinate Y
        return mouseY;
    }

    public void setmouseDirection(String state) {
        //by Cora
        //sets the direction in which mouse moves and looks
        this.mouseDirection = state;
    }


    public void setCatDirections(int cat, String state) {
        //by Cora
        //sets the direction in which a given cat moves and looks
        switch (cat) {
            case 1: {
                this.cat1_direction = state;
                break;
            }
            case 2: {
                this.cat2_direction = state;
                break;
            }
            case 3: {
                this.cat3_direction = state;
                break;
            }
        }
    }

    public void setCatsXCord(int cat, int x) {
        //by Cora
        //sets x Coordinate for a given cat
        switch (cat) {
            case 1: {
                this.cat1_X = x;
                break;
            }
            case 2: {
                this.cat2_X = x;
                break;
            }
            case 3: {
                this.cat3_X = x;
                break;
            }
        }

    }

    public void setCatsYCord(int cat, int y) {
        //by Cora
        //sets y Coordinate for a given cat
        switch (cat) {
            case 1: {
                this.cat1_Y = y;
                break;
            }
            case 2: {
                this.cat2_Y = y;
                break;
            }
            case 3: {
                this.cat3_Y = y;
                break;
            }
        }
    }

    public int getCatsXCord(int cat) {
        //by Cora
        //gets x Coordinate for a given cat
        switch (cat) {
            case 1: {
                return cat1_X;
            }
            case 2: {
                return cat2_X;
            }
            case 3: {
                return cat3_X;
            }
            default:
                return 0;
        }

    }

    public int getCatsYCord(int cat) {
        //by Cora
        //gets y Coordinate for a given cat
        switch (cat) {
            case 1: {
                return cat1_Y;
            }
            case 2: {
                return cat2_Y;
            }
            case 3: {
                return cat3_Y;
            }
            default:
                return 0;
        }
    }


    public void drawLvl(Pane root, byte[][] map) {
        //by Cora
        //Draws Level -> only Path and Wall
        Group group = new Group();
        group.setId("level");
        this.curentCheeseCount = 0;

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
                        cheeseArray[curentCheeseCount][0] = x;
                        cheeseArray[curentCheeseCount][1] = y;
                        addCheeseCount();
                    }
                    case 5: {
                        // sets first Cat Coordinates
                        r.setFill(Color.color(221 / 255.0F, 227 / 255.0F, 236 / 255.0F));
                        setCatsXCord(1, cord_x);
                        setCatsYCord(1, cord_y);
                        break;
                    }
                    case 6: {
                        // sets first Cat Coordinates
                        r.setFill(Color.color(221 / 255.0F, 227 / 255.0F, 236 / 255.0F));
                        setCatsXCord(2, cord_x);
                        setCatsYCord(2, cord_y);
                        break;
                    }
                    case 7: {
                        // sets first Cat Coordinates
                        r.setFill(Color.color(221 / 255.0F, 227 / 255.0F, 236 / 255.0F));
                        setCatsXCord(3, cord_x);
                        setCatsYCord(3, cord_y);
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
        }
        cheeseCount = curentCheeseCount;
        ObservableList<Node> list = root.getChildren();
        if (list.size() > 0) {
            Object current = list.get(0);
            if (current.toString().equals("Group[id=level]")) {
                list.remove(current);
            }
        }
        root.getChildren().add(0, group);
    }

    public void updateCheese(Pane root, byte[][] map) {
        //by Cora
        //Updates Cheespiles on the Map
        Group groupCheese = new Group();
        groupCheese.setId("cheese");

        for (int i = 0; i < cheeseCount; i++) {
            int y = cheeseArray[i][1];
            int x = cheeseArray[i][0];
            int cord_y = y * 50;
            int cord_x = x * 50;
            System.out.println("x:" + x + ", y:" + y + "map:" + map[y][x]);
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
                default: {
                    break;
                }
            }
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
        //by Cora
        // Draws the Mouse on Current position
        int mouseX = getMouseX();
        int mouseY = getMouseY();
        Group mouse = new Group();
        mouse.setId("mouse");

        ObservableList<Node> list = root.getChildren();
        if (list.size() > 2) {
            Object current = list.get(2);
            if (current.toString().equals("Group[id=mouse]")) {
                list.remove(current);
            }
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
        list.add(2, mouse);
    }


    public void drawCats(Pane root, short cat) {
        Group cats = new Group();
        cats.setId("cats");
        switch (cat) {
            case 1: {
                int cat1_x = getCatsXCord(1);
                int cat1_y = getCatsYCord(1);
                Rectangle cat_1 = new Rectangle(cat1_x, cat1_y, 50, 50);
                Image cat_1_pic = new Image("./View/images/Projekt_-_Katze1Down.png");
                checkCat1Direction(cat_1_pic);
                cat_1.setFill(new ImagePattern(cat_1_pic));
                cats.getChildren().add(cat_1);

                break;
            }
            case 2:
                int cat2_x = getCatsXCord(2);
                int cat2_y = getCatsYCord(2);
                Rectangle cat_2 = new Rectangle(cat2_x, cat2_y, 50, 50);
                Image cat_2_pic = new Image("./View/images/Projekt_-_Katze2Down.png");
                checkCat2Direction(cat_2_pic);
                cat_2.setFill(new ImagePattern(cat_2_pic));
                cats.getChildren().add(cat_2);
                break;

            case 3:
                int cat3_x = getCatsXCord(3);
                int cat3_y = getCatsYCord(3);
                Rectangle cat_3 = new Rectangle(cat3_x, cat3_y, 50, 50);
                Image cat_3_pic = new Image("./View/images/Projekt_-_Katze3Down.png");
                checkCat3Direction(cat_3_pic);
                cat_3.setFill(new ImagePattern(cat_3_pic));
                cats.getChildren().add(cat_3);
                break;

        }
        ObservableList<Node> list = root.getChildren();
        if (list.size() > 3) {
            Object current = list.get(3);
            if (current.toString().equals("Group[id=cats]")) {
                list.remove(current);
            }
        }
        list.add(3, cats);
    }

    public Image checkCat1Direction(Image pic) {
        switch (cat1_direction) {
            case "left":
                pic = new Image("./View/images/Projekt_-_Katze1.png");
                return pic;
            case "right":
                pic = new Image("./View/images/Projekt_-_Katze1R.png");
                return pic;
            case "up":
                pic = new Image("./View/images/Projekt_-_Katze1Up.png");
                return pic;
            case "down":
                pic = new Image("./View/images/Projekt_-_Katze1Down.png");
                return pic;
            default:
                throw new IllegalStateException("Unexpected value: " + cat1_direction);
        }
    }

    public Image checkCat2Direction(Image pic) {
        switch (cat2_direction) {
            case "left":
                pic = new Image("./View/images/Projekt_-_Katze2.png");
                return pic;
            case "right":
                pic = new Image("./View/images/Projekt_-_Katze2R.png");
                return pic;
            case "up":
                pic = new Image("./View/images/Projekt_-_Katze2Up.png");
                return pic;
            case "down":
                pic = new Image("./View/images/Projekt_-_Katze2Down.png");
                return pic;
            default:
                throw new IllegalStateException("Unexpected value: " + cat2_direction);
        }
    }

    public Image checkCat3Direction(Image pic) {
        switch (cat3_direction) {
            case "left":
                pic = new Image("./View/images/Projekt_-_Katze3.png");
                return pic;
            case "right":
                pic = new Image("./View/images/Projekt_-_Katze3R.png");
                return pic;
            case "up":
                pic = new Image("./View/images/Projekt_-_Katze3Up.png");
                return pic;
            case "down":
                pic = new Image("./View/images/Projekt_-_Katze3Down.png");
                return pic;
            default:
                throw new IllegalStateException("Unexpected value: " + cat3_direction);
        }
    }

    public void clear(AnchorPane root) {
        //by Cora
        //removes former layers
        root.getChildren().removeAll();
    }
}
