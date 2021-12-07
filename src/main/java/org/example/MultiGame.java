package org.example;

import org.example.player.HumanPlayer;

import java.util.Scanner;

public class MultiGame extends AbstractGame {



    public MultiGame(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void setup(){
        String response;
        String namePlayer1;
        String namePlayer2;

        do{
            System.out.println( "Player 1: Please enter your name:" );
            namePlayer1 = scanner.nextLine();
            System.out.println( "Player 1: Your name is " + namePlayer1 + ". " );
            System.out.println("Player 2: Please enter your name:" );
            namePlayer2 = scanner.nextLine();
            System.out.println( "Player 2: Your name is " + namePlayer2 + ". " );
            System.out.println("Is that correct? (y/n)");
            response = scanner.nextLine();
        }while (response.equals("n"));

        player1 = new HumanPlayer(namePlayer2, namePlayer1, scanner);
        player2 = new HumanPlayer(namePlayer1, namePlayer2, scanner);

        System.out.println("Map loaded successfully.");
    }
}
