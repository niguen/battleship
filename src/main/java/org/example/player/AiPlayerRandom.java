package org.example.player;

import org.example.gameUtils.Coordinate;

import java.util.Random;

public class AiPlayerRandom extends AbstractAiPlayer {


    public AiPlayerRandom(String opponent, String name) {
        super(opponent, name);
    }

    @Override
    protected Coordinate getCoordinate() {

        int index = generateRandomInRange(0, 99);
        Coordinate target = new Coordinate(index);
        System.out.println(target);
        return target;
    }


}
