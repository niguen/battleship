package org.example.player;

import org.example.gameUtils.Coordinate;
import org.example.gameUtils.Field;


public abstract class AbstractPlayer {

    Field field;
    String name;

    public AbstractPlayer(String opponent, String name) {
        this.name = name;
        this.field = new Field(opponent);
    }

    public String getName() {
        return name;
    }

    protected abstract Coordinate getCoordinate();

    public String attack(){
        System.out.println(getName() + " your turn:");
        System.out.println(field);
        Coordinate coordinate = getCoordinate();
        return field.shootAt(coordinate);
    }




}
