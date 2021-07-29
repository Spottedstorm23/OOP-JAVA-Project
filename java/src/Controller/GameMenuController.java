package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GameMenuController {
    //eigener Controller weil bei Zuordnung zum GameWindowController die Initialize() eine Nullpointer zurückgibt
    //beim Öffnen vom GameMenu wäre eine neue Instanz des GameWindowControllers erstellt worden (-> Aufruf Initialize())
    //Grund: GameMenu kann nicht auf Elemente von GameWindow zugreifen

    @FXML
    private Button resumeGameButton;

    @FXML
    private Button returnMenuButton;

    @FXML
    private Button exitGameMenuButton;

    @FXML
    private Button returnButton;

    @FXML
    private Button exitGameOverButton;

    @FXML
    private Label gameOverText;


    private Runnable returnMenuCallback;
    private boolean exitPressed;
    private Runnable timerCallback;
    private Mode mode = new Mode();

    public void resumeGameButtonClicked(ActionEvent actionEvent) {
        //resumes to game
        timerCallback.run();
        closeMe(actionEvent);
    }

    public void returnMenuButtonClicked(ActionEvent actionEvent) {
        // returns to menu
        closeMe(actionEvent);
        if(returnMenuCallback == null){
            throw new IllegalStateException("returnMenuCallback is null. Set with setReturnMenuCallback before showing the stage");
        }
        returnMenuCallback.run();
    }

    public void exitGameMenuButtonClicked(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void setReturnMenuCallback(Runnable returnMenuCallback) {
        this.returnMenuCallback = returnMenuCallback;
    }

    private void closeMe(ActionEvent actionEvent){
        //closes current window
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    public void setGameOverText(){
        //sets GameOver Message
        if(mode.getMode().equals("CheeseChase")){
            gameOverText.setText("You ran out of Time.");
        }
        else{
            gameOverText.setText("You have no lives left.");
        }
    }

    public void setExitPressed(boolean exitPressed) {
        this.exitPressed = exitPressed;
    }
    public boolean getExitPressed(){
        return exitPressed;
    }
    public void setTimerCallback(Runnable timerCallback){
        this.timerCallback = timerCallback;
    }
}
