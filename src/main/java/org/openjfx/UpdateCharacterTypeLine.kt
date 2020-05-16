package org.openjfx

import javafx.scene.image.Image
import kotlin.random.Random

class UpdateCharacterTypeLine(line_String: String?, allChangeableElements: SceneElements) : Line(line_String, allChangeableElements) {
    private var characterOrb: String? = null
    var player = Player

    init {
        allSceneElements = allChangeableElements
    }
    //
    //    public String orbToCharacterType() {
    //        switch (characterOrb);
    //    }
    //implementation of execute
    override fun Execute(): String {

        //get answer in textbox
        //get orb
        characterOrb = allSceneElements.bottomTextBox.text
        //get first line of bottom textbox
        characterOrb = characterOrb!!.substring(0, characterOrb!!.indexOf('\n'))
        println(String.format("this orb was picked: %s", characterOrb))

        val newImg: Image
        when (characterOrb) {
            "Take the calm orb." -> {
                newImg = Image(javaClass.getResource("0000_Quiet.png").toExternalForm())
                player.characterType = "Quiet Guy"
                player.characterPic = newImg

                //initial stats
                player.resistanceToReality = 2
            }
            "Take the grey orb." -> {
                newImg = Image(javaClass.getResource("0000_NumCruncher.png").toExternalForm())
                player.characterType = "Number Cruncher"
                player.characterPic = newImg

                //initial stats
                player.resistanceToReality = 1
                player.canArticulate = 1
            }
            "Take the multicolored orb." -> {
                newImg = Image(javaClass.getResource("0000_Polymath.png").toExternalForm())
                player.characterType = "Polymath"
                player.characterPic = newImg

                //initial stats
                player.canArticulate = 2
                player.seeingInvisibleThings = 1
                player.workingMemory = 2
                player.ego = 1
            }
            "Take the knowledge that there was in fact an orb that existed and then disappeared." -> {
                newImg = Image(javaClass.getResource("0000_Truther.png").toExternalForm())
                player.characterType = "Truther"
                player.characterPic = newImg

                //initial stats
                player.seeingInvisibleThings = 3
                player.resistanceToReality = 1
                player.ego = 2
            }
            else -> {
                newImg = Image(javaClass.getResource("0000_EntwinedEgo.png").toExternalForm())
                player.characterType = "Ego Entwined"
                player.characterPic = newImg

                //initial stats
                player.workingMemory = 3
                player.ego = 4
            }
        }
        return characterOrb as String
    }

    override fun ExecuteDry(): String {
        return "Correct"
    }


}