package org.openjfx
import javafx.scene.image.Image
import javafx.scene.paint.Color
import kotlin.math.E
import kotlin.math.abs
import kotlin.math.pow

class DamageLine(line_String: String?, allChangeableElements: SceneElements) : Line(line_String, allChangeableElements) {
    private var characterOrb: String? = null
    var player = Player

    var typeOfDamage: String = ""
    var amtOfDamage: Int = 0
    var body: String = ""

    //extract extra information from the line
    init {
        //get type of damage
        try {
            typeOfDamage = splitLine[4]
        } catch (e: ArrayIndexOutOfBoundsException) {
            println(String.format("ERROR: Failed to find type of damage. Line id: %d", id))
        }

        //amtOfDamage
        try {
            amtOfDamage = splitLine[5].toInt()
        } catch (e: ArrayIndexOutOfBoundsException) {
            println(String.format("ERROR: Failed to find body. Line id: %d", id))
        }

        //get body
        try {
            body = splitLine[6]
        } catch (e: ArrayIndexOutOfBoundsException) {
            println(String.format("ERROR: Failed to find body. Line id: %d", id))
        }

        //assign scene element //this totally unnessary but makes me feel good
        allSceneElements = allChangeableElements
    }

    override fun Execute(): String {
        //TODO: adjust player health

        when (typeOfDamage) {
            "Awkward" -> {
                val message = "$body\n\n$amtOfDamage Awkward Damage"
                allSceneElements.topTextBox.text = message
                allSceneElements.topTextBox.style = "-fx-text-fill: darkgreen"

                //do awkward damage
                val damage =  amtOfDamage * (Player.resistanceToReality + 1.0).pow(-1) - Player.canArticulate.toDouble()/10.0 - Player.handEyeCoordination.toDouble()/10 + Player.ego.toDouble()/10
                player.currHealth -= damage

                //making sure currHealth does not go above max health
                player.currHealth = if (player.currHealth >= player.healthMax) player.healthMax else player.currHealth

                println("Awkward Damage: $damage")
                println("$amtOfDamage * ${(Player.resistanceToReality + Player.canArticulate + Player.handEyeCoordination - player.ego).toDouble().pow(-1)}")
                return message
            }
            "Mental" -> {
                val message =  "$body\n\n$amtOfDamage Mental Damage"
                allSceneElements.topTextBox.text = message
                allSceneElements.topTextBox.style = "-fx-text-fill: darkblue"

                //calculate mental damage
                val damage = amtOfDamage * (Player.resistanceToReality + 1.0).pow(-1) + (Player.workingMemory + Player.seeingInvisibleThings)/10
                player.currHealth -= damage

                //making sure currHealth does not go above max health
                player.currHealth = if (player.currHealth >= player.healthMax) player.healthMax else player.currHealth

                println("Mental Damage: $damage")

                return message
            }
        }
        return "blah"
    }

    override fun ExecuteDry(): String {
        return "Correct"
    }


}