package Music;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Music2 {
    private AudioStream audioStream;

    public void playMusic(Boolean isPlaying) throws IOException, LineUnavailableException {

        if (isPlaying) {
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                        Music2.class.getResourceAsStream("java/src/Music/data/Here_Come_The_Raindrops_-_Reed_Mathis.wav"));
                clip.open(inputStream);
                clip.start();
             //   audioStream = new AudioStream(new FileInputStream("java/src/Music/data/Here_Come_The_Raindrops_-_Reed_Mathis.wav"));
             //   AudioPlayer.player.start(audioStream);//lässt starten
              //  System.out.println("going");
            } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                System.err.println("music isn't Working :(");
            }
        }
        if (!isPlaying) {
            if (audioStream != null) {
                Clip clip = AudioSystem.getClip();
                clip.stop();

                AudioPlayer.player.stop(audioStream);

            }
            System.out.println("stopping");
        }
    }
}