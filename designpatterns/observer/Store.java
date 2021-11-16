package observer;
import java.util.LinkedList;
import java.util.Queue;

/** A class that implements the interface observer, making the best sellers list, updating it, and printing it out to the user.
 * @author Ana Boccanfuso
 */
public class Store implements Observer {
    private Subject subject;
    private String title;
    private Queue<Book> bestSellers;
    
    /**
     * A method to define the best sellers list as a linked list, and to register this class as an observer. 
     * @param subject An instance of the interface Subject to modify observers.
     */
    public Store(Subject subject) {
        this.subject = subject;  
        this.bestSellers = new LinkedList<Book>();
        subject.registerObserver(this);    
    }

    /**
     * A method to update the best sellers list by adding a new book to the linked list and deleting the oldest one if there are more than five books.
     * @param book The book that is added to the best sellers list. 
     */
    public void update(Book book) {
        this.bestSellers.add(book);
        if(this.bestSellers.size()>5) 
            this.bestSellers.remove();
    }

    /**
     * A method to print out the top 5 best sellers.
     */
    public void display() {
        System.out.println("Top 5 Best Sellers:");
        for(Book book: bestSellers) {
            System.out.println(book);
        }
    }
}
