package Controller;

import Other.Timer;
import View.View;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class GameWindowController {
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
    @FXML
    private Label labelTimer;

    View view = new View();
    Maps map = new Maps();

    public void initialize() throws IOException {
       /* Timer.timer();
        changeTimerDisplay();*/

        byte [][] levelmap = map.getMap();
        view.drawLvl(paneBoard, levelmap);
        view.updateCheese(paneBoard, levelmap);
        view.drawMouse(paneBoard);
    }

    private void changeTimerDisplay() {
        labelTimer.setText("00:01");
    }

    private String getLabelTimerText(){
        return this.labelTimer.getText();
    }

    private void setLabelTimerText(String labeltext) {
        labelTimer.setText(labeltext);
    }

}
