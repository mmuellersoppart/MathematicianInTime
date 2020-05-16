package org.openjfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class RightBarController extends VBox {

    @FXML
    private TextArea topTextBox;

    @FXML
    private TextArea bottomTextBox;

    @FXML
    public TextArea getTopTextBox() { return topTextBox; }

    @FXML
    public TextArea getBottomTextBox() { return bottomTextBox; }


    public RightBarController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RightTextBoxComponent.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
