/**
 * This class is a central repository for information about a WordLL game: It stores a mystery word and all word guesses. Keeps history of past word guesses in linked structure
 * @author skullar5
 * 
 * The most hardest method in this WordLL class I found was the tryWord, I was able to update label of all letters contained in Word guess by using the labelWord method and 
 * create a new node and get it to store the Word guess object then set current nodes next as history then update history to current node but then I struggled to figure out 
 * how would I identify if the Word guess is identical to the mystery Word first I decided to use the decorator() method and see if it equals ! and if so return true otherwise
 * return false, however i realized this will not work as WordLL class does not inherit Letter class so we cannot use decorator() helper method. Then I realized I have identified
 * if guess word entered by user is identical to mystery word in labelWord() method in Word class so then I checked if when invoking labelWord() method to check if Word guess is
 * identical to mysteryWord and if this method returns true, then return true otherwise if the labelWord() method returns false then return false. Then in the toString() method
 * I created a node and initialize it to the history of guesses then created a empty string called wordStr then until the current node has not reached the last letter of the guess 
 * word, I used string concatenation to print out the element of the current node and print new word on different line. And it gets the next node of the current node until it hasn't 
 * reached the end of word. These were the 2 methods that I felt were most challenging among all in this WordLL class. To test if my solution works, I created a main method, then I 
 * created a WordLL mysteryWord object which was ORDER and then made 3 guesses by calling 3 different Word objects with different words guessed: SHORE, REJECT, BEAR then I invoked 
 * the tryWord method in respect to the guessWord (so I invoked this 3 times for the 3 different guesses) then I invoked the toString() method to print out the wordLL object holding 
 * the mystery word and then when I ran this i noticed it correctly denotes the guess words with the accurate labels’ decorator according to my guesses and the mystery Word and this 
 * way I knew my code works correctly. The output of my code was: 
 * Word: -B-  +E+  -A-  +R+
 * Word: +R+ +E+ -J- !E! -C- -T-
 * Word: -S- -H- +O+ +R+ +E+
 * Which as we can see is correct according to mysteryWord which is ORDER (the ! denotes the letter is in right position + denotes letter is used in mystery word and - denotes word isnt used at all in mystery word)

 */
public class WordLL {
	/**
	 * mystery word that needs to guessed
	 */
	private Word mysteryWord;
	/**
	 * history fo all words guessed
	 */
	LinearNode<Word> history;
	
	/**
	 * Constructor that intializes empty history and sets the mysteryWord attribute to parameter mystery
	 * @param mystery
	 */
	public WordLL(Word mystery) {
		// sets mysteryWord attribute to parameter mystery and initializes empty history
		this.mysteryWord = mystery;
		this.history = null;
	}
	
	/**
	 * tryWord() method takes Word as argument to test against this games' mystery word
	 * @param guess
	 * @return true if guess word is identical ro mysteryWord else return false
	 */
	public boolean tryWord(Word guess) {
		// updates label of all letters contained in Word guess but invoking the labelWord method
		guess.labelWord(mysteryWord);
		
		// Create a node of class LinearNode and store Word guess object as its value
		LinearNode<Word> currNode = new LinearNode<Word>(guess);
		// Set currNode's next pointer to point to history and update history with value of current node so that current Word guess is added to front of history each time a guess is made 
		currNode.setNext(history);
		history = currNode;
		
		// invoke the labelWord method in respect to mysteryWord and if it returns true then return true else return false
		if(guess.labelWord(mysteryWord)) {
			return true;
		}
		return false;
		
	}
	
	/**
	 * toString() method creates String representation of past guesses with most recent guess first 
	 */
	public String toString() {
		// create a node and initialize it to history of guesses 
		LinearNode<Word> currNode = history;
		
		// create wordStr String and initialize it to empty space
		String wordStr = "";
		
		// while current node isnt null (until hasnt gone through all of the letters of the guess word) then use string concatenation to print the current node's element and print new word on new line
		while(currNode != null) {
			wordStr += currNode.getElement() + "\n";
			// get the next letter of guess word
			currNode = currNode.getNext();
		}
		// return String wordStr
		return wordStr;
	}
	
	public static void main(String[] args) {
		Word mysteryWord = new Word(Letter.fromString("ORDER"));
		WordLL wordLL = new WordLL(mysteryWord);
		
		Word guess1 = new Word(Letter.fromString("SHORE"));
        Word guess2 = new Word(Letter.fromString("REJECT"));
        Word guess3 = new Word(Letter.fromString("BEAR"));
        
        wordLL.tryWord(guess1);
        wordLL.tryWord(guess2);
        wordLL.tryWord(guess3);
        
        System.out.println(wordLL.toString());
	}

}
