package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/Menu.fxml"));
        primaryStage.setTitle("Cheesy Chase");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("../View/images/Projekt_-_Kaesehaufen.png")));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


