package org.example;

import org.example.gameMode.GameMode;
import org.example.gameMode.MultiGameMode;
import org.example.gameMode.SimulatedGameMode;
import org.example.gameMode.SingleGameMode;

public class GameController {

    private final GameView view;
    private GameMode mode;

    public GameController(){
        view = new GameView();
    }

    void getMode(){
        String modeSting = view.getMode();
        switch (modeSting){
            case "single":
                mode = new SingleGameMode(view);
                break;
            case "multi":
                mode = new MultiGameMode(view);
                break;
            case "simulated":
                mode = new SimulatedGameMode(view);
        }
    }
    void setupMode(){
        mode.setup();
    }

    void play(){
        mode.play();
    }



}
