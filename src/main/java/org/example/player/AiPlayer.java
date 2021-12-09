package org.example.player;

import org.example.gameUtils.Coordinate;
import org.example.gameUtils.Field;
import org.example.gameUtils.ShotResult;

public class AiPlayer extends AbstractPlayer {


    private final AiAlgorithm algorithm;

    public AiPlayer(Field opponentField, String name, AiAlgorithm algorithm)
    {
        super(opponentField, name);
        this.algorithm = algorithm;
    }

    public String attack(){
        Coordinate coordinate = getCoordinate();
        ShotResult result = field.shootAt(coordinate);
        if(result == ShotResult.HIT){
            algorithm.hitNotifier();
            return "Enemy ship hit!";
        }else if(result == ShotResult.SUNK){
            return "Enemy ship sunk!";
        }else{
            return "Just water ...";
        }
    }


    protected Coordinate getCoordinate(){ return algorithm.getCoordinate(); }

}
