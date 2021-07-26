package Controller;

import Music.Music2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Controller {
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
    @FXML
    private ImageView musicImage;

    /* tutorial.fxml */
    @FXML
    private AnchorPane tutorialPane;
    @FXML
    private VBox tutorialVBox;
    @FXML
    private Button exitTutorialButton;

    private int status = 1;

    private Music2 music = new Music2();
    private GameWindowController gwc = new GameWindowController();

    public Controller() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    }

    public void initialize(){
    }

    // Menu
    public void startButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../View/GameWindow.fxml"));
        Parent rootGame = fxmlLoader.load();
        Scene gameScene = new Scene(rootGame);
        Stage gameStage = new Stage();
        gameStage.setResizable(false);
        gameStage.initModality(Modality.APPLICATION_MODAL);
        gameStage.initStyle(StageStyle.TRANSPARENT);
        gameStage.setScene(gameScene);
        gameStage.getIcons().add(new Image(this.getClass().getResourceAsStream("../View/images/Projekt_-_Kaesehaufen.png")));
        gameStage.show();
    }

    // Menu
    public void latestScoresButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../View/LatestScores.fxml"));
        Parent root = fxmlLoader.load();
        Scene latestScoresScene = new Scene(root);
        Stage latestScoresStage = new Stage();
        latestScoresStage.initStyle(StageStyle.TRANSPARENT);
        latestScoresStage.setResizable(false);
        latestScoresStage.initModality(Modality.APPLICATION_MODAL);
        latestScoresStage.setScene(latestScoresScene);
        latestScoresStage.getIcons().add(new Image(this.getClass().getResourceAsStream("../View/images/Projekt_-_Kaesehaufen.png")));
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
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../View/tutorial.fxml"));
        Parent root = fxmlLoader.load();
        Scene tutorialScene = new Scene(root);
        Stage tutorialStage = new Stage();
        tutorialStage.initStyle(StageStyle.TRANSPARENT);
        tutorialStage.setResizable(false);
        tutorialStage.initModality(Modality.APPLICATION_MODAL);
        tutorialStage.setScene(tutorialScene);
        tutorialStage.getIcons().add(new Image(this.getClass().getResourceAsStream("../View/images/Projekt_-_Kaesehaufen.png")));
        tutorialStage.show();
    }

    // Menu
    public void exitButtonClicked(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        System.exit(0);
    }

    public void musicButtonClicked(ActionEvent actionEvent) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        switch (status){
            case 1: {
                this.music.stop();
                status = 0;
                musicImage.setImage(new Image("View/images/Projekt_-_MusicOff.png"));
                break;
            }
            case 0: {
                this.music.start();
                status = 1;
                musicImage.setImage(new Image("View/images/Projekt_-_MusicOn.png"));
                break;
            }
        }
    }
}
