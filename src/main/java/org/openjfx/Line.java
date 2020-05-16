//Marlon Mueller-Soppart
//
//Updated: 20200306

package org.openjfx;

import java.nio.channels.NonReadableChannelException;
import java.util.Arrays;
import java.util.Vector;
import java.util.ArrayList;


public abstract class Line implements ILine {

    public LineTypes type;
    public int id;
    public ArrayList<Integer> nextLine = new ArrayList<>();
    public int previousLine;
    public String[] splitLine;
    public SceneElements allSceneElements;



    public Line(String line_String, SceneElements submittedElements)
    {
        //include manipulatable elements
        allSceneElements = submittedElements;

        //parse the line for type, id, previous, and next line(s)
        String regex = "(::)";
        splitLine = line_String.split(regex);
        id = LineParser.getID(line_String);
        type = LineParser.getType(line_String);

        //prev
        try {
            previousLine = Integer.parseInt(splitLine[2]);
        } catch (NumberFormatException e) {
            System.out.println(String.format("ERROR: failed to convert previous line string to int. line num: %d", id));
        }

        //next
        String nextLineString = splitLine[3];
        try {

            if(java.lang.Character.isDigit( nextLineString.charAt(0) )) {
                nextLine.add(Integer.parseInt(nextLineString));
            } else {
                //remove brackets
                nextLineString = nextLineString.substring(1, nextLineString.length() - 1);
//                System.out.println(nextLineString);

                String[] nextLinesList = nextLineString.split(",");

                for(String lineNum: nextLinesList){
                    nextLine.add(Integer.parseInt(lineNum));
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(String.format("ERROR: failed to convert next line string to int. line num: %d", id));
        }

    }

    //getters
    public LineTypes getType() { return type; }
    public int getId() { return id; }
    public ArrayList<Integer> getNextLine() { return nextLine; }
    public int getPrevLine() { return previousLine; }

    //implementing interface
    @Override
    public ArrayList<Integer> NextLine() {
        return nextLine;
    }

    @Override
    public int PreviousLine() {
        return previousLine;
    }

    @Override
    public String Execute() {
        return "Hello";
    }

    @Override
    public String ExecuteDry() {
        return "SafeHello";
    }


}
