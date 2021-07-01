package Music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


public class Music {
    public boolean playMusic;
    public boolean state;
public /*static*/ synchronized void music(String track){

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


    public boolean setPlayMusic(boolean state) {
        Music music = new Music();
        music.playMusic = state;
        return music.playMusic;

    }

    public static  void stop(String track) {

        }

}
//https://www.yutube.com/watch?v=xUqQl3-Fhygo