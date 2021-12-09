package org.example;


import java.util.Scanner;

/**
 * A simple View-class that handles the input and output for the game.
 */
public class GameView {

    private final Scanner scanner;

    public GameView(){
        scanner = new Scanner(System.in);
    }

    public String getMode(){

        String modeString;

        System.out.println( "Welcome to Battleship!" );
        System.out.print("\n");

        label:
        while(true) {
            System.out.println("Please select a game mode single(s), multiplayer(m) or simulated(sim):");
            String input = scanner.nextLine();
            switch (input) {
                case "s":
                    System.out.println("Game mode is: single");
                    modeString = "single";
                    break label;
                case "m":
                    System.out.println("Game mode is: multiplayer");
                    modeString = "multi";
                    break label;
                case "sim":
                    System.out.println("Game mode is: simulated");
                    modeString = "simulated";
                    break label;
            }
            System.out.println("Sorry, I didn't get that.");
        }
        return modeString;
    }

    public String getCoordinateInput(){
        String input;

        System.out.println( "Please enter Coordinate:" );
        input = scanner.nextLine();
        return input;
    }

    public String getNamePlayer1(){
        String response;
        String namePlayer1;

        do{
            System.out.println( "Player 1: Please enter your name:" );
            namePlayer1 = scanner.nextLine();
            System.out.println( "Player 1: Your name is " + namePlayer1 + ". " );

            System.out.println("Is that correct? (y/n)");
            response = scanner.nextLine();
        }while (response.equals("n"));
        return namePlayer1;
    }

    public String getNamePlayer2(){
        String response;
        String namePlayer2;

        do{
            System.out.println( "Player 2: Please enter your name:" );
            namePlayer2 = scanner.nextLine();
            System.out.println( "Player 2: Your name is " + namePlayer2 + ". " );

            System.out.println("Is that correct? (y/n)");
            response = scanner.nextLine();
        }while (response.equals("n"));
        return namePlayer2;
    }

    public String getAiStrength(){

        String response;
        String strength;
        do{
            System.out.println("Choose AI strength: easy(e) or hard(h):");
            strength = scanner.nextLine();
            if(strength.equals("e")) {
                System.out.println("AI strength is easy.");
                strength = "easy";
            }else if(strength.equals("h")) {
                System.out.println("AI strength is hard.");
                strength = "hard";
            }else{
                response = "n";
                System.out.println("Sorry, I didn't get that.");
                continue;
            }
            System.out.println("Is that correct? (y/n)");
            response = scanner.nextLine();
        }while (response.equals("n"));

        return strength;
    }

    public void printSuccess(){
        System.out.println("Map loaded successfully.");
        System.out.println("Ships are ready!!!");
        printLine();

    }

    public void printLine(){
        System.out.println("--------------------------------------------------");
    }

    public void printTurn(String name){
        printLine();
        System.out.println("Your turn " + name + ":");
    }

    public void printWinner(String name){
        System.out.println("Congratulations " + name + ", you won!!!");
    }

    public void printMessage(String message){ System.out.println(message); }

    public void showInputErrorMessage(){
        System.err.println("Wrong Coordinate format!");
    }

    public void showFileErrorMessage(String message){
        System.err.println("There was a problem loading the field. Message: " + message);
    }


}
