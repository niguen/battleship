package org.example.gameUtils;


import static org.example.fileUtils.FileResourcesUtils.getArrayFromFile;

public class Field {

    char[] fieldArray;

    public Field(String fileName){
        char[] field = getArrayFromFile(fileName);
        //validateField(field);
        fieldArray = field;
    }



    public ShotResult shootAt(Coordinate coordinate) {

        int index = coordinate.getArrayIndex();

        char currentField = fieldArray[index];
        if (currentField == '~') {
            fieldArray[index] = 'o';
            return ShotResult.MISS;
        } else if (fieldArray[index] == 'x' || fieldArray[index] == 'o') {
            return ShotResult.MISS;
        } else {
            fieldArray[index] = 'x';
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

    /*
    private void validateField(char[] field){

        if(field.length != 100){
            throw new IllegalArgumentException("Wrong field length.");
        }

        if(getNumberOfShips(field) != 5){
            throw new IllegalArgumentException("Wrong number of ships.");
        }
    }

    private void validateShipIntegrity(char shipIndex, int shipLength, char[] field){

        int lengthCounter = 0;
        int index = -1;

        //getFirstIndex;
        for(int i = 0; i < field.length; i++){

            if(field[i] == shipIndex){
                index = i;
                break;
            }
        }

        //shipIndex not found
        if(index == -1){
            throw new IllegalArgumentException("Shuipindex " + shipIndex + " not found");
        }

        if(field[index + 1] == shipIndex){
            //ship is positioned horizontally
        }else if(field[index + 10] == shipIndex){
            //ship is positioned vertically

        }
    }


*/

}
