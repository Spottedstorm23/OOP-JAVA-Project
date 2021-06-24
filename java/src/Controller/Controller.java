package Controller;

import Music.music;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Toolkit;
import java.util.List;

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

    File latestScoresFile = new File(getClass().getResource("../Resources/latestScoresTxt.txt").getFile());
    // https://stackoverflow.com/questions/36068557/how-to-get-the-path-of-a-file-in-my-java-project-when-running-java-from-batch-fi

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
        latestScoresStage.setX(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-((paneLatestScores.getPrefWidth())/2));//verschiebung auf X-Achse
        latestScoresStage.setY(((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-((paneLatestScores.getPrefHeight())/2));//verschiebung auf Y- Achse

        readLatestScores();

        latestScoresStage.show();
    }

    // Menu
    public void chaseModeButtonClicked(ActionEvent actionEvent) {

    }

    // Menu
    public void escapeModeButtonClicked(ActionEvent actionEvent) {
    }

    // Menu
    public void tutorialButtonClicked(ActionEvent actionEvent ) throws IOException {


        VBox tutorialVBox  = FXMLLoader.load(getClass().getResource("../View/tutorial.fxml"));

        Scene sceneTutorial = new Scene(tutorialVBox);

        Stage tutorial = new Stage();
        tutorial.setTitle("Tutorial");
        tutorial.setResizable(false);
        tutorial.initModality(Modality.APPLICATION_MODAL);
        tutorial.setScene(sceneTutorial);
        tutorial.initStyle(StageStyle.TRANSPARENT);

        tutorial.setX(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-((tutorialVBox.getPrefWidth())/2));//verschiebung auf X-Achse
        tutorial.setY(((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-((tutorialVBox.getPrefHeight())/2));//verschiebung auf Y- Achse

        tutorial.show();//ZEIGT DAS DING - NICH LÖSCHEN !!!!!!!!!!!!!!!
/*
        System.out.println(Toolkit.getDefaultToolkit().getScreenSize().width + " x "
                + Toolkit.getDefaultToolkit().getScreenSize().height);                  //=> 1920 x 1080
        System.out.println(tutorialVBox.getWidth()+" x "+(tutorialVBox.getHeight())); //=> 640.0 x 400.0
        System.out.println(((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-((tutorialVBox.getHeight())/2));//=>340
        System.out.println(((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-200); //=>340
        System.out.println(tutorialVBox.getHeight()); //=> 400

*/
        music music = new music();
        music.music("java/src/Music/data/Here_Come_The_Raindrops_-_Reed_Mathis (online-audio-converter.com).wav");
    }


    // Tutorial
    public void exitTutorialButtonClicked(ActionEvent actionEvent){
        Stage stage = (Stage) exitTutorialButton.getScene().getWindow();
        stage.close();
        music.stop();

    }

    // Menu
    public void exitButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
        System.exit(0);
    }

    // LatestScores
    public void changeModeScoresButtonClicked(ActionEvent actionEvent) {
        System.out.println("changeModeScoresButtonClicked");
    }

    // LatestScores
    public void closeScoresButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) closeScoresButton.getScene().getWindow();
        stage.close();
    }

    // LatestScores
    public void readLatestScores() throws IOException {
        last1ScoreLabel = new Label("999");
        last2ScoreLabel = new Label("999");
        last3ScoreLabel = new Label("999");
        last4ScoreLabel = new Label("999");
        last5ScoreLabel = new Label("999");
        // https://www.geeksforgeeks.org/different-ways-reading-text-file-java/#:~:text=Here%20are%20some%20of%20the%20many%20ways%20of,strings%20using%20regular%20expressions.%20...%20More%20items...%20
        // last1ScoreLabel

        /*
        Scanner sc = new Scanner(latestScores);

        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
            last1ScoreLabel.setText(sc);
        }
         */

        /*
        try (FileReader txtReader = new FileReader("latestScoresTxt.txt")){
            try (BufferedReader br = new BufferedReader(txtReader)){
                for (String line = br.readLine(); line!= null; line= br.readLine()){
                    System.out.println(line);
                    last1ScoreLabel.setText(line);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
         */

        BufferedReader br = new BufferedReader(new FileReader(latestScoresFile));

        // Array of Labels
        Label[] labelArray = {last1ScoreLabel, last2ScoreLabel, last3ScoreLabel, last4ScoreLabel, last5ScoreLabel};

        System.out.println(labelArray[2].getText().toString()+"\n\n");

        for (int j = 0; j<5; j++) {
            String line = br.readLine();
            System.out.println(line);
            labelArray[j].setText(line);
            System.out.println(labelArray[j]);
        }

    }


}
