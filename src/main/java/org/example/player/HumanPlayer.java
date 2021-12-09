package org.example.player;

import org.example.gameUtils.Coordinate;
import org.example.gameUtils.Field;
import org.example.gameUtils.ShotResult;

/**
 * A human player that reads the next Coordinate from the console
 */
public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer(Field opponentField, String name) {
        super(opponentField, name);
    }

    /**
     * Attack-method for a human player, that gets the coordinate from the outside.
     *
     * @param coordinate: Coordinate from the human input
     * @return
     */
    public String attack(Coordinate coordinate){

            ShotResult result = field.shootAt(coordinate);
            if(result == ShotResult.HIT){
                return "Enemy ship hit!";
            }else if(result == ShotResult.SUNK){
                return "Enemy ship destroyed";
            }
            else{
                return "Just water ...";
            }
    }



}
