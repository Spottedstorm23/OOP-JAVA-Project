package Main;

import Controller.Maps;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Application {

    //Important
    int mouseX;
    int mouseY;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../View/Menu.fxml")); // Geht aus dem Main-Package raus und dann ins View-Package rein
        primaryStage.setTitle("Cheesy Chase");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));


        Pane levelPane = new Pane();
        Scene level = new Scene(levelPane, 950, 650);
       // primaryStage.setScene(level);
        Maps map = new Maps();
        byte [][] levelmap = map.getMap();
        drawLvl(levelPane, levelmap);
        updateCheese(levelPane, levelmap);
        drawMouse(levelPane);

        primaryStage.show();

       // music music = new music();
       // music.music("java/src/Music/data/Here_Come_The_Raindrops_-_Reed_Mathis (online-audio-converter.com).wav");

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

    public void drawLvl(Pane root, byte[][] map) {
        //Draws Level -> only Path and Wall
        //by Cora
        Group group = new Group();
        int y = 0;
        for (y = 0; y < 13; y++) {
            int x = 0;
            for (x = 0; x < 19; x++) {
                int cord_y = y * 50;
                int cord_x = x * 50;
                Rectangle r = new Rectangle(cord_x, cord_y, 50, 50);

                switch (map[y][x]) {
                    case 0: {
                        // Case for Wallcolor
                        r.setFill(Color.color(20 / 255.0F, 47 / 255.0F, 82 / 255.0F));
                        break;
                    }
                    case 4: {
                        // sets first Mouse Coordinates
                        r.setFill(Color.color(221 / 255.0F, 227 / 255.0F, 236 / 255.0F));
                        setMouseX(cord_x);
                        setMouseY(cord_y);
                        break;
                    }
                    default: {
                        // Case for Pathcolor
                        r.setFill(Color.color(221 / 255.0F, 227 / 255.0F, 236 / 255.0F));
                        break;
                    }
                }
                group.getChildren().add(r);

            }
            System.out.println("");
        }
        root.getChildren().add(group);
    }

    public void updateCheese(Pane root, byte[][] map) {
        //Updates Cheespiles on the Map
        //by Cora
        Group groupCheese = new Group();
        int y = 0;
        for (y = 0; y < 13; y++) {
            int x = 0;
            for (x = 0; x < 19; x++) {
                int cord_y = y * 50;
                int cord_x = x * 50;

                switch (map[y][x]) {
                    case 2: {
                        Rectangle r_cheese = new Rectangle(cord_x, cord_y, 50, 50);
                        Image cheese = new Image("./View/images/Projekt_-_Kaese.png");
                        r_cheese.setFill(new ImagePattern(cheese));
                        groupCheese.getChildren().add(r_cheese);
                        break;
                    }
                    case 3: {
                        Rectangle r_cheese = new Rectangle(cord_x, cord_y, 50, 50);
                        Image cheesepile = new Image("./View/images/Projekt_-_Kaesehaufen.png");
                        r_cheese.setFill(new ImagePattern(cheesepile));
                        groupCheese.getChildren().add(r_cheese);
                        break;
                    }
                }
            }
            System.out.println("");
        }
        root.getChildren().add(groupCheese);
    }


    public void drawMouse(Pane root) {
        // Draws the Mouse on Current position
        //by Cora
        int mouseX = getMouseX();
        int mouseY = getMouseY();
        Rectangle r_mouse = new Rectangle(mouseX, mouseY, 50, 50);
        Image mousepic = new Image("./View/images/Projekt_-_Maus.png");
        r_mouse.setFill(new ImagePattern(mousepic));
        root.getChildren().add(r_mouse);
    }


    public int setMouseX(int x) {
        //sets Mouse Coordinate X
        this.mouseX = x;
        return mouseX;
    }

    public int getMouseX() {
        //returns Mouse Coordinate X
        return mouseX;
    }


    public int setMouseY(int y) {
        //sets Mouse Coordinate X
        this.mouseY = y;
        return mouseY;
    }

    public int getMouseY() {
        //returns Mouse Coordinate Y
        return mouseY;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
