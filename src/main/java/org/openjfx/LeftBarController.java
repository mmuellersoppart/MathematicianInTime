package org.openjfx;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class LeftBarController extends VBox {

    @FXML
    private ImageView playerPortrait;

    @FXML
    private Label userName;

    @FXML
    private Label playerTitle;
    @FXML
    private Line healthBar;
    @FXML
    private Line progressBar;
    @FXML
    private Line moneyBar;

    @FXML
    private Label resistanceToReality;
    @FXML
    private Label handEyeCoordination;
    @FXML
    private Label workingMemory;
    @FXML
    private Label seeTheUnseen;
    @FXML
    private Label canArticulate;
    @FXML
    private Label ego;

    @FXML public Label getPlayerTitle() {
        return playerTitle;
    }

    @FXML public Line getHealthBar() {
        return healthBar;
    }

    @FXML public Line getProgressBar() {
        return progressBar;
    }

    @FXML public Line getMoneyBar() {
        return moneyBar;
    }

    @FXML public Label getResistanceToReality() {
        return resistanceToReality;
    }

    @FXML public Label getHandEyeCoordination() {
        return handEyeCoordination;
    }

    @FXML public Label getWorkingMemory() {
        return workingMemory;
    }

    @FXML public Label getSeeTheUnseen() {
        return seeTheUnseen;
    }

    @FXML public Label getCanArticulate() {
        return canArticulate;
    }

    @FXML public Label getEgo() {
        return ego;
    }

    @FXML
    public ImageView getPlayerPortrait() { return playerPortrait; }

    @FXML
    public Label getUserName() { return userName; }

    public LeftBarController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LeftMenuComponent.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
