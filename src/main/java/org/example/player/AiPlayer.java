package org.example.player;

import org.example.gameUtils.Coordinate;
import org.example.gameUtils.ShotResult;

public class AiPlayer extends AbstractPlayer {


    private AiAlgorithm algorithm;

    public AiPlayer(String opponent,String name, AiAlgorithm algorithm)
    {
        super(opponent, name);
        this.algorithm = algorithm;
    }

    public String attack(){
        System.out.println(getName() + " your turn:");
        System.out.println(field);
        Coordinate coordinate = getCoordinate();
        ShotResult result = field.shootAt(coordinate);
        if(result == ShotResult.HIT){
            algorithm.hitNotifier();
            return "Enemy ship hit!";
        }else{
            return "Just water ...";
        }
    }


    protected Coordinate getCoordinate(){

        return algorithm.getCoordinate();
    }

}
