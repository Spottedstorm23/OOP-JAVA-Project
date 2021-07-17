package Controller;

import View.View;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.TimerTask;

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

    public static int timer_count = 120;  //Zählt die Ticks für den Timer
    public static java.util.Timer t = new java.util.Timer(); //Definiert den Timer

    public void initialize() throws IOException {
       /* Timer.timer();
        changeTimerDisplay();*/

        byte [][] levelmap = map.getMap();
        view.drawLvl(paneBoard, levelmap);
        view.updateCheese(paneBoard, levelmap);
        view.drawMouse(paneBoard);
        //setLabelTimerText("00:01");
        timer();
    }

    private void changeTimerDisplay() {
        labelTimer.setText("00:01");
    }
    public void timer() {
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()-> {
                    if (timer_count <= 0) {
                        t.cancel();
                        t.purge();
                        return;
                    }
                    timer_count--;
                    System.out.println(timer_count);
                    setLabelTimerText(""+timer_count);
                    System.out.println(labelTimer);
                });
            };
        };
        t.schedule(tt, 1000, 1000); //Der eigentliche Timer
    }

    public String getLabelTimerText(){
        return this.labelTimer.getText();
    }

    public void setLabelTimerText(String labeltext) {
        try {
            System.out.println(labelTimer.getClass());
            labelTimer.setText(labeltext);
        } catch (Exception e){

        }
    }
}
