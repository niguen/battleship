package org.example.game;

import org.example.player.AbstractPlayer;

import java.util.Scanner;

public abstract class AbstractGame {

    int dimension = 10;
    Scanner scanner;
    AbstractPlayer player1;
    AbstractPlayer player2;

    public AbstractGame(Scanner scanner) {
        this.scanner = scanner;
    }

    abstract public void setup();



    public void play(){
        String player1Result;
        String player2Result;

        while(true){
            System.out.println("------------------------------------------\n");
            player1Result = player1.attack();
            if(player1.hasWon()){
                announceWinner(player1);
                return;
            }
            System.out.println(player1Result);

            System.out.println("------------------------------------------\n");
            player2Result = player2.attack();
            if(player2.hasWon()){
                announceWinner(player2);
                return;
            }
            System.out.println(player2Result);
        }
    }

    private void announceWinner(AbstractPlayer winner){
        System.out.println("Congratulations " + winner.getName() + ", you won!!!");
    }

}
