package org.openjfx

import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import org.openjfx.Player.currHealth
import org.openjfx.Player.healthMax
import org.openjfx.Player.name

class SceneAssembler (private var mainBPane: BorderPane, private val player1: Player) {
    /*
    Attach everything to the mainBPane that is universal to all of them.
    Keep track of all elements in the scene.
    return allSceneElements
     */

    private val barMax = 200

    private val topBarController: TopBarController = TopBarController()
    private val leftBarController: LeftBarController = LeftBarController()
    private val rightBarController: RightBarController = RightBarController()
    //scene controller might need access to these (but probably not)
    fun returnControllerT(): TopBarController { return topBarController; }
    fun returnControllerL(): LeftBarController { return leftBarController; }
    fun returnControllerR(): RightBarController { return rightBarController; }

    init {
        mainBPane.top = topBarController
        mainBPane.left = leftBarController
        mainBPane.right = rightBarController

        //set default action for top bar
        topBarController.topBarHome.setOnAction { println("Trying to go home.") }
        topBarController.topBarDungeon.setOnAction { println("dungeon time") }
        topBarController.topBarTimeline.setOnAction { println("timeline") }
        topBarController.topBarSkills.setOnAction { println("skills") }

        //deselect everything
        mainBPane.requestFocus()
    }

    fun updateEnvironment() {
        /* Update everything based on User status and progress */
        println("updating...")
        name
        println("Name: $name")
        leftBarController.userName.text = name
        getPlayerTitle().text = Player.characterType
        println("Player type: ${Player.characterType}")
        getPlayerProfileImageView().image = Player.characterPic


        //update stats based on player
        getPlayerEgo().text = Player.ego.toString()
        getPlayerCanArticulate().text = Player.canArticulate.toString()
        getPlayerHandEyeCoordination().text = Player.handEyeCoordination.toString()
        getPlayerSeeTheUnseen().text = Player.seeingInvisibleThings.toString()
        getPlayerResistanceToReality().text = Player.resistanceToReality.toString()
        getPlayerWorkingMemory().text = Player.workingMemory.toString()

        //remove focus
        //TODO: remove focus from right bottom text box at the beginning of scenes
        mainBPane.requestFocus()

        //TODO: reset text box styles after damage


        //TODO: adjust health bar based on remaining health
        leftBarController.healthBar.endX = if ((currHealth/healthMax) * barMax >= 0.0) ((currHealth/healthMax) * barMax) else 1.0

        println("CurrHealt: $currHealth and healthBarLength: ${leftBarController.healthBar.endX}")
    }

    //function for accessing top bar stuff
    fun getHomeButton(): Button { return topBarController.topBarHome }
    fun getTimeLineButton(): Button { return topBarController.topBarTimeline }
    fun getDungeonButton(): Button {return topBarController.topBarDungeon }
    fun getSkillsButton(): Button {return topBarController.topBarSkills}

    //functions to access leftBarController stuff
    fun getPlayerProfileImageView(): ImageView { return leftBarController.playerPortrait }
    fun getPlayerUserNameLabel(): Label { return leftBarController.userName }
    fun getPlayerTitle(): Label { return leftBarController.playerTitle}
    //function to access all of the stats
    fun getPlayerEgo(): Label {return leftBarController.ego}
    fun getPlayerWorkingMemory(): Label {return leftBarController.workingMemory}
    fun getPlayerCanArticulate(): Label {return leftBarController.canArticulate}
    fun getPlayerResistanceToReality(): Label {return leftBarController.resistanceToReality}
    fun getPlayerHandEyeCoordination(): Label {return leftBarController.handEyeCoordination}
    fun getPlayerSeeTheUnseen(): Label {return leftBarController.seeTheUnseen}


    //functions to access rightBarController stuff
    fun getTopTextBox(): TextArea {return rightBarController.topTextBox}
    fun getBottomTextBox(): TextArea {return rightBarController.bottomTextBox}



    fun returnAllSceneElements(): SceneElements {return SceneElements(mainBPane, getTopTextBox(), getBottomTextBox(), getPlayerUserNameLabel(), getPlayerProfileImageView(), getPlayerTitle())
    }

}