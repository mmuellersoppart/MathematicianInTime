package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomeController implements Initializable{

    @FXML
    private ImageView homeImageView;

    @FXML
    private HBox hBox;

    @FXML
    private BorderPane borderPane;

    public boolean homeImageViewActive;

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        homeImageViewActive = true;
    }


    /**
     * @param mouseEvent
     * @throws IOException
     */
    public void handleOnMouseClicked(MouseEvent mouseEvent) throws IOException {

        //System.out.print(mouseEvent);
        //System.out.println(mouseEvent.getPickResult().getIntersectedNode().getId()); //eventID
        //String current = new java.io.File( "." ).getCanonicalPath();

        if(mouseEvent.getPickResult().getIntersectedNode().getId().equals("homeImageView") && homeImageViewActive){
            Image image = new Image(getClass().getResource("Home.png").toExternalForm());
            homeImageView.setImage(image);
            homeImageViewActive = false;
        }
    }

}
