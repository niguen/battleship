package org.example.player;

import org.example.gameUtils.Coordinate;

import java.util.Random;

public class AiPlayer extends AbstractPlayer {


    private AiAlgorithm algorithm;

    public AiPlayer(String opponent, String name, AiAlgorithm algorithm)
    {
        super(opponent, name);
        this.algorithm = algorithm;
    }

    protected int generateRandomInRange(int min, int max){

        Random r = new Random();
        return r.nextInt(max - min) + min;
    }

    protected Coordinate getCoordinate(){

        return algorithm.getCoordinate();
    }

}
