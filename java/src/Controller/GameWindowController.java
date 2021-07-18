package Controller;

import View.View;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.awt.event.KeyEvent;
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

    Scene gwcScene;


    View view = new View();
    Maps map = new Maps();

    public static int timer_count = 120;  //Zählt die Ticks für den Timer
    public static java.util.Timer t = new java.util.Timer(); //Definiert den Timer

    public void initialize() throws IOException {
        /*
        Stage stage = (Stage) exitButton.getScene().getWindow();
        gwcScene.setFill(Color.TRANSPARENT);
        stage.setScene(gwcScene);

         */

        /*
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e);
                if (e.getKeyCode()==KeyEvent.VK_ESCAPE){

                    System.out.println("GameMenu.fxml");
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("../View/GameMenu.fxml"));
                    Parent root = null;
                    try {
                        root = fxmlLoader.load();
                    } catch (IOException eo) {
                        eo.printStackTrace();
                    }
                    Scene tutorialScene = new Scene(root);
                    Stage tutorialStage = new Stage();
                    tutorialStage.initStyle(StageStyle.TRANSPARENT);
                    tutorialStage.setResizable(false);
                    tutorialStage.initModality(Modality.APPLICATION_MODAL);
                    tutorialStage.setScene(tutorialScene);
                    tutorialStage.show();

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

         */
        /*
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.addKeyListener(listener);
        stage.

         */
        // Scene scene = (Scene) exitButton.getScene();
        // scene.setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>() {
        /*
        gwcScene.setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent event) {
                switch (event.getCode()) {
                    case UP: System.out.println("UP");
                    case DOWN: System.out.println("DOWN");
                    case LEFT: System.out.println("LEFT");
                    case RIGHT: System.out.println("RIGHT");
                    case ESCAPE: {
                        System.out.println("GameMenu.fxml");
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("../View/GameMenu.fxml"));
                        Parent root = null;
                        try {
                            root = fxmlLoader.load();
                        } catch (IOException eo) {
                            eo.printStackTrace();
                        }
                        Scene tutorialScene = new Scene(root);
                        Stage tutorialStage = new Stage();
                        tutorialStage.initStyle(StageStyle.TRANSPARENT);
                        tutorialStage.setResizable(false);
                        tutorialStage.initModality(Modality.APPLICATION_MODAL);
                        tutorialStage.setScene(tutorialScene);
                        tutorialStage.show();
                    }
                }
            }
        });
         */

        byte [][] levelmap = map.getMap();
        view.drawLvl(paneBoard, levelmap);
        view.updateCheese(paneBoard, levelmap);
        view.drawMouse(paneBoard);

        setLabelTimerText(""+timer_count);
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
                    System.out.println(timer_count);
                    setLabelTimerText(""+timer_count);
                    System.out.println(labelTimer);
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
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    /*
    public void setGwcScene(Scene scene) {
        gwcScene = scene;
    }
     */

}
