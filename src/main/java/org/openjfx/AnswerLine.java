package org.openjfx;

public class AnswerLine extends Line{

    private String body;

    public AnswerLine(String line_String, SceneElements allChangeableElements) {
        super(line_String, allChangeableElements);

        //get body
        try {
            body = splitLine[4];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(String.format("ERROR: Failed to find body. Line id: %d", id));
        }
    }

    //getters
    public String getBody() { return body; }

    //implementation of execute
    @Override
    public String Execute() {
        String output = body;
        if(allSceneElements != null) {
            output = allSceneElements.getBottomTextBox().getText();
            allSceneElements.getBottomTextBox().setText(output + "\nSubmitted");
        }
        return output;
    }

    @Override
    public String ExecuteDry() {
        String output = body;
        System.out.println(body);
        if(allSceneElements != null) {
            allSceneElements.getBottomTextBox().clear();
            allSceneElements.getBottomTextBox().setText(output);
        }
        return output;
    }
}
