package decorator;

/**
 * Adds a mouth to the potato head drawing.
 * @author Ana Boccanfuso
 */
public class Mouth extends CharacterDecorator{
    
    /**
     * Inherits the methods of CharacterDecorator using the specific character. 
     * @param character The object that is to be given a mouth to.
     */
    public Mouth(Character character) {
        super(character);
    }

    /**
     * Manipulates the sections array list to include a mouth in the specific index. 
     */
    public void customize() {
        this.sections.set(5, "  \\ ---- /");
    }
}