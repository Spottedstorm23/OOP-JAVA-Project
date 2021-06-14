package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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


    public void initialize() throws IOException {

        /*
        FileInputStream inputStream = new FileInputStream("..\\View\\images\\Projekt_-Kase_Kopie.png");
        Image image = new Image(inputStream);
        imageMouse1 = new ImageView(image); // new Image("../View/images/Projekt_-Kase_Kopie.png"));
         */




    }


    public void onMouseClickedTimer(MouseEvent mouseEvent) throws IOException {
        System.out.println("Klick");
        BufferedImage image = ImageIO.read(new File("../View/images/Projekt_-Maus_Kopie.png"));
        Image imageI = new Image(String.valueOf(image));
        imageMouse1 = new ImageView(imageI); // new Image("../View/images/Projekt_-Maus_Kopie.png"));
    }

    public void startButtonClicked(ActionEvent actionEvent) throws IOException {
        AnchorPane menuPane = FXMLLoader.load(getClass().getResource("../View/GameWindow.fxml"));
        System.out.println("StartButton");
    }

    public void latestScoresButtonClicked(ActionEvent actionEvent) {

    }

    public void chaseModeButtonClicked(ActionEvent actionEvent) {

    }

    public void escapeModeButtonClicked(ActionEvent actionEvent) {
    }

    public void tutorialButtonClicked(ActionEvent actionEvent) {

    }

    public void exitButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
