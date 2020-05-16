package org.openjfx;

public class DialogueLine extends Line{

    private String speaker;
    private String body;

    public DialogueLine(String line_String, SceneElements editableSceneElements) {
        super(line_String, editableSceneElements);

        //get speaker
        try {
            speaker = splitLine[4];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(String.format("ERROR: Failed to find speaker. Line id: %d", id));
        }

        //get body
        try {
            body = splitLine[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(String.format("ERROR: Failed to find body. Line id: %d", id));
            System.out.println(line_String);
        }
    }

    //getters
    public String getSpeaker() { return speaker; }
    public String getBody() { return body; }

    //implementation of execute
    @Override
    public String Execute() {
        String output = ">(" + speaker + ") " + body;

        if(allSceneElements != null) {
            allSceneElements.getTopTextBox().setText(output);
            allSceneElements.getTopTextBox().setStyle("-fx-text-fill: black");
            allSceneElements.getTopTextBox().deselect();
            allSceneElements.getBottomTextBox().deselect();
        }
        return output;
    }

    @Override
    public String ExecuteDry() {
        String output = ">(" + speaker + ") " + body;

        if(allSceneElements != null) {
            allSceneElements.getTopTextBox().setText(output);
        }
        return output;
    }
}
