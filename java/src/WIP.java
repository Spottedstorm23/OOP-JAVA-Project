
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {
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

    @Override
    public void start(Stage primaryStage) {
        try {
            StackPane root = new StackPane();
            Scene level = new Scene(root,950,650);
            level.setFill(Color.BLACK);
            primaryStage.setScene(level);
            updateLvl(root, map2);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void updateLvl(StackPane root, byte[][] map){
        Group group = new Group();
        int x = 0;
        for(x = 0; x < 13; x++){
            int y = 0;
            for(y = 0; y < 19; y++){
                System.out.print(map[x][y]);
                int cord_x = x*50;
                int cord_y = y*50;
                Rectangle r = new Rectangle(cord_x,cord_y,50,50);
                if(map[x][y] == 0){
                    r.setFill(Color.color(20/ 255.0F,47/ 255.0F,82/ 255.0F));
                }
                else if(map[x][y] == 1){
                    r.setFill(Color.color(221/ 255.0F,227/ 255.0F,236/ 255.0F));
                }
                group.getChildren().add(r);
            }
            System.out.println("");
        }
        root.getChildren().add(group);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
