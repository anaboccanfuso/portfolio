package state;
import java.util.Random;

/**
 * A class that implements State's methods, getting
 * numbers within its range and operations within its
 * range, as well as leveling up or down accordingly.
 */
public class Easy implements State {
    private ArithemeticGame game;

    /**
     * A constructor method that takes in an instance of
     * Arithemetic game, and sets it to the specific instance.
     * @param game The instance of ArithemeticGame being set.
     */
    public Easy(ArithemeticGame game) {
        this.game = game;
    }

    /**
     * A method to generate a random number from 1 to 10.
     * @return Returns the random number between 1 and 10.
     */
    public int getNum() {
        Random r = new Random();
        return r.nextInt(10) + 1;
    }

    /**
     * A method to generate a random operation between +
     * and -. 
     * @return Returns the string representation of the 
     * selected operation.
     */
    public String getOperation() {
        Random r = new Random();
        int result = r.nextInt(2);
        if(result == 0) {
            return "+";
        }
        else {
            return "-";
        }
    }

    /**
     * A method to advance the player to a medium level and 
     * display a message.
     */
    public void levelUp() {
        System.out.println("You've been advanced to medium mode.");
        game.setState(game.getMediumState());
    }

    /**
     * A method to tell the player they are struggling (since
     * they can't level down).
     */
    public void levelDown() {
        System.out.println("You seem to be struggling, you may want to study.");
    }
}
