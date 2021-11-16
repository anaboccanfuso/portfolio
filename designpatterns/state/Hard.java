package state;
import java.util.Random;

/**
 * A class that implements State's methods, getting
 * numbers within its range and operations within its
 * range, as well as leveling up or down accordingly.
 */
public class Hard implements State {
    private ArithemeticGame game;

    /**
     * A constructor method that takes in an instance of
     * Arithemetic game, and sets it to the specific instance.
     * @param game The instance of ArithemeticGame being set.
     */
    public Hard(ArithemeticGame game) {
        this.game = game;
    }

    /**
     * A method to generate a random number from 1 to 100.
     * @return Returns the random number between 1 and 100.
     */
    public int getNum() {
        Random r = new Random();
        return r.nextInt(100) + 1;
    }

    /**
     * A method to generate a random operation between +, 
     * -, *, and /. 
     * @return Returns the string representation of the 
     * selected operation.
     */
    public String getOperation() {
        Random r = new Random();
        int result = r.nextInt(4);
        if(result == 0) {
            return "+";
        }
        else if(result == 1) {
            return "-";
        }
        else if(result == 2) {
            return "*";
        }
        else {
            return "/";
        }
    }

    /**
     * A method that displays an encouraging message since the 
     * player cannot advance levels.
     */
    public void levelUp() {
        System.out.println("You are doing so well!!!");
    }

    /**
     * A method to level down the player to a medium level and
     * display a message.
     */
    public void levelDown() {
        System.out.println("You are struggling, let's go to medium mode.");
        game.setState(game.getMediumState());
    }
}
