package org.example;

import org.example.game.AbstractGame;
import org.example.game.MultiGame;
import org.example.game.SimulatedGame;
import org.example.game.SingleGame;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        AbstractGame game;

        System.out.println( "Welcome to Battleship!" );
        System.out.print("\n");

        label:
        while(true) {
            System.out.println("Please select a game mode single(s), multiplayer(m) or simulated(sim):");
            String input = scanner.nextLine();
            switch (input) {
                case "s":
                    System.out.println("Game mode is: single");
                    game = new SingleGame(scanner);
                    break label;
                case "m":
                    System.out.println("Game mode is: multiplayer");
                    game = new MultiGame(scanner);
                    break label;
                case "sim":
                    System.out.println("Game mode is: simulated");
                    game = new SimulatedGame(scanner);
                    break label;
            }
            System.out.println("Sorry, I did't get that.");
        }

        game.setup();
        game.play();

        scanner.close();
    }
}
