package org.example;

import org.example.gameUtils.Coordinate;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class CoordinateTest {

    Coordinate coordinate, coordinate2, coordinate3, coordinate4, coordinate5, coordinate6;


    @Before
    public void setUp() {
        coordinate = new Coordinate("A1");
        coordinate2 = new Coordinate("J10");
        coordinate3 = new Coordinate("A10");

        coordinate4 = new Coordinate(0);
        coordinate5 = new Coordinate(10);
        coordinate6 = new Coordinate(99);


    }


    @Test
    public void testPositiveCase() {

        assertEquals("A1", coordinate.toString());
        assertEquals(0, coordinate.getArrayIndex());

        assertEquals("A10", coordinate3.toString());
        assertEquals(90, coordinate3.getArrayIndex());

        assertEquals("J10", coordinate2.toString());
        assertEquals(99, coordinate2.getArrayIndex());

        //0
        assertEquals("A1", coordinate4.toString());
        assertEquals(0, coordinate4.getArrayIndex());

        //10
        assertEquals("A2", coordinate5.toString());
        assertEquals(10, coordinate5.getArrayIndex());

        //99
        assertEquals("J10", coordinate6.toString());
        assertEquals(99, coordinate6.getArrayIndex());




    }

    @Test
    public void testNegativeCase() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> new Coordinate(null));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Coordinate("1A"));
    }
}
