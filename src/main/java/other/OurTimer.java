package other;

public class OurTimer {
//by Lukas

    public String SecToDisplay (int seconds) {
        //Converts a number of seconds to the format mm:ss um
        byte m = (byte) (seconds / 60);
        byte s = (byte) (seconds % 60);
        String dezminutes = (m < 10) ? "0" + m : "" + m;
        String dezseconds = (s < 10) ? "0" + s : "" + s;
        return (dezminutes + ":" + dezseconds);
    }
}