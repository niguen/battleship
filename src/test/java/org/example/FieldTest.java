package org.example;

import org.example.gameUtils.Coordinate;
import org.example.gameUtils.Field;
import org.example.gameUtils.ShotResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class FieldTest {

    Field fieldAlice;
    Coordinate coordinateHit, coordinateMiss;

    @Before
    public void setUp() {

        fieldAlice = new Field("Alice");
        coordinateHit = new Coordinate("B3");
        coordinateMiss = new Coordinate("A1");


    }

    @Test
    public void testGetNumberOfShips() {

        assertEquals(fieldAlice.getNumberOfShips(), 5);
    }

    @Test
    public void testShootAt() {

        assertEquals(fieldAlice.shootAt(coordinateHit), ShotResult.HIT);
        assertEquals(fieldAlice.shootAt(coordinateMiss), ShotResult.MISS);
    }



    @Test
    public void testNegativeCase() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> new Coordinate(null));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Coordinate("Blank"));



    }


}
