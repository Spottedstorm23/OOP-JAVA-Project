package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
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

    private Runnable returnMenuCallback;
    private boolean exitPressed;
    private Runnable timerCallback;

    public void resumeGameButtonClicked(ActionEvent actionEvent) {
        timerCallback.run();
        closeMe(actionEvent);
    }

    public void returnMenuButtonClicked(ActionEvent actionEvent) {
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
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
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
