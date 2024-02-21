package hangman;

import java.util.Scanner;

public class Hangman {

	private GameProcess gameProcess;

    public Hangman() {
        gameProcess = new GameProcess();
    }

    // the main game loop
    public void playGame() {
        System.out.println("Welcome to Hangman!");
        Scanner scanner = new Scanner(System.in);

        while (!gameProcess.isGameOver()) {
        	gameProcess.displayState();
            char guess = UserInput.validateInput(scanner, gameProcess.getLettersGuessed());
            gameProcess.updateGameState(guess);
        }

        gameProcess.displayResult();
        scanner.close();
    }

    // main method
    public static void main(String[] args) {
    	Hangman game = new Hangman();
        game.playGame();
    }
}
