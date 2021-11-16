package iterator;

/**
 * A class to set attributes of an airline, as well as methods to add flights
 * and create a flight iterator. 
 * @author Ana Boccanfuso
 */
public class Airline {
    private String title;
    private Flight[] flights;
    private int size;

    /**
     * A public method to construct a specific version of the airline title, 
     * initialize a new flight array of size 2 to contain the flights, and setting
     * the amount of flights in the array to 0. 
     * @param title The name of the airline.
     */
    public Airline(String title) {
        this.title = title;
        flights = new Flight[2];
        this.size = 0;
    }

    /**
     * A method to add flights to the flight array.
     * @param flightNum The number of the flight being added.
     * @param from The place where the flight being added is coming from.
     * @param to The place where the flight being added is going to.
     * @param duration The length of the flight being added in minutes.
     * @param transfers The amount of transfers the flight being added has.
     */
    public void addFlight(String flightNum, String from, String to, int duration, int transfers) {
        Flight newFlight = new Flight(flightNum, from, to, duration, transfers);
        if(size < flights.length) {
            flights[size] = newFlight;
        }
        else {
            flights = growArray(flights);
            flights[size] = newFlight;
        }
        size++;
    }

    /**
     * A method that returns the specific title of the airline.
     * @return The string representation of the title of the airline.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * A method to grow the flight array by creating a new flight
     * array that is double in size with the same data.
     * @param flights The flight array that is being doubled.
     * @return A bigger flight array that is double in size with 
     * the data from the original array.
     */
    private Flight[] growArray(Flight[] flights) {
        Flight[] bigFlights = new Flight[size*2];
        for(int i = 0; i < flights.length; i++) {
            bigFlights[i] = flights[i];
        }
        return bigFlights;
    }

    /**
     * A method to create a new flight iterator by using
     * the parameter of the flight array.
     * @return Returns the flight iterator of flights.
     */
    public FlightIterator createIterator() {
        return new FlightIterator(flights);
    } 

}