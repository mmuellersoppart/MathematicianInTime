package org.openjfx

import java.util.*

class UpdateNameLine(line_String: String?, allChangeableElements: SceneElements?) : Line(line_String, allChangeableElements) {
    //getters
    /*
        Line purely updates Name of player
         */
    // N - numerical, S - string
    val answer1: String? = null
    var errors: ArrayList<Double>? = null
    var nextLines: ArrayList<Int>? = null
    var player = Player

    //implementation of execute
    override fun Execute(): String {
        var answer = allSceneElements.bottomTextBox.text
        answer = answer.substring(0, answer.indexOf('\n'))
        player.name = answer
        allSceneElements.userName.text = player.name
        return answer
    }

    override fun ExecuteDry(): String {
        return "Correct"
    }
}