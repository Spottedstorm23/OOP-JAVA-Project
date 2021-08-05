package controller;

import other.Highscore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LatestScoresController {

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


    public void initialize() throws IOException {
        readLatestScores();
    }

    // LatestScores
    public void changeModeScoresButtonClicked(ActionEvent actionEvent) {
        System.out.println("changeModeScoresButtonClicked");
    }

    // LatestScores
    public void closeScoresButtonClicked(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    // LatestScores
    public void readLatestScores() throws IOException {
        // https://www.geeksforgeeks.org/different-ways-reading-text-file-java/#:~:text=Here%20are%20some%20of%20the%20many%20ways%20of,strings%20using%20regular%20expressions.%20...%20More%20items...%20

        TextField[] textFieldArray = {latestScoresTextField1, latestScoresTextField2,
                latestScoresTextField3, latestScoresTextField4, latestScoresTextField5};

        //with help by lukas
        Highscore highscoreObject = new Highscore();
        short scores[] = highscoreObject.readHighscore();
        for (short j = 0; j < scores.length; j++) {
            textFieldArray[j].setText(String.valueOf(scores[j]));
        }
    }
}
