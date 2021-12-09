package org.example.gameUtils;

/**
 * Represents the Coordinate and the different representations of it.
 * A Coordinate can be in the human readable form ("A1"), in the representation
 * of two numbers (row and column) or as an array index, which is used by the field-class.
 */
public class Coordinate {

    private final int row;
    private final int column;

    /**
     * Constructor that takes a Coordinate from the input.
     * @param coordinateString
     */
    public Coordinate(String coordinateString){
        if( coordinateString == null || coordinateString.length() > 3 ){
            throw new IllegalArgumentException();
        }

        column = coordinateString.charAt(0) - 65;
        if( column > 10 || column < 0 ){
            throw new IllegalArgumentException();
        }

        coordinateString = coordinateString.substring(1);
        row = Integer.parseInt(coordinateString) - 1;

        if( row > 10 || row < 0 ){
            throw new IllegalArgumentException();
        }
    }

    /**
     * Constructor that takes the coordinate as an array index.
     * @param index
     */
    public Coordinate(int index){
        row = index / 10;
        column = index - ( row* 10 );
    }

    public String toString(){
        return String.valueOf((char) (column + 65)) +
                (row + 1);
    }

    public int getArrayIndex(){
        return (row * 10) + column;
    }
}
