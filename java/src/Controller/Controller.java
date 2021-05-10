package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Controller {
    @FXML
    private ImageView imageMouse1;
    @FXML
    private ImageView imageMouse2;
    @FXML
    private ImageView imageMouse3;

    @FXML
    private Label labelCurrentMode;

    @FXML
    private AnchorPane paneBoard;

    public void initialize() throws IOException {

        /*
        FileInputStream inputStream = new FileInputStream("..\\View\\images\\Projekt_-Kase_Kopie.png");
        Image image = new Image(inputStream);
        imageMouse1 = new ImageView(image); // new Image("../View/images/Projekt_-Kase_Kopie.png"));
         */




    }


    public void onMouseClickedTimer(MouseEvent mouseEvent) throws IOException {
        System.out.println("Klick");
        BufferedImage image = ImageIO.read(new File("../View/images/Projekt_-Maus_Kopie.png"));
        Image imageI = new Image(String.valueOf(image));
        imageMouse1 = new ImageView(imageI); // new Image("../View/images/Projekt_-Maus_Kopie.png"));
    }
}
