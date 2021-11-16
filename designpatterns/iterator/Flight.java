package iterator;

/**
 * A class to set the attributes of a flight, as well
 * as give a string representation of these attributes.
 * @author Ana Boccanfuso
 */
public class Flight {
    private String flightNum;
    private String from;
    private String to;
    private int duration;
    private int transfers;

    /**
     * A constructor method to set the specific instances of 
     * the following attributes:
     * @param flightNum The number of the flight.
     * @param from The location where the flight is coming from.
     * @param to The location where the flight is flying to.
     * @param duration The duration of the flight in minutes.
     * @param transfers The number of transfers the flight has.
     */
    public Flight(String flightNum, String from, String to, int duration, int transfers) {
        this.flightNum = flightNum;
        this.from = from;
        this.to = to;
        this.duration = duration;
        this.transfers = transfers;
    }

    /**
     * A method to get the specific from location.
     * @return Returns the specific from location.
     */
    public String getFrom() {
        return this.from;
    }

    /**
     * A method to get the specific to location.
     * @return Returns the specific to location.
     */
    public String getTo() {
        return this.to;
    }

    /**
     * A method to get the specific duration of the flight.
     * @return Returns the specific duration of the flight.
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * A method to get the specific number of transfers of the flight.
     * @return Returns the specific number of transfers of the flight.
     */
    public int getNumTransfers() {
        return this.transfers;
    }

    /**
     * A method to return the string representation of all of the 
     * details of the flight, as well as calculating the duration in
     * hours and minutes.
     * @return Returns the string representation of the flight details.
     */
    public String toString() {
        int hours = 0;
        int minutes = this.duration;
        while(minutes >= 60) {
            minutes -= 60;
            hours++;
        }

        String transferAmt;
        if(this.transfers == 0) {
            transferAmt = "Direct Flight\n";
        }
        else if(this.transfers == 1) {
            transferAmt = "1 Transfer\n";
        }
        else {
            transferAmt = this.transfers + " Transfers\n";
        }

        return "Flight Number: " + this.flightNum + "\n" +
            "From: " + this.from + "\n" +
            "To: " + this.to + "\n" +
            "Duration: " + hours + " hours " + minutes + " minutes\n" +
            transferAmt;
    }
}
