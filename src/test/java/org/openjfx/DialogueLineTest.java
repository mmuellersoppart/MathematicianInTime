package org.openjfx;

import org.junit.jupiter.api.Test;
import org.openjfx.DialogueLine;
import org.openjfx.LineTypes;
import java.util.ArrayList;

class DialogueLineTest {



    @Test
    void constructor_memberVariables1() {
        String line1 = "DIALOGUE::0::0::1::Boat Man 1::Ahar matey how goes it?";
        DialogueLine dLine1 = new DialogueLine(line1, null);
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        assert (dLine1.getId() == 0);
        assert (dLine1.type == LineTypes.DIALOGUE);
        assert (dLine1.previousLine == 0);
        assert (dLine1.nextLine.equals(arr1));
        assert (dLine1.getSpeaker().equals("Boat Man 1"));
        assert (dLine1.getBody().equals("Ahar matey how goes it?"));
    }

    @Test
    void constructor_memberVariables2() {
        String line1 = "DIALOGUE::0::0::[1,2]::Boat Man 1::Ahar matey how goes it?";
        DialogueLine dLine1 = new DialogueLine(line1, null);
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        assert (dLine1.getId() == 0);
        assert (dLine1.type == LineTypes.DIALOGUE);
        assert (dLine1.previousLine == 0);
        assert (dLine1.nextLine.equals(arr1));
        assert (dLine1.getSpeaker().equals("Boat Man 1"));
        assert (dLine1.getBody().equals("Ahar matey how goes it?"));
    }

    @Test
    void justAnExample2() {
        assert(true);
    }
}
