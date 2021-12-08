package org.example.game;

import org.example.player.AdvancedRandomAlgorithm;
import org.example.player.AiPlayer;
import org.example.player.RandomAlgorithm;

import java.util.Scanner;

public class SimulatedGame extends AbstractGame {


    public SimulatedGame(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void setup() {
        String namePlayer1 = "Bob";
        String namePlayer2 = "Alice";

        player1 = new AiPlayer(namePlayer2, namePlayer1, new AdvancedRandomAlgorithm());
        player2 = new AiPlayer(namePlayer1, namePlayer2, new RandomAlgorithm());
    }
}
