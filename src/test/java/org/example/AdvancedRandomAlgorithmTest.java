package org.example;

import org.example.gameUtils.Coordinate;
import org.example.player.AdvancedRandomAlgorithm;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdvancedRandomAlgorithmTest {

    AdvancedRandomAlgorithm algo;


    @Before
    public void setUp() {
        algo = new AdvancedRandomAlgorithm();
    }


    @Test
    public void testPositiveCase() {

        algo.getCoordinate();
        algo.hitNotifier();


    }
}
