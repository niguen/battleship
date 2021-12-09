package org.example.player;

import org.example.gameUtils.Coordinate;
import org.example.gameUtils.Field;
import org.example.gameUtils.ShotResult;

public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer(Field opponentField, String name) {
        super(opponentField, name);
    }

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
