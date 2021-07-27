package Controller;

public class Mode {
    String mode;

    public void setMode(int mode) {
        //by Cora
        //sets the direction in which mouse moves and looks
        switch (mode){
            case 1: {
                this.mode = "CheeseChase";
                break;
            }
            case 2: {
                this.mode = "EscapeCats";
                break;
            }
        }
    }

    public String getMode() {
        return mode;
    }
}
