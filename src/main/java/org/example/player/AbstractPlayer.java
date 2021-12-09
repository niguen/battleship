package org.example.player;


import org.example.gameUtils.Field;


/**
 * Base class for each player.
 *
 */
public abstract class AbstractPlayer {

    /**
     * This is not the field of the opponent.
     */
    Field field;

    String name;

    public AbstractPlayer(Field field, String name) {
        this.field = field;
        this.name = name;
    }

    /**
     * returns a visual representation of the opponents' field.
     * So it can be shown to the player in order to plan the next shot.
     * @return
     */
    public String getFieldString(){
        return field.toString();
    }

    public String getName() {
        return name;
    }

    /**
     * Checks if all enemy ships have been destroyed.
     * @return
     */
    public boolean hasWon(){
        return field.getNumberOfShips() == 0;
    }

}
