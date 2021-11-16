package observer;
import java.util.ArrayList;

/**
 * A class to define the properties of a customer and make a wish list for books to be added to, as well as print out the wish list. 
 * @author Ana Boccanfuso
 */
public class Customer implements Observer{
    private Subject subject;
    private String firstName;
    private String lastName;
    private ArrayList<Book> wishList;

    /**
     * A method to create specific instances of the properties, and a new array list for the wish list. This method also registers itself as an observer
     * @param subject An instance of the interface Subject to modify observers.
     * @param firstName The first name of the customer whose wish list it is.
     * @param lastName The last name of the customer whose wish list it is.
     */
    public Customer(Subject subject, String firstName, String lastName) {
        this.subject = subject;
        this.firstName = firstName;
        this.lastName = lastName;
        this.wishList = new ArrayList<Book>();
        subject.registerObserver(this);
    }

    /**
     * A method to update the wish list by adding a book.
     * @param book The book that is added to the wish list. 
     */
    public void update(Book book) {
        this.wishList.add(book);
    }

    /**
     * A method to print out the wish list.
     */
    public void display() {
        System.out.println("\nWish List:");
        for(Book book: wishList) {
            System.out.println(book);
        }
    }
}
