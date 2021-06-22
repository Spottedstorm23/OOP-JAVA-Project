package Controller;

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
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
    private Button exitTutorialButton;
    @FXML
    private AnchorPane menuPane;

    /* tutorial.fxml */
    @FXML
    private AnchorPane tutorialPane;
    @FXML
    private VBox tutorialVBox;

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

    // static String pathToLatestScoresTxt = "latestScoresTxt.txt";
    // The system cannot find the path specified

    // static String pathToLatestScoresTxt = "C:\\Users\\ThielS\\Videos\\java\\OOP-JAVA-Project\\0java\\src\\Resources\\latestScoresTxt.txt";
    // The system cannot find the path specified

    File latestScores = new File("../Resources/latestScores.txt");

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
        // latestScoresStage.initStyle(StageStyle.TRANSPARENT);
        latestScoresStage.setResizable(false);
        latestScoresStage.initModality(Modality.APPLICATION_MODAL);
        latestScoresStage.setScene(latestScoresScene);

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
    public void tutorialButtonClicked(ActionEvent actionEvent) throws IOException {
        VBox tutorialVBox  = FXMLLoader.load(getClass().getResource("../View/tutorial.fxml"));

        Scene sceneTutorial = new Scene(tutorialVBox);

        Stage tutorial = new Stage();
        tutorial.setTitle("Tutorial");
        tutorial.setResizable(false);
        tutorial.initModality(Modality.APPLICATION_MODAL);
        tutorial.setScene(sceneTutorial);
        tutorial.show();
    }
    public void exitTutorialButtonClicked(ActionEvent actionEvent){
        Stage stage = (Stage) exitTutorialButton.getScene().getWindow();
        stage.close();
}
    // Menu
    public void exitButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
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
        // last1ScoreLabel

        Scanner sc = new Scanner(latestScores);

        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }

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


    }


}
