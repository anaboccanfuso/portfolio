package observer;

/**
 * An interface for observer classes to add books and update.
 * @author Ana Boccanfuso
 */
public interface Observer {

    /**
     * An abstract method to update observers' book lists.
     * @param book A book that is added to the list.
     */
    public void update(Book book);

    /**
     * An abstract method to display the list of books by printing them to the user. 
     */
    public void display();
}