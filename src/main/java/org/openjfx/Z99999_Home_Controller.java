package org.openjfx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.input.KeyCode.*;

public class Z99999_Home_Controller implements Initializable {

    //invisible buttons (not in GUI)
    public Button enterButton;
    public Button upButton;
    public Button downButton;

    public int timesYouveSatInChair = 0;

    @FXML
    public Button bedButton;
    @FXML
    public Button chestButton;
    @FXML
    public Button chairButton;

    //retrieving the fxml element
    public BorderPane mainBPain;

    //Creating custom component
    private TopBarController topBarController = new TopBarController();
    private LeftBarController leftBarController = new LeftBarController();
    private RightBarController rightBarController = new RightBarController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        //set up components and script
        SceneAssembler sceneAssembler1 = new SceneAssembler(mainBPain, Player.INSTANCE);

        //you can't go there yet
        sceneAssembler1.getTimeLineButton().setVisible(false);
        sceneAssembler1.getSkillsButton().setVisible(false);
        sceneAssembler1.getDungeonButton().setVisible(false);

        //get all editable elements
        SceneElements allSceneElements = sceneAssembler1.returnAllSceneElements();

        //update environment based on player info
        sceneAssembler1.updateEnvironment();

        /* *** set up script end *** */

        chestButton.setOnAction(e-> {
            try {
                App.setRoot("Z99999_Inventory");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        chairButton.setOnAction(e -> {
            timesYouveSatInChair += 1;
            String message = ">(Narrator) You have taken a seat in your chair " + timesYouveSatInChair + " times.";
            sceneAssembler1.getTopTextBox().setText(message);
        });

        bedButton.setOnAction(e -> {
            try {
                App.setRoot("Z00004_Dream1");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        mainBPain.setOnKeyPressed(e-> {
            KeyCode keyCode = e.getCode();
            if(keyCode == ESCAPE) {
                mainBPain.requestFocus();
            }
        });

        sceneAssembler1.getHomeButton().setOnAction(e -> {
            try {
                App.setRoot("Z99999_Home");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }





}
