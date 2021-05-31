package Controller;

public class Maps {
    //Gibt dir bei Aufruf den entsprechenden Map-Array zurück
    //by Lukkkas

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

    //Map by Max
    private byte[][] map1 = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,1,1,1,0,1,0,0,0,0,0,0,0,1,1,3,0},
            {0,1,0,0,0,1,0,1,0,0,0,1,1,1,0,2,0,1,0},
            {0,1,1,2,1,1,0,1,1,1,0,1,0,1,1,1,0,1,0},
            {0,0,0,1,0,0,0,1,0,1,2,1,0,0,0,0,0,1,0},
            {0,1,1,1,1,1,0,1,0,1,0,1,0,0,1,1,1,2,0},
            {0,0,0,1,0,1,0,1,0,4,0,1,1,1,1,0,0,0,0},
            {0,1,2,1,0,1,0,1,0,0,0,0,1,0,1,1,0,0,0},
            {0,1,0,0,0,1,0,1,1,1,1,1,1,0,1,1,1,1,0},
            {0,1,1,1,1,0,0,0,0,0,0,0,1,0,2,0,0,1,0},
            {0,1,0,0,0,0,1,1,2,1,1,1,1,0,1,0,1,1,0},
            {0,1,1,1,1,1,2,0,1,0,1,0,1,0,1,0,1,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };

    //Map by Cora
    private byte[][] map2 = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,0,0,1,1,1,0,0,0,0,0,1,1,1,0,0,1,0},
            {0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0},
            {0,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,0},
            {0,1,1,1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,0},
            {0,1,0,1,1,1,0,3,0,0,0,1,0,4,1,1,0,1,0},
            {0,1,1,1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,0},
            {0,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,0},
            {0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0},
            {0,1,0,0,1,1,1,0,0,0,0,0,1,1,1,0,0,1,0},
            {0,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    };

    //Map by Olli
    private byte[][] map3 = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,1,1,1,1,2,1,1,0,0,0,0,1,1,1,0},
            {0,1,0,0,0,0,0,0,0,0,1,1,2,1,1,1,0,1,0},
            {0,1,0,0,0,0,1,1,1,1,0,0,0,0,1,0,0,1,0},
            {0,1,1,0,0,1,1,0,0,1,0,0,1,1,1,1,0,1,0},
            {0,0,1,1,1,2,0,0,0,1,0,0,1,0,0,1,2,1,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,1,1,1,0,0,0,0},
            {0,0,1,0,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0},
            {0,1,1,1,1,0,4,0,1,1,1,1,1,0,1,1,1,1,0},
            {0,1,0,0,0,0,0,0,1,1,0,0,1,0,0,0,0,1,0},
            {0,1,3,1,0,0,0,0,0,1,0,0,1,1,1,0,1,1,0},
            {0,0,0,1,1,1,1,1,1,1,0,0,0,0,1,1,2,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    };

    public byte[][] getMap() {
        return map1.clone();
    }
}