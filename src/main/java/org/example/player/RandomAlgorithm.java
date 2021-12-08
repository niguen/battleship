package org.example.player;

import org.example.gameUtils.Coordinate;

import java.util.Arrays;

import static org.example.gameUtils.MathUtil.generateRandomInRange;

public class RandomAlgorithm implements AiAlgorithm{

    char[] field;

    public RandomAlgorithm(){
        field = new char[100];
        Arrays.fill(field, 'o');
    }

    public Coordinate getCoordinate() {

        int index;
        while(true){
            index = generateRandomInRange(0, 99);
            if(field[index] == 'o'){
                field[index] = 'x';
                Coordinate target = new Coordinate(index);
                System.out.println(target);
                return target;
            }
        }

    }

}
