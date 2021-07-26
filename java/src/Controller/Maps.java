package Controller;

public class Maps {
    //Gibt dir bei Aufruf den entsprechenden Map-Array zurück
    //by Lukas

    //Maps newClassObj = new Maps();
    //byte[][] secondArray = newClassObj.getMap();

    /*
    0 Mauer
    1 Weg
    2 Käse
    3 Großer Käse
    4 Spawn Maus
    5 Katze
     */

    //Map by Max 1
    byte[][] randomMap;


    private byte[][] map1 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 3, 0},
            {0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 2, 0, 1, 0},
            {0, 1, 1, 2, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 2, 1, 0, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 2, 0},
            {0, 0, 0, 1, 0, 1, 0, 1, 0, 4, 0, 1, 1, 1, 1, 0, 0, 0, 0},
            {0, 1, 2, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, 0, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 1, 2, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 2, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    //Map by Cora 1
    final private byte[][] map2 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0},
            {0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 2, 1, 1, 0, 0, 1, 0},
            {0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
            {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 2, 1, 1, 1, 1, 0},
            {0, 1, 0, 2, 1, 1, 0, 3, 0, 0, 0, 1, 0, 4, 1, 1, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 2, 1, 0},
            {0, 1, 0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
            {0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0},
            {0, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    //Map by Olli 1
    private byte[][] map3 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 1, 1, 1, 0, 1, 0},
            {0, 2, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0},
            {0, 0, 1, 1, 1, 2, 0, 0, 0, 1, 0, 0, 2, 0, 0, 1, 2, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 0, 4, 0, 2, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 3, 1, 0, 0, 0, 0, 0, 1, 0, 0, 2, 1, 1, 0, 1, 1, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 2, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    //Map by Max 2
    private byte[][] map4 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 3, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 2, 0, 0, 0},
            {0, 1, 0, 0, 1, 0, 2, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0},
            {0, 2, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 3, 1, 1, 0, 2, 1, 1, 1, 0, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 4, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 2, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 2, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    //Map by Max 3
    private byte[][] map5 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 2, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 2, 1, 1, 0},
            {0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 1, 1, 2, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 1, 1, 2, 1, 0, 1, 0, 0, 0, 0, 2, 0},
            {0, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 3, 1, 1, 1, 0, 1, 0},
            {0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 1, 2, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 2, 0, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    //Map by Max 4
    private byte[][] map6 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 4, 1, 0, 0, 0, 0, 0, 2, 1, 1, 1, 1, 1, 1, 1, 2, 0, 0},
            {0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 3, 0, 0},
            {0, 1, 0, 0, 1, 1, 2, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 3, 0, 2, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 2, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 2, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 3, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    //Map by Selina 1
    private byte[][] map7 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 3, 0, 0, 0, 0, 0, 0, 2, 1, 1, 1, 1, 0, 0, 0},
            {0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 2, 1, 1, 0},
            {0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0},
            {0, 2, 1, 1, 1, 1, 0, 0, 2, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 2, 0},
            {0, 2, 1, 1, 1, 1, 0, 0, 0, 0, 2, 1, 1, 1, 1, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 1, 1, 2, 0, 1, 0, 2, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 2, 0, 0},
            {0, 0, 0, 1, 1, 2, 0, 0, 1, 0, 0, 4, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    //Map by Selina 2
    private byte[][] map8 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 2, 1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 2, 1, 1, 0},
            {0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0},
            {0, 1, 1, 0, 1, 0, 2, 1, 0, 0, 0, 1, 1, 0, 1, 0, 2, 1, 0},
            {0, 0, 1, 1, 1, 0, 0, 1, 1, 3, 1, 1, 0, 0, 2, 1, 1, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 2, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 2, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 2, 1, 1, 1, 1, 1, 2, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    //Map by Selina 3
    private byte[][] map9 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 2, 1, 1, 1, 1, 1, 0, 2, 1, 0, 1, 1, 1, 1, 0},
            {0, 3, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 0},
            {0, 0, 0, 1, 1, 1, 2, 1, 0, 0, 2, 1, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0},
            {0, 1, 1, 0, 0, 0, 1, 1, 1, 4, 1, 1, 0, 1, 1, 1, 1, 0, 0},
            {0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0},
            {0, 1, 0, 2, 0, 1, 0, 0, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 0},
            {0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 0, 1, 1, 1, 2, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0},
            {0, 2, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 2, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    //Map by Selina 4
    private byte[][] map10 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 2, 0, 0, 1, 1, 1, 1, 1, 1, 2, 0, 0, 1, 1, 0},
            {0, 1, 1, 1, 1, 0, 1, 2, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0},
            {0, 2, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 2, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 0, 1, 1, 2, 0, 0, 4, 1, 1, 1, 1, 0, 0},
            {0, 1, 0, 0, 2, 1, 1, 1, 1, 0, 1, 3, 0, 1, 0, 0, 1, 2, 0},
            {0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 2, 1, 1, 1, 0},
            {0, 0, 1, 2, 1, 0, 0, 0, 0, 1, 2, 0, 1, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    //Map by Selina 5
    private byte[][] map11 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 3, 1, 1, 1, 1, 0, 0, 1, 1, 1, 2, 1, 1, 1, 1, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0},
            {0, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 0, 1, 0},
            {0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 1, 1, 1, 4, 0, 1, 2, 1, 1, 0, 1, 1, 0},
            {0, 0, 1, 1, 2, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 2, 1, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 0, 0, 0, 1, 2, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 0},
            {0, 1, 2, 1, 1, 0, 1, 0, 2, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 2, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    //Map by Cora 2
    private byte[][] map12 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 2, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 2, 1, 1, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 1, 0, 1, 1, 1, 4, 1, 1, 1, 0, 1, 1, 0, 1, 0},
            {0, 1, 0, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 1, 1, 0, 0, 1, 1, 3, 1, 1, 0, 0, 1, 1, 0, 2, 0},
            {0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 2, 0, 1, 0},
            {0, 1, 0, 1, 0, 2, 1, 0, 1, 0, 1, 0, 1, 2, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0},
            {0, 3, 0, 1, 1, 1, 1, 1, 2, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    //Map by Cora 3
    private byte[][] map13 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
            {0, 1, 1, 0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 3, 0, 1, 1, 0},
            {0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 2, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 2, 1, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 0, 1, 0, 3, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 2, 1, 1, 0},
            {0, 1, 1, 0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 0, 1, 4, 0},
            {0, 0, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    //Map by Cora 4
    private byte[][] map14 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0},
            {0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 2, 0, 1, 0, 1, 0, 1, 1, 0, 3, 0, 1, 4, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 1, 2, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 2, 1, 0},
            {0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 2, 1, 0, 1, 0, 0, 1, 0},
            {0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 3, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 0, 1, 0},
            {0, 1, 1, 1, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    //Map by Lukas
    private byte[][] map15 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 0},
            {0, 1, 0, 0, 1, 0, 0, 1, 0, 3, 0, 1, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 0, 2, 1, 2, 0, 1, 1, 1, 1, 1, 0, 2, 1, 2, 0, 1, 0},
            {0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 2, 1, 1, 1, 2, 0, 1, 0, 1, 0, 1, 0},
            {0, 2, 0, 1, 3, 1, 0, 0, 0, 4, 0, 0, 0, 1, 3, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 2, 1, 1, 1, 2, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0},
            {0, 1, 0, 2, 1, 2, 0, 1, 1, 1, 1, 1, 0, 2, 1, 2, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 1, 0, 3, 0, 1, 0, 0, 1, 0, 0, 1, 0},
            {0, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    //Map by Cora 5
    private byte[][] map16 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 2, 0, 1, 0, 1, 1, 1, 1, 2, 0, 2, 0, 1, 1, 5, 0},
            {0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0},
            {0, 1, 0, 1, 1, 1, 2, 1, 0, 2, 0, 1, 1, 1, 1, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 2, 0, 1, 0, 1, 1, 0, 0, 0, 0, 2, 0},
            {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 2, 0, 1, 1, 1, 1, 1, 1, 1, 0, 3, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 2, 0, 0, 0, 0, 1, 0},
            {0, 2, 0, 1, 1, 1, 1, 1, 0, 3, 0, 1, 1, 1, 1, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0},
            {0, 1, 1, 4, 0, 2, 0, 1, 1, 2, 1, 1, 0, 2, 0, 1, 1, 2, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    private byte[][] chooseRandomMap() {
        int x = (int) (Math.random() * ((15 - 1) + 1) + 1);
        switch (x) {
            case 1: {
                return map1;
            }
            case 2: {
                return map2;
            }
            case 3: {
                return map3;
            }
            case 4: {
                return map4;
            }
            case 5: {
                return map5;
            }
            case 6: {
                return map7;
            }
            case 8: {
                return map8;
            }
            case 9: {
                return map9;
            }
            case 10: {
                return map10;
            }
            case 11: {
                return map11;
            }
            case 12: {
                return map12;
            }
            case 13: {
                return map13;
            }
            case 14: {
                return map14;
            }
            case 15: {
                return map15;
            }
            case 16: {
                return map16;
            }
        }
        return map2;
    }

    public byte[][] getMap() {
        return chooseRandomMap().clone();
    }

    public byte[][] getMap16() {
        return map16.clone();
    }
}
