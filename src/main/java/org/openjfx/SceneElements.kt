package org.openjfx

import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane

data class SceneElements(
        //main borderpane (for changing center image)
        val mainBorderPane: BorderPane,

        //textbox links
        val topTextBox: TextArea,
        val bottomTextBox: TextArea,

        //user elements
        val userName: Label,
        val userPic: ImageView,

        val userTitle: Label
) //end of class