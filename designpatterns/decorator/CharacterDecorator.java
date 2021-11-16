package decorator;

/**
 * Adds the character's sections to the array list and customizes the character.
 * @author Ana Boccanfuso
 */
public abstract class CharacterDecorator extends Character {
    protected Character character;

    /**
     * Specifies the character and transfers the character's sections into the specific 
     * sections array list. Then calls abstract customize method.
     * @param character The object that is to be drawn and manipulated with additional sections. 
     */
    public CharacterDecorator(Character character) {
        this.character = character;
        for(String string : character.sections) {
            this.sections.add(string);
        }
        customize();
    }

    /**
     * An abstract method that children of the class use to customize their character. 
     */
    public abstract void customize();
}
