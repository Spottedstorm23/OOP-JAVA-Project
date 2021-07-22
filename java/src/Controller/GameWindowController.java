package Controller;

import Other.Timer;
import View.View;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    /* GameWindow.fxml */
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
    private AnchorPane gameBoardPane;
    @FXML
    private Label labelTimer;
    @FXML
    private Button exitButton;

    View view = new View();
    Maps map = new Maps();
    byte[][] levelmap = map.getMap();

    boolean escPressed = false;
    String keyPressed;

    public static int timer_count;  //Zählt die Ticks für den Timer
    // public static java.util.Timer t = new java.util.Timer(); //Definiert den Timer

    // neu
    private GameMenuController gameMenuController = new GameMenuController();

    public void initialize() throws IOException {
        newLevel();
        setLabelTimerText("" + timer_count);
        timer_count = 300;
        //timer();
        Timer timerObject = new Timer();  //Deklaration der Klasse Timer, für Funktionen
        setLabelTimerText(timerObject.SecToDisplay(timer_count));
        timer();
    }

    public void timer() {
    //by Lukas, Label by Selina
    //Der globale Timer, welcher beim GameStart gestartet wird

        // neu , test
        java.util.Timer t = new java.util.Timer();


        Timer timerObject = new Timer();  //Deklaration der Klasse Timer, für Funktionen
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (timer_count <= 0 || getEscPressedStatus()==true) {
                        t.cancel();
                        t.purge();
                        return;
                    }
                    timer_count--;
                    String display = timerObject.SecToDisplay(timer_count);
                    setLabelTimerText(display);
                    System.out.println(labelTimer.getText()+"\n");
                });
            }
        };
        t.schedule(tt, 1000, 1000); //Der eigentliche Timer
    }

    public String getLabelTimerText() {
        return this.labelTimer.getText();
    }

    public void setLabelTimerText(String labeltext) {
        labelTimer.setText(labeltext);
    }

    public void quitButtonClicked(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    public void handleOnKeyPressed(KeyEvent keyEvent) throws InterruptedException {
        if (keyEvent.getCode() == KeyCode.ESCAPE) {
            setEscPressed(true);
        }
        switch (keyEvent.getCode()) {
            case A:
            case LEFT: {
                setKeyPressed("left");
                break;
            }
            case S:
            case DOWN: {
                setKeyPressed("down");
                break;
            }
            case D:
            case RIGHT: {
                setKeyPressed("right");
                break;
            }
            case W:
            case UP: {
                setKeyPressed("up");
                break;
            }
            default: {
                setKeyPressed("zero");
                break;
            }
        }
        if (keyEvent.getCode().isArrowKey()) {
            handleOnKeyTyped(keyEvent);
        }
    }

    public void handleOnKeyReleased(KeyEvent keyEvent) {

    }

    public void handleOnKeyTyped(KeyEvent keyEvent) {
        switch (keyPressed){
            case "left": {
                System.out.println("left");
                moveLeft();
                break;
            }
            case "right": {
                System.out.println("right");
                moveRight();
                break;
            }
            case "down": {
                System.out.println("down");
                moveDown();
                break;
            }
            case "up": {
                System.out.println("up");
                moveUp();
                break;
            }
            case "zero": {
                System.out.println("zero");
                break;
            }
        }
        if (escPressed) {
            openGameMenu(keyEvent);
        }
    }

    public void setEscPressed(boolean status) {
        this.escPressed = status;
    }

    public boolean getEscPressedStatus(){
        return escPressed;
    }

    public void setKeyPressed(String value) {
        this.keyPressed = value;
    }


    public void moveRight() {
        if (levelmap[view.getMouseY()/50][view.getMouseX()/50] != 0) {
            view.setMouseX(view.getMouseX() + 25);
            view.drawMouse(paneBoard);
        }
    }

    public void moveLeft() {
        if (levelmap[view.getMouseY()/50][view.getMouseX()/50] != 0) {
            view.setMouseX(view.getMouseX() - 25);
            view.drawMouse(paneBoard);
        }
    }

    public void moveUp() {
        if (levelmap[view.getMouseY()/50][view.getMouseX()/50] != 0) {
            view.setMouseY(view.getMouseY() - 25);
            view.drawMouse(paneBoard);
        }
    }

    public void moveDown() {
        if (levelmap[view.getMouseY()/50][view.getMouseX()/50] != 0) {
            view.setMouseY(view.getMouseY() + 25);
            view.drawMouse(paneBoard);
        }
    }

    public void newLevel() {
        view.drawLvl(paneBoard, levelmap);
        view.updateCheese(paneBoard, levelmap);
        view.drawMouse(paneBoard);
    }

    public void collectCheese() {
        int x = view.getMouseX() / 50;
        int y = view.getMouseY() / 50;

        switch (levelmap[y][x]) {
            case 2: {
                //add score +50
                this.levelmap[y][x] = 1;
                view.reduceCheeseCount();
                view.updateCheese(paneBoard, levelmap);
                break;
            }
            case 3: {
                //add score +100
                this.levelmap[y][x] = 1;
                view.reduceCheeseCount();
                view.updateCheese(paneBoard, levelmap);
                break;
            }
        }
    }

    private void openGameMenu(KeyEvent keyEvent) {
        //setEscPressed(false);
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
        fxmlLoader.setLocation(getClass().getResource("../View/GameMenu.fxml"));
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
        GameMenuController gameMenuController = fxmlLoader.getController();
        gameMenuController.setReturnMenuCallback(closeGameCallback);
        gameMenuController.setTimerCallback(timerCallback);
        gameMenuStage.show();

    }

}
