package org.openjfx;

import java.awt.*;
import java.util.ArrayList;

public class CheckLine extends Line{

    /*
    //1. compares answer in script compared to user input in bottom text box
    //2. sees how close we are if numerical
    //3. chooses a path based on accuracy
     */

    private char typeOfAnswer;
    // N - numerical, S - string
    private String Answer1;
    ArrayList<Double> errors;
    ArrayList<Integer> nextLines;

    public CheckLine(String line_String, SceneElements allChangeableElements) {
        super(line_String, allChangeableElements);

        //get type of answer
        try {
            typeOfAnswer = splitLine[4].charAt(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(String.format("ERROR: Failed to find body. Line id: %d", id));
        }


    }

    //getters
    public String getAnswer1() {
        return Answer1;
    }

    //implementation of execute
    @Override
    public String Execute() {
        String answer = allSceneElements.getBottomTextBox().getText();
        allSceneElements.getUserName().setText(answer);
        return answer;
    }

    @Override
    public String ExecuteDry() {
        return "Correct";
    }
}
