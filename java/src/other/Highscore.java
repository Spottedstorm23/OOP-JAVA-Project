package other;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Highscore {
    //by Lukas, für alles was mit den Highscores relatet ist

    public void createFile() {
        //Kreiert die Highscore.txt und füllt sie mit Nullen auf
        //ACHTUNG FUNKTIONIERT NICHT!

        try {
            File bigFile = new File(getClass().getResource("../Resources/highscore.txt").getFile());;

            if (bigFile.createNewFile()) {
                System.out.println("File created: " + bigFile.getName());
                File scoreFile = new File(getClass().getResource("../Resources/highscore.txt").getFile());
                try {
                    FileWriter scoreWriter = new FileWriter(scoreFile);

                    for (byte i = 0; i < 5; i++) {
                        scoreWriter.write("0\n");
                    }
                    scoreWriter.close();
                }
                catch (IOException e) {
                    System.out.println("Kann nicht in Dokument schreiben");
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Kann highscore.txt nicht erstellen");
            e.printStackTrace();
        }
    }

    public short[] readHighscore() {
        //Liest aktuelle Highscores aus highscore.txt und gibt diese als short[] zurück

        short[] score = new short[5];
        try {
            File scoreFile = new File(getClass().getResource("../Resources/highscore.txt").getFile());
            Scanner scoreScanner = new Scanner(scoreFile);
            for (int i = 0; i < 5; i++)
            {
                score[i] = scoreScanner.nextShort();
            }
            scoreScanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return score;
    }

    public void writeHighscore(int newScore) {
        //Schreibt den gegebenen newScore in den highscore.txt, falls newScore größer als der Alte ist

        /* Check ob die Datei exisitiert, wenn nicht erstellen */
        File scoreFile = new File(getClass().getResource("../Resources/highscore.txt").getFile());

        if (scoreFile.exists() == false) {
            createFile();
        }

        /* Auslesen der Alten Werte */
        Highscore newClassObj = new Highscore();
        short[] Score = newClassObj.readHighscore();

        /* Überprüfen ob neuer Wert größer ist als die alten Scores */
        byte line = -1;

        for (byte i = (byte)(Score.length - 1); i >= 0; i--) {
            if (newScore > Score[i]) {
                line = i;
            }
        }

        /* Wenn es sich tatsächlich um einen Top5 Score handelt, dann... */
        if ( line > -1 ) {

            //Neuen Array mit neuen Scores erstellen
            for (byte i = (byte)(Score.length - 1); i > line; i--) {
                Score[i] = Score[i - 1];
            }
            Score[line] = (short)newScore;

            //Neuen Array in Datei schreiben
            try {
                FileWriter scoreWriter = new FileWriter(scoreFile);

                for (byte i = 0; i < (byte)(Score.length); i++) {
                    scoreWriter.write(String.valueOf(Score[i]));
                    scoreWriter.write("\n");
                    //System.out.println(Score[i]);
                }
                scoreWriter.close();
            } catch (IOException e) {
                System.out.println("Kann nicht in Dokument schreiben");
                e.printStackTrace();
            }
        }
    }
}
