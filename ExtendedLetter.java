/**
 * This class is subclass of Letter and extends functionality and represents content of Letter object, and for this objects of this class will use String instance variable . Adds more features to broaden notion of letter used in game
 * @author skullar5
 *
 */
public class ExtendedLetter extends Letter {
	/**
	 * Content of Letter object
	 */
	private String content;
	/**
	 * family of letters
	 */
	private int family;
	/**
	 * related instance variable for if letters are related
	 */
	private boolean related;
	/**
	 * SINGLETON instance variable with value of -1
	 */
	private static final int SINGLETON = -1;
	
	/**
	 * Constructor method that initializes instance variables of super class and instance variables of this class
	 * @param s
	 */
	public ExtendedLetter(String s) {
		// invokes Letters instance variables by using super() keyword
		super(' ');
		// set content instance variable to given String s
		this.content = s;
		// set related instance variable to false (since hasnt been determined yet if letters are related or not)
		this.related = false;
		// set family to SINGLETON constant (-1)
		this.family = SINGLETON;
		
	}
	/**
	 * Constructor method that initializes instance variables of super class and instance variables of this class
	 * @param s
	 * @param fam
	 */
	public ExtendedLetter(String s, int fam) {
		// invokes Letters instance variables by using super() keyword
		super(' ');
		// set content instance variable to given String s
		this.content = s;
		// set related instance variable to false (since hasnt been determined yet if letters are related or not)
		this.related = false;
		// set family to given fam variable 
		this.family = fam;
	}
	
	/**
	 * equals() method that checks if other object is instanceOf ExtendLetter and if the content of this object and other object are same or not
	 */
	public boolean equals(Object other) {
		// if other object is instance of extended letter then check if family of this object is same as family as other object then set related as true since it is found that letters are related
		if(other instanceof ExtendedLetter) {
			if(this.family == ((ExtendedLetter)other).family) {
				this.related = true;
			}
			// then check if content of this object and other object is same then return true
			if(this.content.equals(((ExtendedLetter)other).content)) {
				return true;
			}
		}
		// otherwise if toher object isnt instance of extended letter then return false
		return false;
	}
	
	/**
	 * toString() method is overriden method that gives String representation of this ExtendedLetter object
	 */
	public String toString() {
		// if this ExtendedLetter object is unused and instance variable related is set to true then return string .C. where C represents content of this object
		if(this.isUnused() && related) {
			
			return "." + this.content + ".";
		// otherwise if this ExtendedLetter object has label that is not set to UNUSED and/or related instance variable is not set to true 
		//then return the label's sign (or decorator) then content of this.Object then label's decorator in form: !C! , C , -C- , or +C+
		} else {
			return super.decorator() + this.content + super.decorator();
		}
	}
	
	/**
	 * fromString() method that creates array letters of Letter objects of same size as size of array content recieved as parameter and return array letters by method after storing in it
	 * @param content
	 * @param codes
	 * @return
	 */
	public static Letter[] fromStrings(String[] content, int[] codes) {
		// create array letters storing size of content
		Letter[] letters = new Letter[content.length];
		
		// iterate from 0 to content.length - 1 and check if codes is null and if so set the array letters at ith entry to store ExtendedLetter(content[i])
		for(int i = 0; i < content.length; i++) {
			if(codes == null) {
				letters[i] = new ExtendedLetter(content[i]);
			// if codes is not null then set the array letters at ith entry to store ExtendedLetter(content[i], codes[i])
			} else {
				letters[i] = new ExtendedLetter(content[i], codes[i]);
			}
		}
		// then return array letters
		return letters;
		
		
	}
	
	/*public static void main(String[] args) {
		ExtendedLetter letter1 = new ExtendedLetter("C");
		//System.out.println(letter1.toString());
		
		ExtendedLetter el1 = new ExtendedLetter("@"); 
		ExtendedLetter el2 = new ExtendedLetter(":)",1); 
		ExtendedLetter el3 = new ExtendedLetter(":(",1);
		//System.out.println(wll.toString());
		// ********** ExtendedLetter equals
		//test(10,"ExtendedLetter equals", el1.equals(el1) && !el1.equals(el2) && !el3.equals(el2));
//		System.out.println("BEFORE: el1" + el1);
//		el1.setCorrect();
//		System.out.println("AFTER : el1" + el1);
//		
//		System.out.println("BEFORE: el2" + el2);
//		el2.setUnused();
//		System.out.println("BEFORE: el2" + el2);
//		
//		System.out.println("BEFORE: el3" + el3);
		el3.setUnused();
		System.out.println(el3);

		// ********** ExtendedLetter toString
		//test(11,"ExtendedLetter toString", (el1.toString()+el2.toString()+el3.toString()).equals("!@!-:)-.:(."));
		
	}*/
}
