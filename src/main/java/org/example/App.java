package org.example;

/**
 * Battleship App
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        GameController game = new GameController();
        game.getMode();
        game.setupMode();
        game.play();

    }
}
