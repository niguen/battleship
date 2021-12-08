package org.example.player;

import org.example.gameUtils.Coordinate;
import org.example.gameUtils.Field;
import org.example.gameUtils.ShotResult;


public abstract class AbstractPlayer {

    Field field;
    String name;

    public AbstractPlayer(String opponent, String name) {
        this.field = new Field(opponent);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected abstract Coordinate getCoordinate() throws IllegalArgumentException;

    public String attack(){
        System.out.println(getName() + " your turn:");
        System.out.println(field);
        try{
            Coordinate coordinate = getCoordinate();
            ShotResult result = field.shootAt(coordinate);
            if(result == ShotResult.HIT){
                return "Enemy ship hit!";
            }else{
                return "Just water ...";
            }

        }catch (IllegalArgumentException ex){
            return "";
        }
    }

    public boolean hasWon(){
        return field.getNumberOfShips() == 0;
    }




}
