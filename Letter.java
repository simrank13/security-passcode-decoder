/**
 * This class represents a single letter that will be used in the game. Each game letter also has an accompanying integer label which indicates whether it is used, unused or correct with respect to the mystery word
 * @author skullar5
 *
 */
public class Letter {
	/**
	 * letters in the word
	 */
	private char letter;
	/**
	 * label of the letter (determines if UNUSED letter, USED letter, CORRECT letter, or UNSET letter)
	 */
	private int label;
	/**
	 * UNSET label for if letter is onset with unique value 1
	 */
	private static final int UNSET = 1;
	/**
	 * UNUSED label for if letter is UNUSED with unique value 2
	 */
	private static final int UNUSED = 2;
	/**
	 * USED label for if letter is USED with unique value 3
	 */
	private static final int USED = 3;
	/**
	 * CORRECT label for if letter is CORRECT with unique value 4
	 */
	private static final int CORRECT = 4;

	
	/**
	 * Constructor that initializes label to UNSET and sets the value of instance variable letter to c
	 * @param c 
	 */
	public Letter(char c) {
		// initialize letter instance variable to c
		this.letter = c;
		// initialize label to UNSET
		this.label = UNSET;
	}
	
	/**
	 * equals() method that checks if the otherObject is of the class Letter and if so it compares the "letter" attributes of this object and otherObject else method returns false
	 */
	public boolean equals(Object otherObject) {
		// if otherObject is instance of class Letter and if the letter attribute of this object and the other object then return true
		if(otherObject instanceof Letter) {
			if(this.letter == ((Letter)otherObject).letter) {
				return true;
			}
		}
		else {
			// else if the letter attribute of this object isnt the same as otherObject then return false
			return false;
		}
		// else if otherObject isnt an instance of class Letter then return false
		return false;
		
	}
	/**
	 * 
	 * @return "+" if label attribute set to USED, "-" if label attribute set to UNUSED, "!" if label attribute set to CORRECT, " " if label attribute is UNSET
	 */
	public String decorator() {
		// if label attribute set to USED return "+"
		if(this.label == USED) {
			return "+";
		}
		// if label attribute set to UNUSED return "-"
		else if(this.label == UNUSED) {
			return "-";
		}
		// if label attribute set to CORRECT return "!"
		else if(this.label == CORRECT) {
			return "!";
		}
		//if label attribute set to UNSET return " "
		else if(this.label == UNSET) {
			return " ";
		}
		// if label isnt set to anything then return " "
		return " ";
	}
	
	/**
	 * toString() method gives a representation of letter and label which uses helper method decorator which returs in the form dCd where C is the letter attribute of this object and d is the String returned by decorator() method
	 */
	public String toString() {
		// return the label returned in decorator() method and the letter attribute and then the label returned in decorator() method, String will be returned in dCd format where d is label returned in decorator() method and C is the letter attribute
		return decorator() + this.letter + decorator();
	}
	/**
	 * Mutator/ setter method which updates label attribute to UNUSED
	 */
	public void setUnused() {
		this.label = UNUSED;
	}
	/**
	 * Mutator/ setter method which updates label attribute to USED
	 */
	public void setUsed() {
		this.label = USED;
	}
	/**
	 * Mutator/ setter method which updates label attribute to CORRECT
	 */
	public void setCorrect() {
		this.label = CORRECT;
	}
	
	/**
	 * isUnused() method returns true if the label attribute is set to UNUSED (meaning it is unused letter) else false
	 * @return true if label attribute is set to UNUSED else return false
	 */
	public boolean isUnused() {
		// if label attribute set to UNUSED return true
		if(this.label == UNUSED) {
			return true;
		// else false
		} else {
			return false;
		}
	}
	/**
	 * fromString(s) method produces array of objects of class Letter from given string s and for each character in s, a letter object is created ans stored in array and is stored in same order as characters in s
	 * @param s 
	 * @return letter objects that are stored in array in order of corresponding characters in s
	 */
	public static Letter[] fromString(String s) {
		// Create array of object of class Letter from given s with a size of number of letters in s
		Letter[] letterObj = new Letter[s.length()]; 
		// iterate through each character in s and then create letter object in same order of the characters in s
		for(int character = 0; character < s.length(); character++) {
			letterObj[character] = new Letter(s.charAt(character));
		}
		// then return the letter objects
		return letterObj;
	}
	
	
	

}
