package org.openjfx;

import com.sun.javafx.fxml.builder.JavaFXImageBuilder;
import com.sun.javafx.fxml.builder.JavaFXSceneBuilder;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.input.KeyCode.*;

public class NavController implements Initializable {

    //invisible buttons (not in GUI)
    public Button enterButton;
    public Button upButton;
    public Button downButton;

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

        //get all editable elements
        SceneElements allSceneElements = sceneAssembler1.returnAllSceneElements();

        //update environment based on player info
        sceneAssembler1.updateEnvironment();

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
                finalScript.play();
            }

            if(keyCode == UP || keyCode == DOWN){
                finalScript.playAnotherOption();
            }

            if(keyCode == ESCAPE) {
                mainBPain.requestFocus();
            }
            sceneAssembler1.updateEnvironment();
        });


    }





}
