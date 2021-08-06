package music;

import javax.sound.sampled.*;
import java.io.IOException;

public class Music {
    AudioInputStream inputStream;
    Clip clip;

    public Music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // TODO: Caused by: java.io.IOException: mark/reset not supported -> provide stream which supports mark/reset
        //inputStream = AudioSystem.getAudioInputStream(Music.class.getClassLoader().getResourceAsStream("music/Here_Come_The_Raindrops_-_Reed_Mathis.wav"));
        //this.clip = AudioSystem.getClip();
        //clip.open(inputStream);
        //clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    // https://www.geeksforgeeks.org/play-audio-file-using-java/
    // Method to stop the audio
    public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //clip.stop();
    }

    public void start() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}