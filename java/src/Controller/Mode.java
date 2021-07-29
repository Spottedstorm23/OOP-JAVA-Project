package Controller;

public class Mode {
    //by Cora
    // responsible for the Mode of the Game
    private static String mode= "CheeseChase";

    public static void setMode(int number) {
        switch (number) {
            case 1: {
                mode = "CheeseChase";
                break;
            }
            case 2: {
                mode = "EscapeCats";
                break;
            }
        }
    }

    public String getMode() {
        return mode;
    }
}
