package Controller;

import Music.Music;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;

import java.awt.Toolkit;

public class Controller {
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

    /* Menu.fxml */
    @FXML
    private Button latestButton;
    @FXML
    private Button startButton;
    @FXML
    private Button chaseModeButton;
    @FXML
    private Button escapeModeButton;
    @FXML
    private Button tutorialButton;
    @FXML
    private Button exitButton;
    @FXML
    private AnchorPane menuPane;

    /* tutorial.fxml */
    @FXML
    private AnchorPane tutorialPane;
    @FXML
    private VBox tutorialVBox;
    @FXML
    private Button exitTutorialButton;

    public void initialize() throws IOException {
    }

    // Menu
    public void startButtonClicked(ActionEvent actionEvent) throws IOException {
        System.out.println("startButtonClicked()");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../View/GameWindow.fxml"));
        Parent rootGame = fxmlLoader.load();
        Scene latestScoresScene = new Scene(rootGame);
        Stage latestScoresStage = new Stage();
        latestScoresStage.setResizable(false);
        latestScoresStage.initModality(Modality.APPLICATION_MODAL);
        latestScoresStage.setScene(latestScoresScene);
        latestScoresStage.show();

    }

    // Menu
    public void latestScoresButtonClicked(ActionEvent actionEvent) throws IOException {
        System.out.println("displayLatestScores()");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../View/LatestScores.fxml"));
        Parent root = fxmlLoader.load();
        Scene latestScoresScene = new Scene(root);
        Stage latestScoresStage = new Stage();
        latestScoresStage.initStyle(StageStyle.TRANSPARENT);
        latestScoresStage.setResizable(false);
        latestScoresStage.initModality(Modality.APPLICATION_MODAL);
        latestScoresStage.setScene(latestScoresScene);
        latestScoresStage.show();
    }

    // Menu
    public void chaseModeButtonClicked(ActionEvent actionEvent) {

    }

    // Menu
    public void escapeModeButtonClicked(ActionEvent actionEvent) {
    }

    // Menu
    public void tutorialButtonClicked(ActionEvent actionEvent) throws IOException {
        Music music = new Music();
        VBox tutorialVBox = FXMLLoader.load(getClass().getResource("../View/tutorial.fxml"));

        Scene sceneTutorial = new Scene(tutorialVBox);

        Stage tutorial = new Stage();
        tutorial.setTitle("Tutorial");
        tutorial.setResizable(false);
        tutorial.initModality(Modality.APPLICATION_MODAL);
        tutorial.setScene(sceneTutorial);
        tutorial.initStyle(StageStyle.TRANSPARENT);

        tutorial.setX(((Toolkit.getDefaultToolkit().getScreenSize().width) / 2) - ((tutorialVBox.getPrefWidth()) / 2));//verschiebung auf X-Achse
        tutorial.setY(((Toolkit.getDefaultToolkit().getScreenSize().height) / 2) - ((tutorialVBox.getPrefHeight()) / 2));//verschiebung auf Y- Achse

        tutorial.show();//ZEIGT DAS DING - NICH LÖSCHEN !!!!!!!!!!!!!!!
/*
        System.out.println(Toolkit.getDefaultToolkit().getScreenSize().width + " x "
                + Toolkit.getDefaultToolkit().getScreenSize().height);                  //=> 1920 x 1080
        System.out.println(tutorialVBox.getWidth()+" x "+(tutorialVBox.getHeight())); //=> 640.0 x 400.0
        System.out.println(((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-((tutorialVBox.getHeight())/2));//=>340
        System.out.println(((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-200); //=>340
        System.out.println(tutorialVBox.getHeight()); //=> 400

*/

        music.playMusic(true);


        System.out.println(music.isPlaying);
    }

    // Tutorial
    public void exitTutorialButtonClicked(ActionEvent actionEvent) throws IOException {
        Music music = new Music();
        music.playMusic(false);

        System.out.println(music.isPlaying);
        // close  stage
        Stage stage = (Stage) exitTutorialButton.getScene().getWindow();
        stage.close();


    }

    // Menu
    public void exitButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
        System.exit(0);
    }
}
