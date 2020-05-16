package org.openjfx;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.input.KeyCode.*;

public class Z00001_Welcome_Controller implements Initializable {

    //retrieving the fxml element
    public BorderPane mainBPain;

//    @FXML
//    void clickButton(ActionEvent event) {
//        mainBPain.setOnKeyPressed(e -> {  } );
//
//    }

    //Creating custom component
    private TopBarController topBarController = new TopBarController();
    private LeftBarController leftBarController = new LeftBarController();
    private RightBarController rightBarController = new RightBarController();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //set up components and script
        SceneAssembler sceneAssembler1 = new SceneAssembler(mainBPain, Player.INSTANCE);

        //scene specific update
        sceneAssembler1.getHomeButton().setVisible(false);
        sceneAssembler1.getTimeLineButton().setVisible(false);
        sceneAssembler1.getSkillsButton().setVisible(false);
        sceneAssembler1.getDungeonButton().setVisible(false);

        SceneElements allSceneElements = sceneAssembler1.returnAllSceneElements();

        //update environment based on player info
        sceneAssembler1.updateEnvironment();

        /* Specific to scene */
        String scriptPath = "";
        try {
            scriptPath = new java.io.File("src/main/resources/org/openjfx/script_Intro_ButtonTutorial.txt").getCanonicalPath();
        } catch (IOException e) {
            System.out.println("ERROR: script_Intro_ButtonTutorial failed");
        }

        ScriptHandler script1 = new ScriptHandler();
        try {
            script1 = new ScriptHandler(scriptPath, allSceneElements, Player.INSTANCE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /* *** set up script end *** */


        /* set up enter, up, down */
        ScriptHandler finalScript = script1;
        mainBPain.setOnKeyPressed(e-> {
            KeyCode keyCode = e.getCode();

            if(keyCode == ENTER) {
                if(finalScript.play()) {
                    try {
                        App.setRoot("Z00002_ChooseOrb");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

                sceneAssembler1.updateEnvironment();
            }

            if(keyCode == UP || keyCode == DOWN){
                finalScript.playAnotherOption();
            }

            if(keyCode == ESCAPE) {
                mainBPain.requestFocus();
            }
        });


    }





}
