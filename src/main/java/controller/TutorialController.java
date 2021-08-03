package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class TutorialController {

    /* tutorial.fxml */
    @FXML
    private AnchorPane tutorialPane;
    @FXML
    private VBox tutorialVBox;
    @FXML
    private Button exitTutorialButton;

    private static Stage stage;

    public void initialize(){
        // TODO
        //stage.setY(((Screen.getPrimary().getVisualBounds().getMinY()) / 2) - ((tutorialVBox.getPrefHeight()) / 2));
        //stage.setX(((Screen.getPrimary().getVisualBounds().getMinX()) / 2) - ((tutorialVBox.getPrefWidth()) / 2));
        //
    }

    // Tutorial
    public void exitTutorialButtonClicked(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }


}
