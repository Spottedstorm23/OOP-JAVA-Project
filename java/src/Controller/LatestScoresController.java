package Controller;

import Other.Highscore;
import Other.Timer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LatestScoresController {
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

    //File latestScoresFile = new File(getClass().getResource("../Resources/latestScoresTxt.txt").getFile());

    public void initialize() throws IOException {
        readLatestScores();
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
        // https://www.geeksforgeeks.org/different-ways-reading-text-file-java/#:~:text=Here%20are%20some%20of%20the%20many%20ways%20of,strings%20using%20regular%20expressions.%20...%20More%20items...%20
        //BufferedReader br = new BufferedReader(new FileReader(latestScoresFile));

        // Array of TFs
        TextField[] textFieldArray = {latestScoresTextField1, latestScoresTextField2,
                latestScoresTextField3, latestScoresTextField4, latestScoresTextField5};

        /*
        for (int j = 0; j<5; j++) {
            String line = br.readLine();
            System.out.println(line);
            textFieldArray[j].setText(line);
            System.out.println(textFieldArray[j]);
        }
        */


        //mit Hilfe von Lukas :D
        Highscore highscoreObject = new Highscore();
        short scores[] = highscoreObject.readHighscore();
        for (short j = 0; j < scores.length; j++) {
            textFieldArray[j].setText(String.valueOf(scores[j]));
        }
    }
}
