package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public class TutorialController {

    /* tutorial.fxml */
    @FXML
    private AnchorPane tutorialPane;
    @FXML
    private VBox tutorialVBox;
    @FXML
    private Button exitTutorialButton;

    public void initialize(){
        // TODO
        //stage.setY(((Toolkit.getDefaultToolkit().getScreenSize().height) / 2) - ((tutorialPane.getPrefHeight()) / 2));
        //stage.setX(((Toolkit.getDefaultToolkit().getScreenSize().width) / 2) - ((tutorialPane.getPrefWidth()) / 2));
        //
    }

    // Tutorial
    public void exitTutorialButtonClicked(ActionEvent actionEvent){
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }


}
