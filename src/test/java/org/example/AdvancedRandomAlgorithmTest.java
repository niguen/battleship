package org.example;

import org.example.gameUtils.Coordinate;
import org.example.player.AdvancedRandomAlgorithm;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the behaviour of the algorithm, when a ship has been hit.
 */
public class AdvancedRandomAlgorithmTest {

    AdvancedRandomAlgorithm algo;
    Coordinate coordinate, nextCoordinate;


    @Before
    public void setUp() {
        algo = new AdvancedRandomAlgorithm();
        coordinate = algo.getCoordinate();
        algo.hitNotifier();

        // The next coordinate should be one row above
        int index = coordinate.getArrayIndex();
        nextCoordinate = new Coordinate(index - 10);

    }


    @Test
    public void testPositiveCase() {

        assertEquals(algo.getCoordinate().toString(), nextCoordinate.toString());

    }
}
