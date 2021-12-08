package org.example.game;

import org.example.player.*;

import java.util.Scanner;

import static org.example.gameUtils.MathUtil.generateRandomInRange;

public class SingleGame extends AbstractGame{

    public SingleGame(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void setup() {
        String response;
        String namePlayer1;
        String AiName = getAiName();
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
            System.out.println("Ai name is: " + AiName);
            System.out.println("Is that correct? (y/n)");
            response = scanner.nextLine();
        }while (response.equals("n"));



        player1 = new HumanPlayer(AiName, namePlayer1, scanner);

        if(strength.equals("h")){
            player2 = new AiPlayer(namePlayer1, AiName, new AdvancedRandomAlgorithm());
        }else{
            player2 = new AiPlayer(namePlayer1,AiName, new RandomAlgorithm());
        }

        System.out.println("Map loaded successfully.");
    }

    private String getAiName(){
        int num = generateRandomInRange(0,3);
        switch (num){
            case 0:
                return "Alice";
            case 1:
                return "Bob";
            case 2:
                return "Charles";
            default:
                return "Dave";
        }
    }
}
