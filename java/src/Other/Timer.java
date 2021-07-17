package Other;

import Controller.GameWindowController;
import javafx.scene.control.Label;

import java.util.TimerTask;

public class Timer {
//by Lukas
    public static int timer_count;  //Zählt die Ticks für den Timer
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
}