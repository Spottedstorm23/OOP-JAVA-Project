package music;

import javax.sound.sampled.*;
import java.io.IOException;

public class Music {
    AudioInputStream inputStream;
    Clip clip;

    public Music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        inputStream = AudioSystem.getAudioInputStream(Music.class.getResourceAsStream("data/Here_Come_The_Raindrops_-_Reed_Mathis.wav"));
        this.clip = AudioSystem.getClip();
        clip.open(inputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
/*
    public void playMusic(Boolean isPlaying) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if (!isPlaying) {
            if (inputStream != null) {
                clip.stop();
                clip.close();
            }
        }
    }
/*
    public void setInputStream() throws UnsupportedAudioFileException, IOException {
        this.inputStream = AudioSystem.getAudioInputStream(Music.class.getResourceAsStream("data/Here_Come_The_Raindrops_-_Reed_Mathis.wav"));
    }

    public AudioInputStream getInputStream() {
        return inputStream;
    }

    /*
    public void setClip() throws LineUnavailableException, IOException {
        this.clip = AudioSystem.getClip();
        clip.open(inputStream);
    }

     */

    // https://www.geeksforgeeks.org/play-audio-file-using-java/
    // Method to stop the audio
    public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        clip.stop();
    }

    public void start() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}