package org.example.gameUtils;

import java.util.Random;

public class MathUtil {

    public static int generateRandomInRange(int min, int max){

        Random r = new Random();
        return r.nextInt(max - min) + min;
    }
}
