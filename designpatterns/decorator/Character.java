package decorator;
import java.util.ArrayList;

/**
 * Creates the array list for the character to be drawn and draws the character. 
 * @author Ana Boccanfuso
 */
public abstract class Character {
    protected ArrayList<String> sections;
    
    /**
     * Initializes the array list of strings for the character to be drawn.
     */
    public Character() {
        this.sections = new ArrayList<String>();
    }

    /**
     * Prints the array list containing strings that make up the character. 
     */
    public void draw() {
        for(String string : sections) {
            System.out.println(string);
        }
    }
}