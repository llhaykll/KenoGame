package View;

import Controller.GameLogic;

/**
 * The {@code Main} class serves as the entry point of the program.
 * It creates an instance of the {@link GameLogic} class and starts the game by calling the {@code play()} method.
 */


public class Main {
    public static void main(String[] args) {


        GameLogic game = new GameLogic();
        game.play();
    }
}