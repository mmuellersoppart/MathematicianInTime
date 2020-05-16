package org.openjfx

import javafx.scene.image.Image
import javax.swing.text.html.ImageView

/*
Character class
Defines all the values important to the character.

Note 1: object keyword means this class is a singleton.
 */

object Player {
    //Immutable characteristics
    var name: String = "Default_Name"
    var characterType: String = ""
    var characterPic: Image = Image(javaClass.getResource("0000_Default.png").toExternalForm())

    //Current Condition
    var healthMax: Double = 10.0
    var currHealth: Double = 10.0
    var progress: Int = 0
    var money: Int = 0

    //Status
    var resistanceToReality: Int = 0
    var handEyeCoordination: Int = 0
    var workingMemory: Int = 0
    var seeingInvisibleThings: Int = 0
    var canArticulate: Int = 0
    var ego: Int = 0

    var inventory: List<Item>? = null
}

data class Item(val name: String, val imagePath: String, val itemPage: String)