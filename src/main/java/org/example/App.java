package org.example;

import org.example.game.AbstractGame;
import org.example.game.MultiGame;
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

        while(true) {
            System.out.println("Please select a game mode single player(s) or multi player (m):");
            String input = scanner.nextLine();
            if (input.equals("s")) {
                System.out.println("Gamemode is: single Player");
                // TODO: Implement singleGame
                game = new SingleGame(scanner);
                break;
            } else if (input.equals("m")) {
                System.out.println("Gamemode is: multi Player");
                game = new MultiGame(scanner);
                break;
            }
            System.out.println("Sorry, I did't get that.");
        }

        game.setup();
        game.play();

        scanner.close();
    }
}
