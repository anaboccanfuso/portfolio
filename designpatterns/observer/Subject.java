package observer;

/**
 * An interface that allows its implementers to register, remove, and notify observers.
 * @author Ana Boccanfuso
 */
public interface Subject {
    /**
     * An abstract method to register an observer to the list.
     * @param observer An observer to be added to the list of observers. 
     */
    public void registerObserver(Observer observer);

    /**
     * An abstract method to remove an observer from the list. 
     * @param observer An obsesrver to be added to the list of observers. 
     */
    public void removeObserver(Observer observer);

    /**
     * An abstract method to notify observers of changes in the best sellers list.
     * @param book A book that the observers are notified of when it is added to the list. 
     */
    public void notifyObservers(Book book);
}
