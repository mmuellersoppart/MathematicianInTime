package org.openjfx;

import javafx.scene.layout.BorderPane;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ScriptHandlerTest {
    @Test
    void readInFile1() throws IOException {
        ScriptHandler scriptHandler1;
        String script = new java.io.File( "./src/test/resources/script_test_1.txt" ).getCanonicalPath();
        try {
            scriptHandler1 = new ScriptHandler(script, null, null);
        }
        catch (Exception e) {
            System.out.println("Failed to read in script");
        }
        assert(true);
    }

    @Test
    void convertLinesLength() throws IOException {
        ScriptHandler scriptHandler1 = new ScriptHandler();
        String script = new java.io.File( "./src/test/resources/script_test_1.txt" ).getCanonicalPath();
        try {
            scriptHandler1 = new ScriptHandler(script, null, null);
        } catch (IOException e) {
            System.out.println("Failed to read in script");
        }
        assertEquals(scriptHandler1.getScriptLength(), 4, "Script length should be 4");
    }

    @Test
    void getLineById() throws IOException {
        ScriptHandler scriptHandler1 = new ScriptHandler();
        String script = new java.io.File( "./src/test/resources/script_test_1.txt" ).getCanonicalPath();
        try {
            scriptHandler1 = new ScriptHandler(script, null, null);
        } catch (IOException e) {
            System.out.println("Failed to read in script");
        }

        for (int i = 0; i < scriptHandler1.getScriptLength(); i++) {
            assert( i == scriptHandler1.getLine(i).getId());
        }
    }


    @Test
    void getNextLineId() throws IOException {
        ScriptHandler scriptHandler1 = new ScriptHandler();
        String script = new java.io.File( "./src/test/resources/script_test_1.txt" ).getCanonicalPath();
        try {
            scriptHandler1 = new ScriptHandler(script, null, null);
        } catch (IOException e) {
            System.out.println("Failed to read in script");
        }

        ArrayList<Integer> testIntArray = new ArrayList<>();
        testIntArray.add(1);
        assertArrayEquals(scriptHandler1.getNextLineIds().toArray(), testIntArray.toArray(), "Should have equal arrays");
    }

    @Test
    void playAnswerDialogue() throws IOException {
        ScriptHandler scriptHandler1 = new ScriptHandler();
        String script = new java.io.File( "./src/test/resources/script_test_1.txt" ).getCanonicalPath();
        try {
            scriptHandler1 = new ScriptHandler(script, null, null);
        } catch (IOException e) {
            System.out.println("Failed to read in script");
        }

        scriptHandler1.play();
        assertEquals(scriptHandler1.getCurrLineId(), 1, "Current line ID should be 1");

        scriptHandler1.play();
        assertEquals(scriptHandler1.getCurrLineId(), 2, "Current line ID should be 2");

        scriptHandler1.play();
        assertEquals(scriptHandler1.getCurrLineId(), 3, "Current line ID should be 3");
    }

    @Test
    void playMultipleNext() throws IOException {
        ScriptHandler scriptHandler1 = new ScriptHandler();

        String script = new java.io.File( "./src/test/resources/script_test_1.txt" ).getCanonicalPath();
        try {
            scriptHandler1 = new ScriptHandler(script, null, null);
        } catch (IOException e) {
            System.out.println("Failed to read in script");
        }

        assert (scriptHandler1.returnLineOutput().equals(">(Boat Man 1) Ahar matey how goes it?"));
        System.out.println(scriptHandler1.returnLineOutput());
        scriptHandler1.play();

        assert (scriptHandler1.returnLineOutput().equals(">(Boat Man 2) Nothing goes around here. No wind. Say who are you?"));
        System.out.println(scriptHandler1.returnLineOutput());
        scriptHandler1.play();

        assert (scriptHandler1.returnLineOutput().equals("Leave me alone!"));
        System.out.println(scriptHandler1.returnLineOutput());
        scriptHandler1.play();

        assert (scriptHandler1.returnLineOutput().equals(">(Boat Man 2) We weren't even talking to you."));
        System.out.println(scriptHandler1.returnLineOutput());

        //end of script
        assert(scriptHandler1.play());

    }

    @Test
    void nextOption() throws IOException {
        ScriptHandler scriptHandler1 = new ScriptHandler();

        String script = new java.io.File( "./src/test/resources/script_test_2.txt" ).getCanonicalPath();
        try {
            scriptHandler1 = new ScriptHandler(script, null, null);
        } catch (IOException e) {
            System.out.println("Failed to read in script");
        }

        System.out.println(scriptHandler1.returnLineOutput());
        scriptHandler1.play();

        System.out.println(scriptHandler1.returnLineOutput());
        scriptHandler1.play();

        assertEquals(scriptHandler1.getCurrLineId(),2,  "curr Id is wrong");
        assertEquals(scriptHandler1.nextOption(), 3, "returned wrong option");

    }

}