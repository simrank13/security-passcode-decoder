/**
 * This class represents a word in the game that is comprised of any number of letters. Each letter is represented by a letter object. The letter objects stored in linked lists formed by LinearNode object and each node in the linked list sores Letter object 
 * and labels Letter objects with respect to mystery word
 * @author skullar5
 *
 */
public class Word {
	/**
	 * reference to the first node of the linked list representing word corresponding to this object 
	 */
	private LinearNode<Letter> firstLetter;
	
	/**
	 * Constructor that intializes the Word object so Letter object in array "letters" is stored within its linked structure and firstLetter points to first node of linked list
	 * @param letters
	 */
	public Word(Letter[] letters) {
		// initializes firstLetter as the first node in the linked list
		firstLetter = new LinearNode<Letter>(letters[0]);
		
		// Initialize current node of linked list as first Letter
		LinearNode<Letter> currNode = firstLetter;
		// since firstLetters is at letter[0], the nodes should iterate through starting index 1 to index letters.length - 1
		int letterObj = 1;
		
		// while the letterObj is less than the letters.length meaning as long as letters.length is 1 to letters.length - 1
		while(letterObj < letters.length) {
			
			// create a new node and store it with the letters at index letterObj then set the current node to point to this new node and 
			//then get the next node and increment the letterObj variable so it iterates through till it has reaches index letters.length - 1
			LinearNode<Letter> newNode = new LinearNode<Letter>(letters[letterObj]);
			currNode.setNext(newNode);
			currNode = currNode.getNext();
			letterObj++;
			
		}
	}
	
	/**
	 * toString() method creates String in form, Word: L1 L2 L3..... Lk where Li is String produced by invoking toString method on each Letter object of this Word 
	 */
	public String toString() {
		// initialize String wordStr to print "Word: " to the screen
		String wordStr = "Word: ";
		
		// create a node representing the current node and initialize it to have the value of the first letter of the word
		LinearNode<Letter> currNode = firstLetter;
		
		// while the current node isnt null (hasnt reached the end of the linked list), use string concatenation to print out the element of that node and space then get the next node to print the next element and space until havent reached the end of the linked list
		while(currNode != null) {
			wordStr += currNode.getElement() + " ";
			currNode = currNode.getNext();
		}
		// then return the string wordStr
		return wordStr;
		
	}
	
	/**
	 * checkCorrect() helper method determines if the current nodes' letter is the same as the mystery words' letter
	 * @param curr
	 * @param mysteryNode
	 * @return true if current nodes letter is the same as the mystery's letter else false
	 */
	private boolean checkCorrect(LinearNode<Letter> curr, LinearNode<Letter> mysteryNode) {
		// if the current nodes element is the same as the mystery nodes element then set the current nodes's element's label as CORRECT
		if(curr.getElement().equals(mysteryNode.getElement())) {
			curr.getElement().setCorrect();
			// then return true
			return true;
		}
		// else return false
		return false;
	}
	
	/**
	 * checkUsed() helper method checks if the current nodes element is identical to the mystery nodes element and if so set the label of the current node's element as USED
	 * @param curr
	 * @param mysteryWord
	 * @return true if the current nodes element is identical to the mystery nodes element else return false
	 */
	private boolean checkUsed(LinearNode<Letter> curr, Word mysteryWord) {
		// initialize mysteryNode to value of the firstLetter in mysteryWord
		LinearNode<Letter> mysteryNode = mysteryWord.firstLetter;
		
		
		// while the mystery node isnt null(meaning havent reached the last letter of mystery word) then check if the current node's element is identical to mystery node's element and if so set current node's element's label as USED
		while(mysteryNode != null) {
			if(curr.getElement().equals(mysteryNode.getElement())) {
				curr.getElement().setUsed();
				// then return true
				return true;
			}
			// get the next letter of the mystery word (and iterate through until the mysteryNode's next pointer is null)
			mysteryNode = mysteryNode.getNext();
		}
		// then return false
		return false;
	}
	
	/**
	 * checkUnused() helper method checks if the current node's element has a label of " " (so UNSET) and if so then set the current node's element's label as UNUSED
	 * @param curr
	 * @return true if the current node's element's label is " " else returns false
	 */
	private boolean checkUnused(LinearNode<Letter> curr) {
		// while the current node isnt null (meaning until hasnt reached the last letter of word user has currently wrote) then 
		//if the current node's element has a label of " " (so UNSET) and if so then set the current node's element's label as UNUSED 
		while(curr != null) {
			if(curr.getElement().decorator().equals(" ")) {
				curr.getElement().setUnused();
				// then return true
				return true;
			}
			// get the next letter of the current word user entered (and iterate through until the current node's next pointer is null)
			curr = curr.getNext();
		}
		// else return false
		return false;
	}
	
	/**
	 * checkIdentical() method checks if the current node's element (this word) is identical to mystery node's element (mystery word)
	 * @param mystery
	 * @return true if the this.word and mystery word are identical and if not then return false
	 */
	private boolean checkIdentical(Word mystery) {
		// initialize current node to the this.word's first letter
		// intiialize mystery node to the mystery word's first letter
		LinearNode<Letter> curr = this.firstLetter;
		LinearNode<Letter> mysteryNode = mystery.firstLetter;
		
		// while current node isnt null (meaning hasnt reached the last letter of this.word) then if the current node's element's label isnt CORRECT which is denoted by "!"
		while(curr != null) {
			if(!(curr.getElement().decorator().equals("!"))) {
				// return false
				return false;
			}
			// get the next letter of this.word (by getting the next node of current node)
			// get the next letter of mystery word (by getting the next node of mystery node)
			curr = curr.getNext();
			mysteryNode = mysteryNode.getNext();
		}
		
		// if the mystery node is null(meaning hasnt reached the end of the mystery word)
		if (mysteryNode != null) { 
			// then return false
			return false;			
									
		}
		// else if the current ndoe's element's is CORRECT then return true
		return true;
	}
	
	/**
	 * labelWord() method take mystery word as parameter and updates Letter's label attribute contained in this Word object with respect to mystery word
	 * @param mystery
	 * @return if this word is identical to mystery word return true otherwise return false
	 */
	public boolean labelWord(Word mystery) {
		// initialize current node to the this.word's first letter
		// intiialize mystery node to the mystery word's first letter
		LinearNode<Letter> currNode = this.firstLetter;
		LinearNode<Letter> mysteryCurrNode = mystery.firstLetter;
				
		// while the current node and mystery node isnt null( meaning until hasnt reached the end of the current word user entered and mystery word) 
		//then if current node's element is same as mystery node's element then set label of current node's element as CORRECT
		while(currNode != null && mysteryCurrNode != null) {
			if(checkCorrect(currNode, mysteryCurrNode)) {
				currNode.getElement().setCorrect();				
			
				// otherwise if element of current node and mystery node isnt same then set label of current node's element as UNUSED
			} else {
				if(!checkUsed(currNode, mystery)) {
					currNode.getElement().setUnused();

				}
			}
			// set the UNUSED label of the current node's element as its decorator by invoking Letter's decorator helper method
			currNode.getElement().decorator();
			
			// get the next letter of this.word (by getting the next node of current node)
			// get the next letter of mystery word (by getting the next node of mystery node)
			currNode = currNode.getNext();
			mysteryCurrNode = mysteryCurrNode.getNext();
			
		}
		// while current node isnt null (meaning until hasnt reached the end of the current word user entered) and if current word's letter isnt identical to the mystery word's letter
		// then set that letter's label as UNUSED
		while(currNode != null) {
			if(!checkUsed(currNode, mystery)) {
				currNode.getElement().setUnused();
			}
			// set the UNUSED label of the current node's element as its decorator by invoking Letter's decorator helper method
			currNode.getElement().decorator();
			
			// get the next letter of this.word (by getting the next node of current node)
			currNode = currNode.getNext();
			
		}
		// invoke the checkUnused helper method with respect to the current node and check if the current node's element has a label of UNUSED and if so return true else return false
		checkUnused(currNode);
		
		// invoke the checkIdentical helper method with respect to the mystery word and check if this word is identical to mystery word and if so return true otherwise return false
		return checkIdentical(mystery);

	}
	
	
	

	/*public static void main(String[] args) {
		Letter[] letters = new Letter[4];
		
		letters[0] = new Letter('B');
		letters[1] = new Letter('E');
		letters[2] = new Letter('A');
		letters[3] = new Letter('R');
		
		Word word = new Word(letters);
		
		Word word1 = new Word(Letter.fromString("OBJECTER"));
		Word word2 = new Word(Letter.fromString("OBJE")); 
		word2.labelWord(word1);
		
		System.out.println("Word 1: " + word1);
		System.out.println("Word 2: " + word2); //+O+ -B- -J- !E! +C+ -T-
		
		System.out.println("word2 toString: " + word2.toString());
		
		System.out.println(word2.labelWord(word1));
		
		
		
	}*/
	
	
}
