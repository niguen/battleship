package org.example.player;


import org.example.gameUtils.Field;

public abstract class AbstractPlayer {

    Field field;
    String name;

    public AbstractPlayer(Field field, String name) {
        this.field = field;
        this.name = name;
    }

    public String getFieldString(){
        return field.toString();
    }

    public String getName() {
        return name;
    }

    public boolean hasWon(){
        return field.getNumberOfShips() == 0;
    }

}
