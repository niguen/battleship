package org.example.gameUtils;


import java.util.HashMap;

import static org.example.fileUtils.FileResourcesUtils.getArrayFromFile;

public class Field {

    private final char[] fieldArray;
    private final HashMap<Character, Integer> shipsConfig = new HashMap<>();


    public Field(String fileName) throws IllegalArgumentException {

        shipsConfig.put('1', 4);
        shipsConfig.put('2', 3);
        shipsConfig.put('3', 3);
        shipsConfig.put('4', 2);
        shipsConfig.put('5', 2);

        fieldArray = getArrayFromFile(fileName);
        try{
            validateField();
        }catch (Exception ex){
            throw new IllegalArgumentException("Error with file " + fileName + ".txt: " + ex.getMessage());
        }

    }



    public ShotResult shootAt(Coordinate coordinate) {

        int index = coordinate.getArrayIndex();
        int numShips = getNumberOfShips();

        char currentField = fieldArray[index];
        if (currentField == '~') {
            fieldArray[index] = 'o';
            return ShotResult.MISS;
        } else if (fieldArray[index] == 'x' || fieldArray[index] == 'o') {
            return ShotResult.MISS;
        } else {
            fieldArray[index] = 'x';
            if(numShips > getNumberOfShips()){
                return ShotResult.SUNK;
            }
            return ShotResult.HIT;
        }
    }

    public int getNumberOfShips(){
        int counter = 0;

        for(int i = 1; i <=5; i++){
            for(char value : fieldArray){
                if(Character.getNumericValue(value) == i){
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("   |");
        for(char columnLetter = 'A'; columnLetter <= 'J'; columnLetter++){
            builder.append(" ").append(columnLetter).append(" ");
        }
        builder.append("\n");
        int lineNumber = 1;
        for(int i = 0; i < (10);i++ ){

            if(lineNumber < 10){
                builder.append(lineNumber).append("  |");
            }else{
                builder.append(lineNumber).append(" |");
            }
            for(int x =0; x < 10; x++ ){

                char outPut = fieldArray[i*10 + x];
                if( outPut != 'x' && outPut != 'o'&& outPut != '~' ){
                    outPut = '~';
                }
                builder.append(" ").append(outPut).append(" ");
            }
            builder.append(" \n");
            lineNumber++;
        }
        return builder.toString();
    }


    private void validateField(){
        if(fieldArray.length != 100){
            throw new IllegalArgumentException("Wrong field length.");
        }
        if(getNumberOfShips() != 5){
            throw new IllegalArgumentException("Wrong number of ships.");
        }

        for (char i : shipsConfig.keySet()){
            validateShipIntegrity(i, shipsConfig.get(i));
        }

    }

    private void validateShipIntegrity(char shipIndex, int shipLength){
        int lengthCounter = 0;


        for (char c : fieldArray) {
            if (c == shipIndex) {
                lengthCounter++;
            }
        }

        //ship index not found
        if(lengthCounter == 0) {
            throw new IllegalArgumentException("Ship index " + shipIndex + " not found");
        }
        //ship has wrong length
        else if(lengthCounter != shipLength){
            throw new IllegalArgumentException("Ship length of " + shipIndex + " not correct");
        }
    }

}
