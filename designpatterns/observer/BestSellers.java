package observer;
import java.util.ArrayList;

/** Used to maintain the list of observers and the list of best sellers, and to notify observers of changes. 
 * @author Ana Boccanfuso
 */
public class BestSellers implements Subject {
    private ArrayList<Observer> observers;
    private ArrayList<Book> bestSellers;

    /**
     * A method to create array lists for both observers and best sellers. 
     */
    public BestSellers() {
        this.observers = new ArrayList<Observer>();
        this.bestSellers = new ArrayList<Book>();        
    }

    /**
     * A method to add a new observer to the array list of observers. 
     * @param observer The observer that is added to the observers array list. 
     */
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    /**
     * A method to remove an observer from the array list of observers. 
     * @param observer The observer that is removed from the observers array list. 
     */
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    /**
     * A method to notify observers on the array list of observers when changes are made to the book lists.
     * @param book The book that has been added, and therefore that the observers are notified of. 
     */
    public void notifyObservers(Book book) {
        for(Observer observer: this.observers) {
            observer.update(book);
        }
    }

    /**
     * A method to add a book to the best sellers list, and therefore to call the notifyObservers method to notify them of the addition. 
     * @param book The book that is added to the best sellers list. 
     */
    public void addBook(Book book) {
        this.bestSellers.add(book);
        notifyObservers(book);
    }
}
