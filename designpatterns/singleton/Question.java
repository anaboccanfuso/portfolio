package singleton;

/**
 * Holds the information for a trivia question, and checks to see if a user's answer is correct.
 * @author Ana Boccanfuso
 */
public class Question {
    private String question;
    private String[] answers;
    private int correctAnswer;

    /**
     * A constructor method to take in the question, possible answers, and the correct answer and 
     * set them to their specific instances. Puts the answers in a String array.
     * @param question The question being asked.
     * @param ans1 The first answer option displayed.
     * @param ans2 The second answer option displayed.
     * @param ans3 The third answer option displayed.
     * @param ans4 The fourth answer option displayed.
     * @param correctAnswer The index of the correct answer (that is zero-based).
     */
    public Question(String question, String ans1, String ans2, String ans3, String ans4, int correctAnswer) {
        this.question = question;
        answers = new String[4];
        answers[0] = ans1;
        answers[1] = ans2;
        answers[2] = ans3;
        answers[3] = ans4;
        this.correctAnswer = correctAnswer;
    }

    /**
     * A method to return the string representation of the question formatted with the possible
     * answers. 
     * @return Returns the string described above.
     */
    public String toString() {
        return question + "\n" + "1. " + answers[0] + "\n" + "2. " + answers[1] + "\n" +
        "3. " + answers[2] + "\n" + "4. " + answers[3] + "\n";
    }

    /**
     * A method to check if the user's input is the correct answer.
     * @param userAnswer The user's guess of the correct answer.
     * @return Returns true if the user's answer is correct, and false if the user's answer
     * is wrong.
     */
    public boolean isCorrect(int userAnswer) {
        if(userAnswer == this.correctAnswer + 1) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * A method to return the string representation of the correct answer in a sentence.
     * @return Returns the string described above.
     */
    public String getCorrectAnswer() {
        return "The correct answer is " + (this.correctAnswer + 1 + "\n");
    }
}
