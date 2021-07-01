package Music;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Music {
    public boolean isPlaying;
    public boolean state;
/*public /*static synchronized void music(String track){

  final String trackname = track;

  new Thread(new Runnable() {
      @Override
      public void run() {

          if(playMusic == true){
                try{
                        Clip clip = AudioSystem.getClip();
                        AudioInputStream inputStream =AudioSystem.getAudioInputStream(new File(trackname));
                        clip.open(inputStream);
                        clip.loop(clip.LOOP_CONTINUOUSLY);

                        Thread.sleep(clip.getMicrosecondLength()/1000); //NICHT RAUSMACHEN !
                        }catch (Exception e){
                    e.printStackTrace();
                    System.out.println(playMusic);
                }
            }


          }


  }).start();}
*/

    private AudioStream audioStream;

    public void playMusic(Boolean isPlaying) throws IOException {

        if (isPlaying){
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
                System.out.println("stopping");
            }
            System.out.println("stopping2");
        }
    }


    public boolean setIsPlaying(boolean state) {
        Music music = new Music();
        music.isPlaying = state;
        return music.isPlaying;

    }

}
//https://www.yutube.com/watch?v=xUqQl3-Fhygo