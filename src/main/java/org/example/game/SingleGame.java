package org.example.game;

import org.example.player.*;

import java.util.Scanner;

public class SingleGame extends AbstractGame{

    public SingleGame(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void setup() {
        String response;
        String namePlayer1;
        String strength;
        do{
            System.out.println( "Please enter your name:" );
            namePlayer1 = scanner.nextLine();
            System.out.println("Your name is " + namePlayer1 + ". " );
            System.out.println("Choose AI strength: easy(e) or hard(h):");
            strength = scanner.nextLine();
            if(strength.equals("e")) {
                System.out.println("AI strength is easy.");
            }else if(strength.equals("h")) {
                System.out.println("AI strength is hard.");
            }else{
                response = "n";
                System.out.println("Sorry, I did't get that.");
                continue;
            }
            System.out.println("Is that correct? (y/n)");
            response = scanner.nextLine();
        }while (response.equals("n"));

        player1 = new HumanPlayer("Alice", namePlayer1, scanner);
        if(strength.equals("h")){
            player2 = new AiPlayer(namePlayer1, "Alice", new RandomAlgorithm());
        }else{
            player2 = new AiPlayer(namePlayer1, "Alice", new RandomAlgorithm());
        }

        System.out.println("Map loaded successfully.");
    }
}
