package org.example.gameUtils;

import java.util.Random;

/**
 * Custom class that holds custom math-functions
 */
public class MathUtil {

    /**
     * Generates a random Integer between min and max.
     * @param min
     * @param max
     * @return
     */
    public static int generateRandomInRange(int min, int max){

        Random r = new Random();
        return r.nextInt(max - min) + min;
    }
}
