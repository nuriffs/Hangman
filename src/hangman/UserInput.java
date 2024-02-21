package hangman;

import java.util.Scanner;

public class UserInput {
	// to validate the user input
	public static char validateInput(Scanner scanner, StringBuilder lettersGuessed) {
        char guessed;
        
        while (true) {
            System.out.print("Your guess: ");
            String input = scanner.next().toUpperCase();
            guessed = input.charAt(0);

            // to make sure input is one at a time and only letters
            // to check if the input has already been guessed before
            if (input.length() == 1 && GameProcess.isLetter(guessed) && lettersGuessed.indexOf(input) == -1) {
                break;
            } 
            else if (input.length() > 1) {
                System.out.print("Invalid input. Please enter one letter at a time.\n");
            } 
            else if (!GameProcess.isLetter(guessed)) {
                System.out.print("Invalid input. Please enter letters only.\n");
            }
            else {
				System.out.print("You've already guessed that letter. Try again.\n");
			}
        }
        return guessed;
    }
}
