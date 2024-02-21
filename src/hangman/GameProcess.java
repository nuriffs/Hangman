package hangman;

public class GameProcess {
	
	// to declare the variables
	private int guessesLeft;
    private String dashedWord;
    private StringBuilder wordToGuess;
    private StringBuilder lettersGuessed;

    private static final int MAXGUESSES = 8;

    public GameProcess() {
        setUp();
    }
    
    // to initialise the game
    private void setUp() {
        dashedWord = WordSelector.getRandWord().toUpperCase();
        lettersGuessed = new StringBuilder();
        wordToGuess = new StringBuilder();

        for (int i = 0; i < dashedWord.length(); i++) {
            wordToGuess.append("-");
        }

        guessesLeft = MAXGUESSES;
    }
    
    // to display the messages for the game 
    public void displayState() {
        System.out.println("The word now looks like this: " + wordToGuess);
        System.out.println("Letters you have guessed: " + lettersGuessed);

        if (guessesLeft == 1) {
            System.out.println("You have only one guess left.");
        } 
        else {
            System.out.println("You have " + guessesLeft + " guesses left.");
        }
    }

    // to process the player's guess
    public void updateGameState(char guess) {
        lettersGuessed.append(guess).append(" ");
        boolean chrGuessed = false;

        for (int i = 0; i < dashedWord.length(); i++) {
            if (dashedWord.charAt(i) == guess) {
                wordToGuess.setCharAt(i, guess);
                chrGuessed = true;
            }
        }
        
        // if wrong guess - decrease num of tries
        if (!chrGuessed) {
            guessesLeft--;
        }
    }

    // to display the result of the game
    public void displayResult() {
        if (wordToGuess.indexOf("-") == -1) {
            System.out.println("That guess is correct.");
            System.out.println("You guessed the word! " + wordToGuess);
            System.out.println("You win.");
        } 
        else {
            System.out.println("You're completely hung.");
            System.out.println("The word was: " + dashedWord);
            System.out.println("You lose.");
        }
    }

    // to check if the game is done
    public boolean isGameOver() {
    	return guessesLeft <= 0 || wordToGuess.indexOf("-") == -1;
    }

    // to get the letter that the player has guessed
    public StringBuilder getLettersGuessed() {
        return lettersGuessed;
    }

    // to check if the guess is a valid letter/input
    public static boolean isLetter(char guess) {
        return (guess >= 'A' && guess <= 'Z');
    }
}
