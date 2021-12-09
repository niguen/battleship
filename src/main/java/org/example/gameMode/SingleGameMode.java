package org.example.gameMode;

import org.example.GameView;
import org.example.gameUtils.Coordinate;
import org.example.gameUtils.Field;
import org.example.player.*;

import static org.example.gameUtils.MathUtil.generateRandomInRange;

/**
 * A single player mode with one human player and one Ai player
 */
public class SingleGameMode implements GameMode {


    private HumanPlayer player1;
    private AiPlayer player2;
    private final GameView view;
    private Field fieldPlayer1;
    private Field fieldPlayer2;

    public SingleGameMode(GameView view){ this.view = view; }

    @Override
    public void setup(){

        String namePlayer1 = view.getNamePlayer1();
        String namePlayer2 = getAiName();
        String strength = view.getAiStrength();
        AiAlgorithm algo;


        if(strength.equals("easy")){
            algo = new RandomAlgorithm();
        }else{
            algo = new AdvancedRandomAlgorithm();
        }

        try{
            fieldPlayer1 = new Field(namePlayer2);
            fieldPlayer2 = new Field(namePlayer1);
        }catch (IllegalArgumentException ex){
            view.showFileErrorMessage(ex.getMessage());
            System.exit(-1);
        }

        player1 = new HumanPlayer(fieldPlayer1, namePlayer1);
        player2 = new AiPlayer(fieldPlayer2, namePlayer2, algo);

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
           turnAiPlayer(player2);
            if(player2.hasWon()){
                announceWinner(player2);
                return;
            }


        }
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

    public void turnAiPlayer(AiPlayer player){
        String attackMessage;
        view.printTurn(player.getName());
        view.printMessage(player.getFieldString());
        attackMessage = player.attack();
        view.printMessage(attackMessage);
    }
}
