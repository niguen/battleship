package org.example.player;

import org.example.gameUtils.Coordinate;
import org.example.gameUtils.Field;
import org.example.gameUtils.ShotResult;

/**
 * Representation of an Ai
 */
public class AiPlayer extends AbstractPlayer {


    private final AiAlgorithm algorithm;

    public AiPlayer(Field opponentField, String name, AiAlgorithm algorithm)
    {
        super(opponentField, name);
        this.algorithm = algorithm;
    }

    /**
     * Enforces an attack and returns a notification to the game, so the result can be displayed.
     * Gives the algorithm feedback on the result of a shot.
     * @return The attack message representing the result of the attack
     */
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


    /**
     * Uses the AiAlgorithm to get the next Coordinate to shoot at.
     * @return the coordinate to shoot at
     */
    protected Coordinate getCoordinate(){ return algorithm.getCoordinate(); }

}
