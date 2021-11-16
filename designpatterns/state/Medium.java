package state;
import java.util.Random;

/**
 * A class that implements State's methods, getting
 * numbers within its range and operations within its
 * range, as well as leveling up or down accordingly.
 */
public class Medium implements State {
    private ArithemeticGame game;

    /**
     * A constructor method that takes in an instance of
     * Arithemetic game, and sets it to the specific instance.
     * @param game The instance of ArithemeticGame being set.
     */
    public Medium(ArithemeticGame game) {
        this.game = game;
    }

    /**
     * A method to generate a random number from 1 to 50.
     * @return Returns the random number between 1 and 50.
     */
    public int getNum() {
        Random r = new Random();
        return r.nextInt(50) + 1;
    }

    /**
     * A method to generate a random operation between +, 
     * -, and *. 
     * @return Returns the string representation of the 
     * selected operation.
     */
    public String getOperation() {
        Random r = new Random();
        int result = r.nextInt(3);
        if(result == 0) {
            return "+";
        }
        else if(result == 1) {
            return "-";
        }
        else {
            return "*";
        }
    }

    /**
     * A method to advance the player to a hard level and 
     * display a message.
     */
    public void levelUp() {
        System.out.println("You've been advanced to the hardest mode.");
        game.setState(game.getHardState());  
    }

    /**
     * A method to level down the player to an easy level and
     * display a message.
     */
    public void levelDown() {
        System.out.println("You are struggling, let's go to easy mode.");
        game.setState(game.getEasyState());  
    }
}
