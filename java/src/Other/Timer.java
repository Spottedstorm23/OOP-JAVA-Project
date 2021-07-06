package Other;

import java.util.TimerTask;

public class Timer {
//by Lukas
    public static int timer_count = 10;  //Zählt die Ticks für den Timer
    public static java.util.Timer t = new java.util.Timer(); //Definiert den Timer

    public static void timer() {

        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (timer_count <= 0) {
                    t.cancel();
                    t.purge();
                    return;
                }

                timer_count--;
                System.out.println(timer_count);
            };
        };
        t.schedule(tt, 1000, 1000); //Der eigentliche Timer
    }
}
