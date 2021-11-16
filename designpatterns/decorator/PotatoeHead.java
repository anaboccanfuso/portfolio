package decorator;

/**
 * Populates the sections array list with strings to draw the head of the Potato Head. 
 * @author Ana Boccanfuso
 */
public class PotatoeHead extends Character {

    /**
     * The strings added to the sections array list that make up the Potato Head.
     */
    public PotatoeHead() {
        super();
        this.sections.add(0,"  ");
        this.sections.add(1,"    ____ ");
        this.sections.add(2,"  /      \\ ");
        this.sections.add(3," |        |");
        this.sections.add(4," |        |");
        this.sections.add(5,"  \\      / ");
        this.sections.add(6,"   \\____/");
    }
}