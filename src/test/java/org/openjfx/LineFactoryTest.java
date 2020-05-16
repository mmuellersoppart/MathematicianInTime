package org.openjfx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LLineFactoryTest {

    @Test
    void getLineOfType() {
        //build the line factory
        LineFactory lineFactory1 = new LineFactory();

        //string at hand
        String line1 = "DIALOGUE::0::0::1::Boat Man 1::Ahar matey how goes it?";

        //build dialogue line object
        Line Dline1 = lineFactory1.getLineOfType(line1, null);

        assert Dline1.getType() == LineTypes.DIALOGUE;
        System.out.println(Dline1.Execute());
    }
}