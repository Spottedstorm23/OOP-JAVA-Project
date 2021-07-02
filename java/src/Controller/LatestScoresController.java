package Controller;

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

    File latestScoresFile = new File(getClass().getResource("../Resources/latestScoresTxt.txt").getFile());

    public void displayLatestScores() throws IOException {
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

        readLatestScores();

        latestScoresStage.show();
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

        BufferedReader br = new BufferedReader(new FileReader(latestScoresFile));

        // Array of TFs
        TextField[] textFieldArray = {latestScoresTextField1, latestScoresTextField2,
                latestScoresTextField3, latestScoresTextField4, latestScoresTextField5};

        System.out.println(textFieldArray[2].getText() +"\n\n");

        for (int j = 0; j<5; j++) {
            String line = br.readLine();
            System.out.println(line);
            textFieldArray[j].setText(line);
            System.out.println(textFieldArray[j]);
        }
    }

}
