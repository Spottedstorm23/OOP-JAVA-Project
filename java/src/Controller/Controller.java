package Controller;

import Music.Music;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    /* LatestScores.fxml */
    /*
    @FXML
    private AnchorPane paneLatestScores;
    @FXML
    private Label last1ScoreLabel;
    @FXML
    private Label last2ScoreLabel;
    @FXML
    private Label last3ScoreLabel;
    @FXML
    private Label last4ScoreLabel;
    @FXML
    private Label last5ScoreLabel;
    @FXML
    private Label gameModeScoresLabel;
    @FXML
    private Button changeModeScoresButton;
    @FXML
    private Button closeScoresButton;
    */
    @FXML
    private AnchorPane paneLatestScores;
    @FXML
    private TextField latestScoresTextField1;
    @FXML
    private TextField latestScoresTextField2;
    @FXML
    private TextField latestScoresTextField3;
    @FXML
    private TextField latestScoresTextField4;
    @FXML
    private TextField latestScoresTextField5;
    @FXML
    private Label gameModeScoresLabel;
    @FXML
    private Button changeModeScoresButton;
    @FXML
    private Button closeScoresButton;
    @FXML
    private GridPane latestScoresGridPane;

    public static LatestScoresController latestScoresController = new LatestScoresController();

    public void initialize() throws IOException {
    }

    // Menu
    public void startButtonClicked(ActionEvent actionEvent) throws IOException {
        AnchorPane gameBoardPane = FXMLLoader.load(getClass().getResource("../View/GameWindow.fxml"));
        System.out.println("StartButton");
        menuPane.getChildren().addAll(gameBoardPane);
        // gameBoardPane wird direkt auf die menuPane draufgeklatscht --> theoretisch befindet es sich noch drunter!
    }

    // Menu
    public void latestScoresButtonClicked(ActionEvent actionEvent) throws IOException {
        /*
        AnchorPane paneLatestScores = FXMLLoader.load(getClass().getResource("../View/LatestScores.fxml"));
        System.out.println("latestScoresButton");
        Scene latestScoresScene = new Scene(paneLatestScores);
        Stage latestScoresStage = new Stage();
        latestScoresStage.initStyle(StageStyle.TRANSPARENT);
        latestScoresStage.setResizable(false);
        latestScoresStage.initModality(Modality.APPLICATION_MODAL);
        latestScoresStage.setScene(latestScoresScene);
        // paneLatestScores.setStyle("-fx-border-color: #bfbfbf;"); // setzt HG grau
        // https://stackoverflow.com/questions/31560908/i-want-to-make-border-around-three-sides-of-anchorpane-not-four
        //paneLatestScores.setStyle("-fx-background-color: #2c2f33;"); // setzt HG schwarz, border weg
        latestScoresStage.setX(((Toolkit.getDefaultToolkit().getScreenSize().width) / 2) - ((paneLatestScores.getPrefWidth()) / 2));//verschiebung auf X-Achse
        latestScoresStage.setY(((Toolkit.getDefaultToolkit().getScreenSize().height) / 2) - ((paneLatestScores.getPrefHeight()) / 2));//verschiebung auf Y- Achse
        // readLatestScores();
        latestScoresStage.show();
         */

        /*
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/LatestScores.fxml"));
        menuPane = fxmlLoader.load();
        LatestScoresController latestScoresController = fxmlLoader.getController();
         */

        // Controller.latestScoresController.displayLatestScores();
        // https://stackoverflow.com/questions/63185120/java-how-to-call-method-in-another-class


        System.out.println("displayLatestScores()");
        // AnchorPane paneLatestScores = FXMLLoader.load(getClass().getResource("../View/LatestScores.fxml"));

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/LatestScores.fxml"));
        AnchorPane paneLatestScores = fxmlLoader.load();
        LatestScoresController latestScoresController = fxmlLoader.getController();

        System.out.println("latestScoresButton");
        Scene latestScoresScene = new Scene(paneLatestScores);
        Stage latestScoresStage = new Stage();
        latestScoresStage.initStyle(StageStyle.TRANSPARENT);
        latestScoresStage.setResizable(false);
        latestScoresStage.initModality(Modality.APPLICATION_MODAL);
        latestScoresStage.setScene(latestScoresScene);
        latestScoresStage.setX(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-((paneLatestScores.getPrefWidth())/2));//verschiebung auf X-Achse
        latestScoresStage.setY(((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-((paneLatestScores.getPrefHeight())/2));//verschiebung auf Y- Achse

        //readLatestScores();

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

    public void displayLatestScores() throws IOException {
        System.out.println("displayLatestScores()");
        // AnchorPane paneLatestScores = FXMLLoader.load(getClass().getResource("../View/LatestScores.fxml"));

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/LatestScores.fxml"));
        AnchorPane paneLatestScores = fxmlLoader.load();
        Controller latestScoresController = fxmlLoader.getController();

        System.out.println("latestScoresButton");
        Scene latestScoresScene = new Scene(paneLatestScores);
        Stage latestScoresStage = new Stage();
        latestScoresStage.initStyle(StageStyle.TRANSPARENT);
        latestScoresStage.setResizable(false);
        latestScoresStage.initModality(Modality.APPLICATION_MODAL);
        latestScoresStage.setScene(latestScoresScene);
        latestScoresStage.setX(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-((paneLatestScores.getPrefWidth())/2));//verschiebung auf X-Achse
        latestScoresStage.setY(((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-((paneLatestScores.getPrefHeight())/2));//verschiebung auf Y- Achse

        //readLatestScores();

        latestScoresStage.show();
    }

    public void changeModeScoresButtonClicked(ActionEvent actionEvent) {
    }

    public void closeScoresButtonClicked(ActionEvent actionEvent) {
    }
}
