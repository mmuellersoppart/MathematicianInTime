//Marlon Mueller-Soppart
//20200306

package org.openjfx;

public final class LineParser {

    static final String regex = "(::)";

    private LineParser() {

    }

    private static String[] splitLine(String line) {
        String[] splitLine;
        splitLine = line.split(regex);
        return splitLine;
    }

    public static LineTypes getType(String line) {
        LineTypes type1 = LineTypes.DIALOGUE;
        String[] splitLine = splitLine(line);
        int id = -1;

        //get id
        try {
            id = Integer.parseInt(splitLine[1]);
        } catch (NumberFormatException e) {
            System.out.println("ERROR: failed to convert id num.");
        }

        //get TYPE
        try {
            type1 = LineTypes.valueOf(splitLine[0]);
        } catch (IllegalArgumentException e) {
            System.out.println(String.format("ERROR: failed to convert string to enum. line num: %d", id));
        }
        return type1;
    }

    public static int getID(String line) {
        int id = -1;
        String[] splitLine;

        splitLine = splitLine(line);

        //get id
        try {
            id = Integer.parseInt(splitLine[1]);
        } catch (NumberFormatException e) {
            System.out.println("ERROR: failed to convert id num.");
        }
        return id;
    }

}
