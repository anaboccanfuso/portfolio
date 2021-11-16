package state;
import java.util.Scanner;

/**
 * A class that displays the game, gets user input, and 
 * changes levels accordingly. 
 * @author Ana Boccanfuso
 */
public class ArithemeticGame {
    private State easyState;
    private State mediumState;
    private State hardState;

    private State state;
    private int score = 0;
    Scanner keyboard;

    /**
     * A public method to set the state variables to their 
     * respective classes, as well as starting state to easy.
     * It also initializes a scanner for user input and sets
     * the score to zero.
     */
    public ArithemeticGame() {
        easyState = new Easy(this);
        mediumState = new Medium(this);
        hardState = new Hard(this);

        state = new Easy(this);
        keyboard = new Scanner(System.in);

        this.score = 0;
    }

    /**
     * A public method to generate 2 numbers from the level's
     * range, an operation from the level's range, and get input
     * from the user with their answer. Checks if correct, and 
     * adjusts score accordingly, and if they need to change
     * level (state).
     */
    public void pressQuestionButton() {
        int num1 = state.getNum();
        int num2 = state.getNum();
        String op = state.getOperation();
        System.out.print(num1 + " " + op + " " + num2 + ": ");
        int answer = keyboard.nextInt();
        keyboard.nextLine();
        if(op.equals("+")) {
            if(answer == (num1+num2)) {
                System.out.println("Correct");
                score++;
            }
            else {
                System.out.println("Incorrect");
                score--;
            }
        }
        else if(op.equals("-")) {
            if(answer == (num1-num2)) {
                System.out.println("Correct");
                score++;
            }
            else {
                System.out.println("Incorrect");
                score--;
            }
        }
        else if(op.equals("*")) {
            if(answer == (num1*num2)) {
                System.out.println("Correct");
                score++;
            }
            else {
                System.out.println("Incorrect");
                score--;
            }
        }
        else {
            if(answer == (num1/num2)) {
                System.out.println("Correct");
                score++;
            }
            else {
                System.out.println("Incorrect");
                score--;
            }
        }
        if(score >= 3) {
            state.levelUp();
            score = 0;
        }
        else if(score <= -3) {
            state.levelDown();
            score = 0;
        }
    }

    /**
     * A method that takes in the current state and sets it to 
     * the new state. 
     * @param state The state that it should be changed to 
     * (easy/medium/hard)
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * A method that returns the easy state.
     * @return Returns the easy state variable.
     */
    public State getEasyState() {
        return easyState;
    }

    /**
     * A method that returns the medium state.
     * @return Returns the medium state variable.
     */
    public State getMediumState() {
        return mediumState;
    }

    /**
     * A method that returns the hard state.
     * @return Returns the hard state variable.
     */
    public State getHardState() {
        return hardState;
    }
}
