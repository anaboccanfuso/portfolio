package singleton;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * The singleton class that makes a single trivia game with an arraylist
 * of questions for the game. 
 * @author Ana Boccanfuso
 */
public class TriviaGame {
    private static TriviaGame triviaGame;
    private int score;
    private Random rand;
    private Scanner reader;
    private ArrayList<Question> questions;

    /**
     * A constructor method to read in the questions from the DataLoader to 
     * create the arraylist of questions. Rand and reader are initialized.
     */
    private TriviaGame() {
        this.rand = new Random();
        this.reader = new Scanner(System.in);
        this.questions = DataLoader.getTriviaQuestions();
    }

    /**
     * A method to create the trivia game if it has not been created yet, or 
     * return the trivia game if it has already been made.
     * @return Returns the trivia game that was made or used before. 
     */
    public static TriviaGame getInstance() {
        if(triviaGame == null) {
            triviaGame = new TriviaGame();
        }
        return triviaGame;
    }

    /**
     * A method that keeps the user playing the game, printing out options
     * when appropriate, and printing out the goodbye message if the user chooses
     * to quit.
     */
    public void play() {
        boolean play = true;
        while(play) {
            System.out.print("(P)lay or (Q)uit: ");
            char pQ = reader.next().charAt(0);
            if(pQ == 'p' || pQ == 'P') {
                playRound();
            }
            else if(pQ == 'q' || pQ == 'Q') {
                System.out.println("\nYou won " + score + " games!\nGoodbye");
                play = false;
            }
            else {
                System.out.println("That is invalid.");
            }
        }
        System.exit(0);
    }

    /**
     * A method to pick a random trivia question based on the length of the 
     * arraylist. It displays the question, asks the user to enter an answer,
     * and checks if it is correct or not. It displays the correct answer to the 
     * user and returns if the user's answer was correct or not.
     * @return Returns true if the user's answer is the correct answer, and false
     * if the user's answer is not the correct answer.
     */
    private boolean playRound() {
        int length = this.questions.size();
        int randNum = rand.nextInt(length);
        Question randQuestion = this.questions.get(randNum);
        System.out.println("\n" + randQuestion);
        System.out.print("Enter answer: ");
        int answer = reader.nextInt();
        if(randQuestion.isCorrect(answer)) {
            System.out.println("YAY! You got it right!\n");
            return true;
        }
        else {
            System.out.println("You got it wrong!\n" + randQuestion.getCorrectAnswer());
        }
        return false;
    }
}
