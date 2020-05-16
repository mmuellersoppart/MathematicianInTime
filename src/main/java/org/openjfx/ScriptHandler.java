//Marlon Mueller-Soppart
//20200306

package org.openjfx;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;


public class ScriptHandler {
    //all script lines will be stored in script
    private ArrayList<Line> script = new ArrayList<>(5);
    private int scriptLength = 0;
    //this is the path the user picks. it'll serve as the history too
    private ArrayList<Integer> scriptPath = new ArrayList<>(5);

    private int currLineId = 0;
    private ArrayList<Integer> lineOptions = null;
    private ArrayList<Integer> nextLines = null;

    //boring
    private File f;
    private BufferedReader br;
    private LineFactory factory1 = new LineFactory();

    //editeable scene elements
    private SceneElements allEditableSceneElements;

    //player info/condition
    private Player player;

    public void printScript() {
        for (Line i : script){
            System.out.print(i.id);
            System.out.println(i.getType());
        }
    }

    //constructors
    ScriptHandler() {
        script = new ArrayList<>(5);
        scriptPath = new ArrayList<>(5);
        currLineId = 0;
        scriptLength = 0;
        f = null;
        br = null;
        factory1 = null;

        allEditableSceneElements = null;
        player = null;
    }
    ScriptHandler(File file, SceneElements allSceneElements, Player inputtedPlayer) throws IOException {

        //take in editable sceneElements
        allEditableSceneElements = allSceneElements;

        //take in player current status
        player = inputtedPlayer;

        f = file;
        try {
            br = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String st;
        while ((st = br.readLine()) != null) {
            convertScriptToLines(st);
        }
        printScript();
    }
    ScriptHandler(String path, SceneElements allSceneElements, Player inputtedPlayer) throws IOException {
        //take in editable sceneElements
        allEditableSceneElements = allSceneElements;

        //take in player current status
        player = inputtedPlayer;

        f = new File(path);

        try {
            br = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String st;
        int lineNum;
        while ((st = br.readLine()) != null) {
            try {
                convertScriptToLines(st);
            } catch (Exception e) {
                System.out.println("failed to convert");
                System.out.println(st);
            }
        }
        printScript();
    }

    private void convertScriptToLines(String line) {
        //in - single string
        //out - Line object
        //ob - converts a line to a Line object of different types

        //check for comment lines
        //the string exists
        if(line != null && !line.isEmpty()) {
            //not a comment
            if(line.charAt(0) != '/' && line.charAt(0) !=  '#' && java.lang.Character.isAlphabetic(line.charAt(0)) ) {
                script.add(factory1.getLineOfType(line, allEditableSceneElements));
                scriptLength = scriptLength + 1;

            }
        }
    }

    public ArrayList<Line> getScript() {
        return script;
    }

    public void setScript(ArrayList<Line> script) {
        this.script = script;
    }

    //getters and setters
    public int getCurrLineId() {
        return currLineId;
    }
    public void setCurrLineId(int currLine) {
        this.currLineId = currLine;
    }
    public int getScriptLength() {
        return scriptLength;
    }
    public void setScriptLength(int scriptLength) {
        this.scriptLength = scriptLength;
    }

    public Line getLine(int id) {
        try {
            return script.get(id);
        } catch (Exception e) {
            System.out.println("ERROR: line id outside script");
            return null;
        }
    }

    ArrayList<Integer> getNextLineIds() {
        /*
        In - nothing
        Out - arrayList of next line ids
        ob - return possible next lines at the currLineId head
         */
        Line currLine = getLine(currLineId);
        return currLine.nextLine;
    }

    public boolean isLineEndOfScript(Line line1) {

        if (line1.nextLine.size() > 1) {
            return false;
        } else {
            return (line1.id == line1.nextLine.get(0));
        }
    }

    private void displayAllNextOptions(ArrayList<Integer> nextLines) {
    /*
    in: list of the next possible lines
    out: nothing yet (in the future it'll be int for chosen id)
    ob: show the user what they can pick from
    */
        //
        for (Integer aNextLineId : nextLines) {
            Line aNextLine = getLine(aNextLineId);
            aNextLine.ExecuteDry();
        }
    }

    public void receiveUserInput(int lineId) {
        /*
        ob - updates scriptHandler based on the line the user picks
         */
        currLineId = lineId;
        scriptPath.add(lineId);

        getLine(currLineId).ExecuteDry();
        System.out.println();


        play();
    }

    public void playAnotherOption() {
        if (lineOptions!=null && lineOptions.size() > 1) {
            currLineId = nextOption();
            Line currLine = getLine(currLineId);
            currLine.ExecuteDry();
        }
    }

    public String returnLineOutput() {
        Line currLine = getLine(currLineId);
        return (currLine.ExecuteDry());
    }

    public Boolean play() {
        System.out.println(currLineId);

        //get line and tell it to execute
        Line currLine = getLine(currLineId);
        System.out.println(currLine.getType().toString());
        currLine.Execute();

        //check for end of script
        if (isLineEndOfScript(currLine)) {
            System.out.println("End...");
            return true;
        }

        //get next line(s)
        nextLines = currLine.nextLine;

        /*
        Setting up for next play()
         */
        //if we know the next line
        //TODO: ugly needs refactoring
        if(nextLines.size() == 1  && (getLine(nextLines.get(0))).getType() != LineTypes.ANSWER) {
            currLineId = nextLines.get(0);
            scriptPath.add(currLineId);
            lineOptions = null;
        //if there are multiple paths
        } else {
            System.out.println(nextLines);
            currLineId = nextLines.get(0);
            lineOptions = nextLines;
            System.out.println(lineOptions);
            Line option = getLine(currLineId);
            option.ExecuteDry();
        }

        return false;
    }

    public int nextOption() {
        int indexOfCurrLine = lineOptions.indexOf(currLineId);

        if (indexOfCurrLine == (lineOptions.size() - 1)){ //we've reached the end
            currLineId = lineOptions.get(0);
        } else {
            currLineId = lineOptions.get(indexOfCurrLine + 1);
        }
        return currLineId;
    }
//end of class
}
