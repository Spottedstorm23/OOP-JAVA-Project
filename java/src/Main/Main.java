package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../View/GameWindow.fxml")); // Geht aus dem Main-Package raus und dann ins View-Package rein
        primaryStage.setTitle("Cheesy Chase");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void timer(int minutes, int seconds) {
        //Timer zählt entsprechende Minuten und Sekunden runter
        //by Lukas 2h
        do {
            do {
                try
                {
                    Thread.sleep(1000); //Schläft 1 Sekunde
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
                String dezminutes = (minutes < 10) ? "0" + minutes : "" + minutes;
                String dezseconds = (seconds < 10) ? "0" + seconds : "" + seconds;
                System.out.println(dezminutes + ":" + dezseconds);
                seconds -= 1;
            } while (seconds >= 0);
            minutes -= 1;
            seconds = 59;
        } while (minutes >= 0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
