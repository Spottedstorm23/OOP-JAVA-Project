package Other;

import Controller.GameWindowController;
import javafx.scene.control.Label;

import java.util.TimerTask;

public class Timer {
//by Lukas
    /*public static int timer_count;  //Zählt die Ticks für den Timer
    public static java.util.Timer t = new java.util.Timer(); //Definiert den Timer

    private GameWindowController gwc = new GameWindowController();

    public Timer(int timer_count){
        this.timer_count = timer_count;
    }

    public int getTimerCount(){
        return timer_count;
    }

    public void timer() {
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                boolean boolTimer = false;

                if (timer_count <= 0) {
                    t.cancel();
                    t.purge();
                    return;
                }

                timer_count--;
                System.out.println(timer_count);
                //boolTimer = gwc.setLabelTimerText("00:05");
                System.out.println(boolTimer);
            };
        };
        t.schedule(tt, 1000, 1000); //Der eigentliche Timer
    }

    public static void timerClockCalc2(int minutes, int seconds) {
        //Timer zählt entsprechende Minuten und Sekunden runter
        //by Lukas 2h
        do {
            do {
                try
                {
                    Thread.sleep(1000); //Schläft 1 Sekunde
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
                String dezminutes = (minutes < 10) ? "0" + minutes : "" + minutes;
                String dezseconds = (seconds < 10) ? "0" + seconds : "" + seconds;
                System.out.println(dezminutes + ":" + dezseconds);
                seconds -= 1;
            } while (seconds >= 0);
            minutes -= 1;
            seconds = 59;
        } while (minutes >= 0);
    }*/

    public String SecToDisplay (int seconds) {
        //Wandelt Eine Sekundenzahl in das Format mm:ss um
        byte m = (byte) (seconds / 60);
        byte s = (byte) (seconds % 60);
        String dezminutes = (m < 10) ? "0" + m : "" + m;
        String dezseconds = (s < 10) ? "0" + s : "" + s;
        return (dezminutes + ":" + dezseconds);
    }
}