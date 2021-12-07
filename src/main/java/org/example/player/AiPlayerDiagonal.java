package org.example.player;

import org.example.gameUtils.Coordinate;

public class AiPlayerDiagonal extends AbstractAiPlayer{



    int[] shots;

    public AiPlayerDiagonal(String opponent, String name) {
        super(opponent, name);
    }

    @Override
    protected Coordinate getCoordinate() {

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
}
