package Music;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Music2 {
    private AudioStream audioStream;

    public void playMusic(Boolean isPlaying) throws IOException {

        if (isPlaying) {
            try {
                audioStream = new AudioStream(new FileInputStream("java/src/Music/data/Here_Come_The_Raindrops_-_Reed_Mathis.wav"));
                AudioPlayer.player.start(audioStream);//lässt starten
                System.out.println("going");
            } catch (IOException e) {
                System.err.println("music isn't Working :(");
            }
        }
        if (!isPlaying) {
            if (audioStream != null) {
                AudioPlayer.player.stop(audioStream);
            }
            System.out.println("stopping");
        }
    }
}