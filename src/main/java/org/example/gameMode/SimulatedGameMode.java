package org.example.gameMode;

import org.example.GameView;
import org.example.gameUtils.Field;
import org.example.player.*;


public class SimulatedGameMode implements GameMode {


    private AiPlayer player1;
    private AiPlayer player2;
    private final GameView view;
    private Field fieldPlayer1;
    private Field fieldPlayer2;

    public SimulatedGameMode(GameView view){ this.view = view; }

    @Override
    public void setup(){

        String namePlayer1 = view.getNamePlayer1();
        String player1Strength = view.getAiStrength();
        AiAlgorithm algoPlayer1;

        if(player1Strength.equals("easy")){
            algoPlayer1 = new RandomAlgorithm();
        }else{
            algoPlayer1 = new AdvancedRandomAlgorithm();
        }

        String namePlayer2 = view.getNamePlayer2();
        String player2Strength = view.getAiStrength();
        AiAlgorithm algoPlayer2;

        if(player2Strength.equals("easy")){
            algoPlayer2 = new RandomAlgorithm();
        }else{
            algoPlayer2 = new AdvancedRandomAlgorithm();
        }

        try{
            fieldPlayer1 = new Field(namePlayer2);
            fieldPlayer2 = new Field(namePlayer1);
        }catch (IllegalArgumentException ex){
            view.showFileErrorMessage(ex.getMessage());
            System.exit(-1);
        }

        player1 = new AiPlayer(fieldPlayer1, namePlayer1, algoPlayer1);
        player2 = new AiPlayer(fieldPlayer2, namePlayer2, algoPlayer2);

        view.printSuccess();
    }


    public void play(){
        String attackMessage;

        while(true){
            // player 1
            turnAiPlayer(player1);
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

    public void announceWinner(AbstractPlayer winner){
        view.printWinner(winner.getName());
    }

    public void turnAiPlayer(AiPlayer player){
        String attackMessage;
        view.printTurn(player.getName());
        view.printMessage(player.getFieldString());
        attackMessage = player.attack();
        view.printMessage(attackMessage);
    }
}
