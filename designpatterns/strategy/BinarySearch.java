package strategy;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Uses the binary search method to check if a string already exists within an ArrayList.
 * @author Ana Boccanfuso
 */
public class BinarySearch implements SearchBehavior
{
    /**
     * Checks if a string (name) is contained within the ArrayList (guest list) by using the binary search technique. 
     * @param data The ArrayList of strings containing the names of people coming to Thanksgiving. 
     * @param item The string that represents the name of a person. 
     * @return Returns true if the string (name) is contained within the ArrayList (guest list); returns false if the string (name) is not contained within the ArrayList (guest list).
     */
    public boolean contains(ArrayList<String> data, String item)
	{
		Collections.sort(data);
        int low = 0;
        int high = data.size() - 1;
        
        while(low <= high)
        {
            int middle = low + (high - low) / 2;
            int value = data.get(middle).compareToIgnoreCase(item);
            if(value == 0)
                return true;
            else if(value < 0)
                low = middle + 1;
            else 
                high = middle - 1;
        }
        return false;
	}
}
// Referenced https://stackoverflow.com/questions/16252269/how-to-sort-an-arraylist for sorting
// and https://www.geeksforgeeks.org/java-program-to-perform-binary-search-on-arraylist/ 
