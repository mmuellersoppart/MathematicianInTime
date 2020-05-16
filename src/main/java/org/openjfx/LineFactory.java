//Marlon Mueller-Soppart
//20200306

package org.openjfx;

public class LineFactory {

    public Line getLineOfType(String line, SceneElements allEditableElements){
        LineTypes type = LineParser.getType(line);

        switch (type) {
            case DIALOGUE: return new DialogueLine(line, allEditableElements);
            case ANSWER: return new AnswerLine(line, allEditableElements);
            case CHECK: return new CheckLine(line, allEditableElements);
            case DAMAGE: return new DamageLine(line, allEditableElements);
            case UPDATE_NAME: return new UpdateNameLine(line, allEditableElements);
            case UPDATE_CHARACTERTYPE: return new UpdateCharacterTypeLine(line, allEditableElements);
            default: System.out.println("ERRROR: factory failed. Something wrong with input."); return null;
        }
    }
}
