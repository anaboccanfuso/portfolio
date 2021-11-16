package decorator;

/**
 * Adds a nose to the potato head drawing.
 * @author Ana Boccanfuso
 */
public class Nose extends CharacterDecorator{
    
    /**
     * Inherits the methods of CharacterDecorator using the specific character. 
     * @param character The object that is to be given a nose to.
     */
    public Nose(Character character) {
        super(character);
    }

    /**
     * Manipulates the sections array list to include a nose in the specific index. 
     */
    public void customize() {
        this.sections.set(4, " |   >    |");
    }
}