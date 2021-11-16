package state;

/**
 * An interface of state to be implemented by its children.
 * Defines the methods all states should do (easy, medium,
 * hard.)
 */
public interface State {

    /**
     * A method that returns a random number based on the 
     * range of the children.
     * @return The random number in the appropriate range.
     */
    public int getNum();

    /**
     * A method that returns a random operation based on the
     * choices of the children classes.
     * @return The string representation of the operation selected.
     */
    public String getOperation();

    /**
     * A method that advances a user from easy to medium state,
     * medium to hard state, or encourages a hard state user.
     */
    public void levelUp();

    /**
     * A method that levels down a user from a medium to easy
     * state, hard to medium state, or encourages an easy state
     * user.
     */
    public void levelDown();
}