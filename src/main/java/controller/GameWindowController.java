package controller;

import other.OurTimer;
import other.Highscore;
import view.View;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.TimerTask;

public class GameWindowController {


    @FXML
    private ImageView imageMouse1;
    @FXML
    private ImageView imageMouse2;
    @FXML
    private ImageView imageMouse3;
    @FXML
    private Label labelCurrentMode;
    @FXML
    private AnchorPane paneBoard;

    @FXML
    private Label labelTimer;
    @FXML
    private Button exitButton;
    @FXML
    private Label labelHighscore;
    @FXML
    private Label labelScore;


    View view = new View();
    byte[][] levelmap;
    private final Mode mode = new Mode();

    short mouseLives = 3;
    short randomCat = 1;

    boolean escPressed = false;
    String[] keyPressed = {"zero", "down", "down", "down"};
    /*
    0 Maus
    1 Katze 1
    2 Katze 2
    3 Katze 3
     */

    public static int timerCount;  //counts tics for timer
    int score = 0;
    boolean quited;

    public void initialize() throws IOException {
        if (mode.getMode().equals("CheeseChase")) {
            setLivesVisible(false);
            labelCurrentMode.setText("Cheese Chase");
        } else {
            labelCurrentMode.setText("Escape the Cats");
        }
        newLevel();
        timerCount = 1500; //In secs*5
        quited = false;
        OurTimer timerObject = new OurTimer();  //declaring the class Timer, for a function
        setLabelTimerText(timerObject.SecToDisplay(timerCount / 5));
        timer();
        setLabelHighscore();
    }

    public void timer() {
        //by Lukas, Label by Selina
        //the global timer starts with Gamestart
        java.util.Timer t = new java.util.Timer(); //define Timer

        OurTimer timerObject = new OurTimer();  //declaring the class Timer, for a function
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (timerCount < 0 || mouseLives == 0) {
                        Highscore highscoreObject = new Highscore();
                        highscoreObject.writeHighscore(score);
                        t.cancel();
                        t.purge();
                        openGameOver();
                        return;
                    } else if (getEscPressedStatus() || quited) {
                        t.cancel();
                        t.purge();
                        return;
                    }

                    if (mode.getMode().equals("EscapeCats")) {
                        if (timerCount % 2 == 0) {
                            byte number = (byte) randomCat;
                            short x = (short) view.getCatsXCord(number);
                            short y = (short) view.getCatsYCord(number);
                            catAI(x, y, number);
                        }
                        moveCats(randomCat);
                    }

                    timerCount--;

                    // Updates the timer every 5 passes
                    if (timerCount % 5 == 0) {
                        String display = timerObject.SecToDisplay(timerCount / 5);
                        setLabelTimerText(display);
                    }

                    if (keyPressed[0] != "zero") {
                        moveMouse();
                    }
                });
            }
        };
        t.schedule(tt, 1000, 200); //the actual Timer
    }


    public void setLabelTimerText(String labeltext) {
        labelTimer.setText(labeltext);
    }

    public void quitButtonClicked(ActionEvent actionEvent) {
        quited = true;
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    public void handleOnKeyPressed(KeyEvent keyEvent) throws InterruptedException {
        // reads keyboard input, sets variable
        if (keyEvent.getCode() == KeyCode.ESCAPE) {
            setEscPressed(true);
        }
        switch (keyEvent.getCode()) {
            case A:
            case LEFT: {
                setKeyPressed("left", 0);
                break;
            }
            case S:
            case DOWN: {
                setKeyPressed("down", 0);
                break;
            }
            case D:
            case RIGHT: {
                setKeyPressed("right", 0);
                break;
            }
            case W:
            case UP: {
                setKeyPressed("up", 0);
                break;
            }
            default: {
                setKeyPressed("zero", 0);
                break;
            }
        }
        if (keyEvent.getCode().isArrowKey()) {
            handleOnKeyTyped(keyEvent);
        }
    }

    public void handleOnKeyReleased(KeyEvent keyEvent) {

    }

    public void randomCat() {
        //by Cora
        // choses a random cat out of the 3
        this.randomCat = (short) (Math.random() * 3 + 1);
    }

    public void handleOnKeyTyped(KeyEvent keyEvent) {
        if (escPressed) {
            openGameMenu(keyEvent);
        }
    }

    public void setEscPressed(boolean status) {
        this.escPressed = status;
    }

    public boolean getEscPressedStatus() {
        return escPressed;
    }

    public void setKeyPressed(String value, int number) {
        this.keyPressed[number] = value;
    }

    public void resetKeyPressed() {
        this.keyPressed[0] = "zero";
        this.keyPressed[1] = "down";
        this.keyPressed[2] = "down";
        this.keyPressed[3] = "down";
    }

    public void moveMouse() {
        //by Cora
        // checks for walls, then moves mouse in given direction
        short x = (short) view.getMouseX();
        short y = (short) view.getMouseY();

        boolean isWall = checkWall(x, y, (byte) 0);

        if (!isWall) {
            switch (keyPressed[0]) {
                case "left": {
                    view.setmouseDirection("left");
                    view.setMouseX(x - 25);
                    break;
                }
                case "right": {
                    view.setmouseDirection("right");
                    view.setMouseX(x + 25);
                    break;
                }
                case "up": {
                    view.setmouseDirection("up");
                    view.setMouseY(y - 25);
                    break;
                }
                case "down": {
                    view.setmouseDirection("down");
                    view.setMouseY(y + 25);
                    break;
                }
                default: {
                    return;
                }
            }
            if(mode.getMode().equals("EscapeCats")){
                checkCatAndMouse(randomCat);

            }
            view.drawMouse(paneBoard);
            collectCheese();
        }


    }

    public void moveCats(int number) {
        //by Cora
        // checks for walls, then moves cat in given direction
        short x = (short) view.getCatsXCord(number);
        short y = (short) view.getCatsYCord(number);

        boolean isWall = checkWall(x, y, (byte) number);
        if (!isWall) {
            switch (keyPressed[number]) {
                case "left": {
                    view.setCatDirections(number, "left");
                    view.setCatsXCord(number, x - 25);
                    break;
                }
                case "right": {
                    view.setCatDirections(number, "right");
                    view.setCatsXCord(number, x + 25);
                    break;
                }
                case "up": {
                    view.setCatDirections(number, "up");
                    view.setCatsYCord(number, y - 25);
                    break;
                }
                case "down": {
                    view.setCatDirections(number, "down");
                    view.setCatsYCord(number, y + 25);
                    break;
                }
                default: {
                    return;
                }
            }
            view.drawCats(paneBoard, (short) number);
            checkCatAndMouse((short) number);
        }
    }

    public void newLevel() {
        //by Cora
        // gets a new Map from Maps
        //draws level, cheese and mouse spawn, if necessary also cat
        Maps map = new Maps();
        byte[][] newLevelMap = map.getMap();
        this.levelmap = newLevelMap;
        view.clear(paneBoard);
        view.drawLvl(paneBoard, newLevelMap);
        view.updateCheese(paneBoard, newLevelMap);
        view.drawMouse(paneBoard);
        if (mode.getMode().equals("EscapeCats")) {
            randomCat();
            view.drawCats(paneBoard, randomCat);
        }
        resetKeyPressed();
    }


    public void collectCheese() {
        //by Cora
        //checks current position (only full squares) for cheese, updates map and level, adds score
        if ((view.getMouseY() % 50) == 0 && (view.getMouseX() % 50) == 0) {
            int x = view.getMouseX() / 50;
            int y = view.getMouseY() / 50;

            switch (levelmap[y][x]) {
                case 2: {
                    score += 50;
                    this.levelmap[y][x] = 1;
                    view.reduceCheeseCount();
                    view.updateCheese(paneBoard, levelmap);
                    break;
                }
                case 3: {
                    score += 100;
                    this.levelmap[y][x] = 1;
                    view.reduceCheeseCount();
                    view.updateCheese(paneBoard, levelmap);
                    break;
                }
            }
            labelScore.setText(String.valueOf(score));

            if (view.getCurentCheeseCount() == 0) {
                newLevel();
            }
        }
    }

    private boolean checkWall(short x, short y, byte id) {
        //by Lukas, inspired by Cora
        //checks if there is a wall
        boolean isWall = false;

        switch (keyPressed[id]) {
            case "left": {
                if (levelmap[y / 50][(x - 25) / 50] == 0 || levelmap[(y + 49) / 50][(x - 25) / 50] == 0) {
                    isWall = true;
                }
                break;
            }
            case "right": {
                if (levelmap[y / 50][(x + 50) / 50] == 0 || levelmap[(y + 49) / 50][(x + 50) / 50] == 0) {
                    isWall = true;
                }
                break;
            }
            case "up": {
                if (levelmap[(y - 25) / 50][x / 50] == 0 || levelmap[(y - 25) / 50][(x + 49) / 50] == 0) {
                    isWall = true;
                }
                break;
            }
            case "down": {
                if (levelmap[(y + 50) / 50][x / 50] == 0 || levelmap[(y + 50) / 50][(x + 49) / 50] == 0) {
                    isWall = true;
                }
                break;
            }
            default: {
                isWall = false;
                break;
            }
        }
        return isWall;
    }

    private void openGameMenu(KeyEvent keyEvent) {
        //by Cora
        // Opens GameMenu and delegates closing- and timerfunction for GameWindow
        Node node = (Node) keyEvent.getSource();
        final Stage stage = (Stage) node.getScene().getWindow();

        Runnable closeGameCallback = new Runnable() {
            @Override
            public void run() {
                stage.close();
            }
        };

        Runnable timerCallback = new Runnable() {
            @Override
            public void run() {
                setEscPressed(false);
                // java.util.Timer t = new java.util.Timer();
                timer();
            }
        };

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("fxml/GameMenu.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException eo) {
            eo.printStackTrace();
            throw new RuntimeException("Could not load GameMenu", eo);
        }
        Scene gameMenuScene = new Scene(root);
        Stage gameMenuStage = new Stage();
        gameMenuStage.initStyle(StageStyle.TRANSPARENT);
        gameMenuStage.setResizable(false);
        gameMenuStage.initModality(Modality.APPLICATION_MODAL);
        gameMenuStage.setScene(gameMenuScene);
        gameMenuStage.getIcons().add(new Image(this.getClass().getClassLoader().getResourceAsStream("images/Projekt_-_Kaesehaufen.png")));
        GameMenuController gameMenuController = fxmlLoader.getController();
        gameMenuController.setReturnMenuCallback(closeGameCallback);
        gameMenuController.setTimerCallback(timerCallback);
        gameMenuStage.show();

    }

    private void openGameOver() {
        //by Cora
        // Opens GameOverScreen and delegates closingfct for GameWindow
        final Stage stage = (Stage) exitButton.getScene().getWindow();

        Runnable closeGameCallback = new Runnable() {
            @Override
            public void run() {
                stage.close();
            }
        };
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("fxml/GameOver.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException eo) {
            eo.printStackTrace();
            throw new RuntimeException("Could not load GameOver", eo);
        }
        Scene gameOverScene = new Scene(root);
        Stage gameOverStage = new Stage();
        gameOverStage.initStyle(StageStyle.TRANSPARENT);
        gameOverStage.setResizable(false);
        gameOverStage.initModality(Modality.APPLICATION_MODAL);
        gameOverStage.setScene(gameOverScene);
        gameOverStage.getIcons().add(new Image(this.getClass().getClassLoader().getResourceAsStream("images/Projekt_-_Kaesehaufen.png")));
        GameMenuController gameMenuController = fxmlLoader.getController();
        gameMenuController.setReturnMenuCallback(closeGameCallback);
        gameMenuController.setGameOverText();
        gameOverStage.show();

    }

    public void setLabelHighscore() {
        //by Lukas
        Highscore highscoreObject = new Highscore();
        short[] scores = highscoreObject.readHighscore();
        labelHighscore.setText(String.valueOf(scores[0]));
    }

    //out of order
    private String randomDirection() {
        //by Lukas
        //gives you a random direction back
        byte x = (byte) (Math.random() * 4);
        String result = "zero";
        switch (x) {
            case 0:
                result = "up";
                break;
            case 1:
                result = "right";
                break;
            case 2:
                result = "down";
                break;
            case 3:
                result = "left";
                break;
        }
        return result;
    }

    private String dontLookBack(String direction) {
        //by Lukas
        //For CATAI 3.0
        String result;

        switch (direction) {
            case "up":
                result = "down";
                break;
            case "down":
                result = "up";
                break;
            case "right":
                result = "left";
                break;
            case "left":
                result = "right";
                break;
            default:
                result = "zero";
                break;
        }
        return result;
    }

    private void catAI(short x, short y, byte number) {
        //by Lukas
        //THE CATAI -> CAT Artificial Intelligence

        boolean[] catRadar = {true, true, true, true}; //if there is a wall around
        String[] directions = {"up", "right", "down", "left"};
        byte noWall = 0; //counts the possible ways
        String oldkeyPressed = keyPressed[number]; //Saves the old keypressed

        //counts the possible ways without a wall
        //Actualised catRadar (true for possible ways)
        for (byte i = 0; i < 4; i++) {
            keyPressed[number] = directions[i];
            catRadar[i] = checkWall(x, y, number);
            if (!catRadar[i]) {
                noWall++;
            }
        }

        //CATAI 2.0 - Depending on the number of possible paths, a strategic decision is made as to how to proceed:
        switch (noWall) {
            case 1: {
                //if there is just one way: this way is used
                for (byte i = 0; i < 4; i++) {
                    if (!catRadar[i]) {
                        keyPressed[number] = directions[i];
                    }
                }
                break;
            }
            case 2: {
                // There are 2 ways, the cat should choose the way from which it did NOT come
                //makes a new Array with just new paths
                String[] newdirections = new String[noWall + 1];
                byte noWallCount = 0;

                for (byte i = 0; i < 4; i++) {
                    if (!catRadar[i]) {
                        newdirections[noWallCount] = directions[i];
                        noWallCount++;
                    }
                }

                //will use the path she isnt come from
                if (newdirections[0].equals(dontLookBack(oldkeyPressed))) {
                    keyPressed[number] = newdirections[1];
                } else {
                    keyPressed[number] = newdirections[0];
                }
                break;
            }
            case 3:
            case 4: {
                //There are 3 / 4 paths without the path in wich she is coming 2 / 3. she shoud use an random path     //Aus den 2/3 übrigen Wegen soll der Weg zufällig ausgesucht werden

                //makes a new Array with the possible paths and the random number
                String[] newdirections = new String[noWall];
                ;
                byte random = (byte) (Math.random() * (noWall - 1));
                byte noWallCount = 0;

                for (byte i = 0; i < 4; i++) {
                    if (!catRadar[i] && !directions[i].equals(dontLookBack(oldkeyPressed))) {
                        newdirections[noWallCount] = directions[i];
                        noWallCount++;
                    }
                }

                keyPressed[number] = newdirections[random];
                break;
            }
            default: {
                break;
            }
        }
    }

    public void setLivesVisible(boolean state) {
        imageMouse1.setVisible(state);
        imageMouse2.setVisible(state);
        imageMouse3.setVisible(state);

    }

    public void removeLive1() {
        imageMouse1.setVisible(false);
    }

    public void removeLive2() {
        imageMouse2.setVisible(false);
    }

    public void removeLive3() {
        imageMouse3.setVisible(false);
    }

    public void reduceLives() {
        //by Cora
        //checks curent amount of lives, removes the pictures
        this.mouseLives = (short) (mouseLives - 1);
        switch (mouseLives) {
            case 0: {
                removeLive3();
                break;
            }
            case 1: {
                removeLive2();
                break;
            }
            case 2: {
                removeLive1();
                break;
            }
        }
    }

    public void checkCatAndMouse(short cat) {
        //by Cora
        // checks if cat and mouse are on the same field, removes a live if so
        short x_mouse = (short) view.getMouseX();
        short y_mouse = (short) view.getMouseY();
        switch (cat) {
            case 1: {
                short x_cat1 = (short) view.getCatsXCord(1);
                short y_cat1 = (short) view.getCatsYCord(1);
                if (x_mouse == x_cat1 && y_mouse == y_cat1) {
                    reduceLives();
                }
                break;
            }
            case 2:
                short x_cat2 = (short) view.getCatsXCord(2);
                short y_cat2 = (short) view.getCatsYCord(2);
                if (x_mouse == x_cat2 && y_mouse == y_cat2) {
                    reduceLives();
                }
                break;

            case 3:
                short x_cat3 = (short) view.getCatsXCord(3);
                short y_cat3 = (short) view.getCatsYCord(3);
                if (x_mouse == x_cat3 && y_mouse == y_cat3) {
                    reduceLives();
                    break;
                }
                break;

        }
    }
}

