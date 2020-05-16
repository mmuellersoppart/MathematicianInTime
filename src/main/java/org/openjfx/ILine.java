//Marlon Mueller-Soppart
//20200222
//ob - what every type of line object should be able to do
package org.openjfx;

import java.util.ArrayList;

public interface ILine {
    LineTypes getType();
    ArrayList NextLine();
    int PreviousLine();
    String Execute();

    //executes much like above - but does not make any real changes
    String ExecuteDry();
}
