package Music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


public class Music {
    public boolean playMusic = false;
public /*static*/ synchronized void music(String track){

  final String trackname = track;

  new Thread(new Runnable() {
      @Override
      public void run() {

          while(playMusic == true){
                try{
                        Clip clip = AudioSystem.getClip();
                        AudioInputStream inputStream =AudioSystem.getAudioInputStream(new File(trackname));
                        clip.open(inputStream);
                        clip.loop(clip.LOOP_CONTINUOUSLY);

                        Thread.sleep(clip.getMicrosecondLength()/1000); //NICHT RAUSMACHEN !
                        }catch (Exception e){
                    e.printStackTrace();

                }
            }

      }
  }).start();
}

    public static  void stop(String track) {

        }

}
//https://www.youtube.com/watch?v=xUqQl3-Fhyg