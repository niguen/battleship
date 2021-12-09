package org.example.gameMode;

import org.example.GameView;
import org.example.gameUtils.Coordinate;
import org.example.gameUtils.Field;
import org.example.player.AbstractPlayer;
import org.example.player.HumanPlayer;

/**
 * Normal game mode with two human player playing against each other
 */
public class MultiGameMode implements GameMode {

    private HumanPlayer player1;
    private HumanPlayer player2;
    private final GameView view;
    private Field fieldPlayer1;
    private Field fieldPlayer2;

    public MultiGameMode(GameView view){
        this.view = view;
    }

    @Override
    public void setup(){

        String namePlayer1 = view.getNamePlayer1();
        String namePlayer2 = view.getNamePlayer2();

        try{
        fieldPlayer1 = new Field(namePlayer2);
        fieldPlayer2 = new Field(namePlayer1);
        }catch (IllegalArgumentException ex){
            view.showFileErrorMessage(ex.getMessage());
            System.exit(-1);
        }

            player1 = new HumanPlayer(fieldPlayer1, namePlayer1);
            player2 = new HumanPlayer(fieldPlayer2, namePlayer2);


        view.printSuccess();
    }

    public void play(){

        while(true){
            // player 1
            turnHumanPlayer(player1);
            if(player1.hasWon()){
                announceWinner(player1);
                return;
            }

            // player 2
            turnHumanPlayer(player2);

            if(player2.hasWon()){
                announceWinner(player2);
                return;
            }

        }
    }


    public void announceWinner(AbstractPlayer winner){
       view.printWinner(winner.getName());
    }


    public Coordinate getCoordinateFromInput() throws IllegalArgumentException {
        String inputString = view.getCoordinateInput();
        return new Coordinate(inputString);
    }

    @Override
    public void turnHumanPlayer(HumanPlayer player) {
        Coordinate coordinate;
        String attackMessage;

        view.printTurn(player.getName());
        view.printMessage(player.getFieldString());
        try{
            coordinate = getCoordinateFromInput();
        }catch (IllegalArgumentException ex){
            view.showInputErrorMessage();
            return;
        }
        attackMessage = player.attack(coordinate);
        view.printMessage(attackMessage);
    }
}
