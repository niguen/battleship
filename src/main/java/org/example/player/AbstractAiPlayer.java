package org.example.player;

import org.example.gameUtils.Coordinate;

import java.util.Random;

public abstract class AbstractAiPlayer extends AbstractPlayer {


    public AbstractAiPlayer(String opponent, String name) {
        super(opponent, name);
    }

    protected int generateRandomInRange(int min, int max){

        Random r = new Random();
        return r.nextInt(max - min) + min;
    }

    protected abstract Coordinate getCoordinate();

}
