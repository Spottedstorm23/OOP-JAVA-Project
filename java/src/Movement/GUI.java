package Movement;
rt javax.swing.*;


public class GUI {
    public  GUI() {
    Variables.jf1 = new JFrame();
        Variables.jf1.setSize(Variables.screenwidth, Variables.screenheight);
        Variables.jf1.setTitle("PingPong");
        Variables.jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Rotes Kreuz schließt
        Variables.jf1.setLayout(null);
        Variables.jf1.setResizable(false); //Damit Fenster nicht kleiner und größer geht
        Variables.jf1.setVisible(true); //Damit wir Fenster sehen
        Variables.jf1.setLocationRelativeTo(null); //Damit Fesnter genau in der Mitte ist
        Variables.jf1.addKeyListener(new KeyHandler()); //Für Tastaturzugriffe
        Variables.jf1.requestFocus(); //Für ständigen Fokus auf das Fenster damit Tastatur geht

    Draw lblDraw = new Draw();
        lblDraw.setBounds(0,0 , Variables.screenwidth, Variables.screenwidth);
        lblDraw.setVisible(true);
        Variables.jf1.add(lblDraw);
}
}

