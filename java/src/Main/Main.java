package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../View/Menu.fxml")); // Geht aus dem Main-Package raus und dann ins View-Package rein
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

    static short ReadHighscore() {
        //Liest aktuelle Highscore aus highscore.txt und gibt diese als short zurück
        //by Lukas
        try {
            File scoreFile = new File("highscore.txt");
            Scanner scoreScanner = new Scanner(scoreFile);
            short score = 0;
            try {
                score = scoreScanner.nextShort();
            } catch (InputMismatchException e) {
                return -1; //Im Dokument steht alles, aber keine Zahl...
            }
            scoreScanner.close();
            return score;
        } catch (FileNotFoundException e) {
            return -2; //Das Dokument exisitiert nicht
        }
    }

    static void WriteHighscore(int newScore) {
        //Schreibt den gegebenen newScore in den highscore.txt, falls newScore größer als der Alte ist
        //by Lukas
        short oldScore = ReadHighscore();
        if (newScore > oldScore) {
            File scoreFile = new File("highscore.txt");
            if (scoreFile.exists() == false) {
                try {
                    scoreFile.createNewFile();
                } catch (IOException e) {
                    System.out.println("Kann Dokument nicht kreieren");
                    e.printStackTrace();
                }
            }
            try {
                FileWriter scoreWriter = new FileWriter(scoreFile);
                scoreWriter.write(String.valueOf(newScore));
                scoreWriter.close();
            } catch (IOException e) {
                System.out.println("Kann nicht in Dokument schreiben");
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
