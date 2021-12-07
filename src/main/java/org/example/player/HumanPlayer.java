package org.example.player;

import org.example.gameUtils.Coordinate;

import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {


    private Scanner scanner;


    public HumanPlayer(String opponent, String name, Scanner scanner) {
        super(opponent, name);
        this.scanner = scanner;
    }

    @Override
    protected Coordinate getCoordinate() {
        Coordinate coordinate;
        String input;

        System.out.println( "Please enter Coordinate:" );
        input = scanner.nextLine();
        try{
            coordinate = new Coordinate( input );
        } catch(IllegalArgumentException ex){
            System.err.println("Wrong Coordinate format");
            return null;
        }
        return coordinate;
    }


}
