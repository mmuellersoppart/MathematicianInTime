package org.openjfx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineParserTest {

    @Test
    void getType() {
        LineTypes type = LineParser.getType("DIALOGUE::0::0::1::Boat Man 1::Ahar matey how goes it?");
        assert (type == LineTypes.DIALOGUE);
    }

    @Test
    void getID() {
        int id = LineParser.getID("DIALOGUE::0::0::1::Boat Man 1::Ahar matey how goes it?");
        assert (id == 0);
    }
}