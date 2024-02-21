package hangman;

import java.util.Random;

public class WordSelector {
	private static final String[] WORDLIST = {"HAPPY", "SAD", "ANGRY", "STRESS", "NERVOUS", "EXCITEMENT", "SHAME", "FEAR", "RELIEF", "GLOOMY"};
	
	// to get a word from the list
    public static String getRandWord() {
    	Random randWord = new Random();
    	int index = randWord.nextInt(WORDLIST.length);
    	return WORDLIST[index];
    }
}