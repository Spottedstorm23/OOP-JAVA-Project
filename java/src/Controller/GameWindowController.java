package Controller;

import Movement.KeyHandler;
import Other.Highscore;
import Other.Timer;
import View.View;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.awt.event.KeyListener;
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


    KeyHandler keyHandler = new KeyHandler();
    View view = new View();
    Maps map = new Maps();

    public static int timer_count = 120;  //Zählt die Ticks für den Timer
    public static java.util.Timer t = new java.util.Timer(); //Definiert den Timer



    public void initialize() throws IOException {

        byte [][] levelmap = map.getMap();
        view.drawLvl(paneBoard, levelmap);
        view.updateCheese(paneBoard, levelmap);
        view.drawMouse(paneBoard);

        Timer timerObject = new Timer();  //Deklaration der Klasse Timer, für Funktionen
        setLabelTimerText(timerObject.SecToDisplay(timer_count));
        timer();


    }


    /*
    private void execute() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../View/GameWindow.fxml"));
        Parent rootGame = fxmlLoader.load();
        Scene gameScene = new Scene(rootGame);
        setGwcScene(gameScene);
        Stage gameStage = new Stage();
        gameStage.setResizable(false);
        gameStage.initModality(Modality.APPLICATION_MODAL);
        gameStage.initStyle(StageStyle.TRANSPARENT);
        gameStage.setScene(gameScene);
        gameStage.show();
    }
     */

    public void timer() {
    //by Lukas, Label by Selina
    //Der globale Timer, welcher beim GameStart gestartet wird

        Timer timerObject = new Timer();  //Deklaration der Klasse Timer, für Funktionen

        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()-> {
                    if (timer_count <= 0) {
                        t.cancel();
                        t.purge();
                        return;
                    }
                    timer_count--;
                    String display = timerObject.SecToDisplay(timer_count);
                    setLabelTimerText(display);
                });
            };
        };
        t.schedule(tt, 1000, 1000); //Der eigentliche Timer
    }

    public String getLabelTimerText(){
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

    public void handleOnKeyPressed(KeyEvent keyEvent) {

    }

    public void handleOnKeyReleased(KeyEvent keyEvent) {
        System.out.println("taste losgelassen:" + keyEvent.getText());
        //gameMenuStage.hide();

    }

    public void handleOnKeyTyped(KeyEvent keyEvent) {
        Node node = (Node) keyEvent.getSource();
        final Stage stage = (Stage) node.getScene().getWindow();
        Runnable closeGameCallback = new Runnable() {
            @Override
            public void run() {
                //TODO stop Gamelogic/Timer here
                stage.close();
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



        gameMenuStage.show();

    }

    /*
    public void setGwcScene(Scene scene) {
        gwcScene = scene;
    }
     */

}
