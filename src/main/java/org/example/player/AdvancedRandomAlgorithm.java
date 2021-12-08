package org.example.player;

import org.example.gameUtils.Coordinate;

import java.util.Arrays;
import java.util.LinkedList;


import static org.example.gameUtils.MathUtil.generateRandomInRange;

public class AdvancedRandomAlgorithm implements AiAlgorithm{

    char[] field;
    public final LinkedList<Integer> potentialTargets;
    private int currentIndex;

    public AdvancedRandomAlgorithm(){
        field = new char[100];
        Arrays.fill(field, 'o');
        potentialTargets = new LinkedList<>();

    }

    public Coordinate getCoordinate() {

        Coordinate target;
        while(!potentialTargets.isEmpty()) {
            currentIndex = potentialTargets.pop();
            if(field[currentIndex] == 'o') {
                target = new Coordinate(currentIndex);
                System.out.println(target);
                return target;
            }
        }

        while(true){
            currentIndex = generateRandomInRange(0, 99);
            if(field[currentIndex] == 'o'){
                field[currentIndex] = 'x';
                target = new Coordinate(currentIndex);
                System.out.println(target);
                return target;
            }
        }

    }

    @Override
    public void hitNotifier() {

            if(currentIndex > 9){
                potentialTargets.add(currentIndex -10);
            }

            if(currentIndex < 90){
                potentialTargets.add(currentIndex +10);
            }

            if(currentIndex % 9 != 0){
                potentialTargets.add(currentIndex -1);
            }

            if(currentIndex % 10 != 0){
                potentialTargets.add(currentIndex +1);
            }
    }


}
