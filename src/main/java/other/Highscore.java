package other;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Highscore {

    private final File highscoreFile = new File("highscore.txt");

    //by Lukas, everything related to highscores
    public void createFile() {
        // creates Hightcore.txt filled with zeros
        // DOES NOT WORK!
        try {
            if (highscoreFile.createNewFile()) {
                System.out.println("File created: " + highscoreFile.getName());
                try {
                    FileWriter scoreWriter = new FileWriter(highscoreFile);
                    for (byte i = 0; i < 5; i++) {
                        scoreWriter.write("0\n");
                    }
                    scoreWriter.close();
                } catch (IOException e) {
                    System.out.println("Can't write into document.");
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to create " + highscoreFile);
            e.printStackTrace();
        }
    }

    public short[] readHighscore() {
        if (highscoreFile.exists()) {
            // reads Hightscore.txt, scores are put into short type Array
            short[] score = new short[5];
            try {
                Scanner scoreScanner = new Scanner(highscoreFile);
                for (int i = 0; i < 5; i++) {
                    score[i] = scoreScanner.nextShort();
                }
                scoreScanner.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return score;
        } else {
            return new short[]{0, 0, 0, 0, 0};
        }
    }

    public void writeHighscore(int newScore) {
        // if the document does not exist, it will be created
        // if the new score is in numbers bigger than the old data, the document will be overwritten
        if (!highscoreFile.exists()) {
            createFile();
        }

        // reading existing data
        Highscore newClassObj = new Highscore();
        short[] Score = newClassObj.readHighscore();

        // checks if the new score is bigger than the old scores
        byte line = -1;

        for (byte i = (byte) (Score.length - 1); i >= 0; i--) {
            if (newScore > Score[i]) {
                line = i;
            }
        }

        // will be executed if the new score is one of the top 5 scores
        if (line > -1) {
            // creates new array with new scores
            for (byte i = (byte) (Score.length - 1); i > line; i--) {
                Score[i] = Score[i - 1];
            }
            Score[line] = (short) newScore;

            // writes new array in document
            try {
                FileWriter scoreWriter = new FileWriter(highscoreFile);

                for (byte i = 0; i < (byte) (Score.length); i++) {
                    scoreWriter.write(String.valueOf(Score[i]) + "\n"); // "+ "\n"" von Seli hinzugefügt
                    // scoreWriter.write("\n");
                }
                scoreWriter.close();
            } catch (IOException e) {
                System.out.println("Unable to write into document.");
                e.printStackTrace();
            }
        }
    }
}
