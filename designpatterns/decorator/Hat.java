package decorator;

/**
 * Adds a hat to the potato head drawing.
 * @author Ana Boccanfuso
 */
public class Hat extends CharacterDecorator {
    
    /**
     * Inherits the methods of CharacterDecorator using the specific character. 
     * @param character The object that is to be given a hat to.
     */
    public Hat(Character character) {
        super(character);
    }

    /**
     * Manipulates the sections array list to include a hat in the specific indices. 
     */
    public void customize() {
        this.sections.set(0, "    ____");
        this.sections.set(1, " __|____|____");
    }
}
