package org.example.gameMode;

import org.example.player.AbstractPlayer;
import org.example.player.AiPlayer;
import org.example.player.HumanPlayer;

public interface GameMode {

    void setup();

    void play();

    void announceWinner(AbstractPlayer winner);

    default void turnHumanPlayer(HumanPlayer player){}

    default void turnAiPlayer(AiPlayer player){}

}
