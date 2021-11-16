package iterator;
import java.util.Iterator;

/**
 * A class that iterates through the flight array of flights
 * and checks to see if the array has a next flight or not. 
 * Also can increment the position to check the next flight.
 * @author Ana Boccanfuso
 */
public class FlightIterator implements Iterator {
    private Flight[] flights;
    private int position = 0;

    /**
     * A method that sets the specific instance of the flight array.
     * @param flights The flight array that is passed in.
     */
    public FlightIterator(Flight[] flights) {
        this.flights = flights;  
    }

    /**
     * A method that checks if there is a flight in the next index of 
     * the array.
     * @return Returns true if the flight array has a flight in the 
     * next index, and returns false if the flight array does not.
     */
    public boolean hasNext() {
        return position < flights.length && flights[position] != null;
    }

    /**
     * A method that gets the next flight in the flight array.
     * @return Returns the flight at the index of position.
     */
    public Flight next() {
        if(!hasNext()) return null;
        Flight flight = flights[position];
        position++;
        return flight;
    }
}
