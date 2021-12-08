package org.example.player;

import org.example.gameUtils.Coordinate;

import java.util.Random;

public class DiagonalAlgorithm implements AiAlgorithm{

    int[] shots;

    @Override
    public Coordinate getCoordinate() {

        int index = generateRandomInRange(0, 99);
        Coordinate target = new Coordinate(index);
        System.out.println(target);
        return target;
    }

    private boolean shotAlreadyFired(int index){
        for(int shot : shots){
            if(index == shot){
                return true;
            }
        }
        return false;
    }

    protected int generateRandomInRange(int min, int max){
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }
}
