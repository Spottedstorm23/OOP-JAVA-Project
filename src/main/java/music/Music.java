package music;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Music {
    AudioInputStream inputStream;
    Clip clip;

    public Music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // TODO: Caused by: java.io.IOException: mark/reset not supported -> provide stream which supports mark/reset
        InputStream bufferedInput = new BufferedInputStream(this.getClass().getClassLoader().getResourceAsStream("music/Here_Come_The_Raindrops_-_Reed_Mathis.wav"));
        inputStream = AudioSystem.getAudioInputStream(bufferedInput);
        this.clip = AudioSystem.getClip();
        clip.open(inputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    // https://www.geeksforgeeks.org/play-audio-file-using-java/
    // Method to stop the audio
    public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        clip.stop();
    }

    public void start() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}