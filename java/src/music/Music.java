package music;

import javax.sound.sampled.*;
import java.io.IOException;


public class Music {

    AudioInputStream inputStream;
    Clip clip;

    // Constructor
    public Music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        inputStream = AudioSystem.getAudioInputStream(Music.class.getResourceAsStream("data/Here_Come_The_Raindrops_-_Reed_Mathis.wav"));
        this.clip = AudioSystem.getClip();
        clip.open(inputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void playMusic(Boolean isPlaying) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if (isPlaying) {
            //try {
                //setClip();
                /*
                setInputStream();
                clip = AudioSystem.getClip();
                clip.open(inputStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                // clip.start();

             //   audioStream = new AudioStream(new FileInputStream("java/src/Music/data/Here_Come_The_Raindrops_-_Reed_Mathis.wav"));
             //   AudioPlayer.player.start(audioStream);//lässt starten
              //  System.out.println("going");
            } catch (IOException | UnsupportedAudioFileException e) {
                System.err.println("music isn't Working :(");
            }

                 */

        }
        if (!isPlaying) {
            // setInputStream();
            // setClip();
            if (inputStream != null) {
                clip.stop();
                clip.close();
                /*
                Clip clip = AudioSystem.getClip();
                clip.stop();

                AudioPlayer.player.stop(inputStream);
                 */
                System.out.println("stopping");
            }

            // System.out.println("stopping");
        }
    }

    public void setInputStream() throws UnsupportedAudioFileException, IOException {
        this.inputStream = AudioSystem.getAudioInputStream(Music.class.getResourceAsStream("data/Here_Come_The_Raindrops_-_Reed_Mathis.wav"));
    }

    public AudioInputStream getInputStream() {
        return inputStream;
    }

    public void setClip() throws LineUnavailableException, IOException {
        this.clip = AudioSystem.getClip();
        clip.open(inputStream);
    }

    // https://www.geeksforgeeks.org/play-audio-file-using-java/
    // Method to stop the audio
    public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        clip.stop();
        // clip.close();
    }

    public void start() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}