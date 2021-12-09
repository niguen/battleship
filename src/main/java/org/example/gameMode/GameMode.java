package org.example.gameMode;

import org.example.player.AbstractPlayer;
import org.example.player.AiPlayer;
import org.example.player.HumanPlayer;


/**
 * This Interface represents the general structure of a game
 *
 */
public interface GameMode {

    /**
     * Runs the setup and creates the players with their fields.
     * Depending on the mode, there will be different types of players
     */
    void setup();

    /**
     * The main function of every game. Has to be called after the setup-function.
     * Runs until a player has destroyed all enemy ships
     */
    void play();

    /**
     * This method will automalically be called at the end of a game.
     * It will dispplay the name of the winner on the screen.
     * @param winner: The winning player
     */
    void announceWinner(AbstractPlayer winner);

    /**
     * Handles the turn of a human player, by getting the coordinate from the view
     * and parsing it to the player.
     * @param player: Human player
     */
    default void turnHumanPlayer(HumanPlayer player){}

    /**
     * Handles the turn af an Ai player, the Ai player will generate the target coordinate
     * itself, so there is no input needed.
     * @param player: AiPlayer
     */
    default void turnAiPlayer(AiPlayer player){}

}
