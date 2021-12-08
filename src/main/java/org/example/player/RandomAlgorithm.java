package org.example.player;

import org.example.gameUtils.Coordinate;

import java.util.Random;

public class RandomAlgorithm implements AiAlgorithm{

    protected int generateRandomInRange(int min, int max){
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }


    public Coordinate getCoordinate() {

        int index = generateRandomInRange(0, 99);
        Coordinate target = new Coordinate(index);
        System.out.println(target);
        return target;
    }
}
