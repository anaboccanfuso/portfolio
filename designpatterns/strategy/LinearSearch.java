package strategy;
import java.util.ArrayList;

/**
 * Checks if a string is contained within an ArrayList.
 * @author Ana Boccanfuso
 */

public class LinearSearch implements SearchBehavior 
{
    /**
     * Checks if a string (name) is contained within the ArrayList (guest list) by looping through each element. 
     * @param data The ArrayList of strings containing the names of people coming to Thanksgiving. 
     * @param item The string that represents the name of a person. 
     * @return Returns true if the string (name) is contained within the ArrayList (guest list); returns false if the string (name) is not contained within the ArrayList (guest list).
     */
	public boolean contains(ArrayList<String> data, String item)
	{
		for(int i=0;i<data.size();i++)
        {
            if((item.toLowerCase()).contains(data.get(i).toLowerCase()))
                return true;
        }
        return false;
	}
}