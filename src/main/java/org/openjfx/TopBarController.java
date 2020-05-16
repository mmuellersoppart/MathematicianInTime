package org.openjfx;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class TopBarController extends Pane {

    @FXML private Button topBarHome;
    @FXML private Button topBarTimeline;
    @FXML private Button topBarDungeon;
    @FXML private Button topBarSkills;

    public Button getTopBarHome() {
        return topBarHome;
    }
    public Button getTopBarDungeon() {
        return topBarDungeon;
    }
    public Button getTopBarSkills() {
        return topBarSkills;
    }
    public Button getTopBarTimeline() {
        return topBarTimeline;
    }

    //
//    @FXML
//    public void handleHomeB(ActionEvent event) throws Exception {
//
//    }

    public TopBarController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TopMenuComponent.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }



    public void goHome(){
        System.out.println("We are going home.");
    }

    public void goTimeline(){
        System.out.println("We are going to the timeline.");
    }

    public void goDungeon(){
        System.out.println("We are going to the dungeon.");
    }

    public void goSkills(){
        System.out.println("We are going to look at the skills.");
    }

}
