package org.openjfx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.image.Image;

public class PrimaryController extends App {


    @FXML
    private void switchToChooseCharacter() throws IOException {
        App.setRoot("Intro2_characters");
    }


}
