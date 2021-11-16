package strategy;
import java.util.ArrayList;

/**
 * Used to make a guest list with a title and people. 
 * @author Ana Boccanfuso
 */

public class GuestList {
    private String title;
    private ArrayList<String> people;
    private SearchBehavior searchBehavior;

    /**
     * Creates a new guest list with the indicated title.
     * @param title The title of the guest list. 
     */
    public GuestList(String title)
    {
        this.title = title;
        this.searchBehavior = new LinearSearch();
        this.people = new ArrayList<String>();
    }

    /**
     * Checks if a person is already contained within the guest list, and adds them if they are not. 
     * @param person The name of the person to be added to the guest list. 
     * @return Returns false if the person is already in the guest list; returns true if the person is not already in the guest list, and therefore is added to the list. 
     */
    public boolean add(String person)
    {
    	
        Boolean newbie = searchBehavior.contains(people, person);
        if(newbie == true)
        {
            return false;
        }
        else
        {
            people.add(person);
            return true;
        }
    }

    /**
     * Checks if a person is already contained within the guest list, and removes them if they are.
     * @param people The array list containing the guest list (list of names) for Thanksgiving.
     * @param person The name of the person to be removed from the guest list.
     * @return Returns true if the person is in the guest list and is removed; returns false if the person is not in the guest list. 
     */
    public boolean remove(String person)
    {
        Boolean newbie = searchBehavior.contains(people, person);
        if(newbie == true)
        {
            people.remove(person);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Gets the title of the guest list for Thanksgiving.
     * @return A string representation of the guest list title. 
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * Sets the instance of SearchBehavior to the specific guest list.
     * @param searchBehavior An instance of the interface SearchBehavior.
     */
    public void setSearchBehavior(SearchBehavior searchBehavior)
    {
        this.searchBehavior = searchBehavior;
    }

    /**
     * Retrieves the guest list of people for Thanksgiving.
     * @return A string representation of the guest list. 
     */
    public ArrayList<String> getList()
    {
        return this.people;
    }

}
