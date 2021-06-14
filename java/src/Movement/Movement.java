package Movement;

public class Movement {
    move = new Timer();
        move.scheduleAtFixedRate(new TimerTask(){

        @Override
        public void run() {

            if(Variables.moveUp == true) {
                System.out.println("moveUP");
                if (Variables.y >=20) {
                    Variables.y -= 2;
                }
            }else if (Variables.moveDown == true) {
                System.out.println("moveDown");
                if(Variables.y <= Variables.screenheight -200) {
                    Variables.y +=2;
                }
            }else if (Variables.moveRight == true) {

                if(Variables.x <= Variables.screenwidth +200) {
                    Variables.x +=2;
                }
            }else if (Variables.moveLeft == true) {

                if(Variables.x <= Variables.screenwidth +200) {
                    Variables.x -=2;
                }
            }
        }

    } , 0, 6);
}
}
