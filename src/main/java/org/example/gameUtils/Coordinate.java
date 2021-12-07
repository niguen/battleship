package org.example.gameUtils;

public class Coordinate {

    private int row;
    private int column;

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

    public Coordinate(int index){
        row = index % 10;
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
