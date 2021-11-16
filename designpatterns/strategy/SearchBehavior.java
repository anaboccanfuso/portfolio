package strategy;
import java.util.ArrayList;

/**
 * Used to implement a contains method.
 * @author Ana Boccanfuso
 */

public interface SearchBehavior {

	/**
	 * An abstract method to check if a string is contained within an ArrayList.
	 * @param data The ArrayList of people coming to Thanksgiving (the guest list).
	 * @param item The name that is searched for in the ArrayList. 
	 * @return Returns true if the string (name) is contained within the ArrayList (guest list); returns false if the string (name) is not contained within the ArrayList (guest list). 
	 */
	public boolean contains(ArrayList<String> data, String item);
}