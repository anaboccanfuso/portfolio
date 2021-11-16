package decorator;

/**
 * Adds eyes to the potato head drawing.
 * @author Ana Boccanfuso
 */
public class Eyes extends CharacterDecorator {
    
    /**
     * Inherits the methods of CharacterDecorator using the specific character. 
     * @param character The object that is to be given eyes to.
     */
    public Eyes(Character character) {
        super(character);
    }

    /**
     * Manipulates the sections array list to include eyes in the specific index. 
     */
    public void customize() {
        this.sections.set(3, " |  o  o  |");
    }
}